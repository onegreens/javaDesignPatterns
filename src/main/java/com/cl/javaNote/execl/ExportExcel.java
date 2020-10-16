package com.cl.javaNote.execl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {

    public static void main(String[] args) {
        List<Map> dataset = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map map = new HashMap();

            map.put("area", "area" + i);
            map.put("time", "time" + i);
            map.put("index", "index" + i);
            dataset.add(map);
        }
        String fileName = "cs.xls";
        Workbook workbook = initWorkbook(fileName);
        exportExcel(workbook, "cs", new String[]{"area", "time"}, dataset, null);
        outWorkbook(workbook, fileName);
    }

    public static void outWorkbook(Workbook workbook, String fileName) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            //.info("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            //.info("文件写入错误");
            e.printStackTrace();

        }
    }

    public static Workbook initWorkbook(String fileName) {
        Workbook workbook = null;
        if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            try {
                throw new Exception("invalid file name, should be xls or xlsx");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return workbook;
    }

    public static boolean exportExcel(Workbook workbook, String title, String[] headers, List<Map> dataset, String pattern) {

        boolean flag = false;

        Sheet sheet = workbook.createSheet(title);
        CellStyle style = workbook.createCellStyle();

        // 列名
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            sheet.setColumnWidth(i, 5000);
            style.setAlignment(CellStyle.ALIGN_CENTER);
            cell.setCellValue(headers[i]);
        }

        Iterator<Map> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);

            Map map = it.next();
            //.info(map.toString());
            Set<String> mapKey = (Set<String>) map.keySet();
            //.info(mapKey.toString());
            Iterator<String> iterator = mapKey.iterator();
            //.info(iterator.toString());
            int num = 0;
            while (iterator.hasNext()) {
                Cell cell = row.createCell(num);
                num++;
                String key = iterator.next();
                //.info(key);
                Object obj = map.get(key);
                if (obj instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    cell.setCellValue(sdf.format(obj));
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                } else {
                    cell.setCellValue((String) obj);
                }
            }
        }

        return flag;
    }
}
