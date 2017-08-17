package com.cl.javaNote.execl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cl on 2017/8/17.
 * 读取一个excel文件
 */
public class ExcelReader_MapList {
    public static void main(String[] args) throws IOException {
        File resource2 = new File("D:\\123.xlsx");
        List<Map<String, Object>> mapList = readExcel(resource2);
        for (Map<String, Object> map:mapList){
            System.out.println(map);
        }
    }

    public static List<Map<String, Object>> readExcel(CommonsMultipartFile file) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Workbook wb = getWorkbook(file);
        mapList = handlerSheet(wb);
        /** 返回最后读取的结果 */
        return mapList;
    }

    public static List<Map<String, Object>> readExcel(File file) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Workbook wb = getWorkbook(file);
        mapList = handlerSheet(wb);
        /** 返回最后读取的结果 */
        return mapList;
    }

    public static List<Map<String, Object>> handlerSheet(Workbook wb) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        int sheetNumber = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNumber; i++) {
            Sheet sheet = wb.getSheetAt(i);
            handlerRow(mapList, sheet);

        }
        return mapList;
    }

    static void handlerRow(List<Map<String, Object>> mapsList, Sheet sheet) {
        int rowNum = sheet.getLastRowNum();
        for (int i = 0; i < rowNum; i++) {
            Map<String, Object> map = new HashMap();
            map.put("rowNum", i);
            Row row = sheet.getRow(i);
            handlerCell(map, row);
            mapsList.add(map);
        }
    }

    static void handlerCell(Map<String, Object> map, Row row) {
        int cellNum = row.getLastCellNum();
        for (int i = 0; i < cellNum; i++) {
            Cell cell = row.getCell(i);
            map.put("cellnum=" + i, cell.getStringCellValue());
        }
    }


    public static Workbook getWorkbook(CommonsMultipartFile file) {
        InputStream is = null;
        Workbook wb = null;
        boolean isExcel2003 = true;
        try {
            /** 判断文件的类型，是2003还是2007 */
            if (ExcelUtil.isExcel2007(file.getOriginalFilename())) {
                isExcel2003 = false;
            }
            /** 调用本类提供的根据流读取的方法 */
            is = file.getInputStream();
            wb = getWorkbook(isExcel2003, is);
            is.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeInputStream(is);
        }
        return wb;
    }

    public static Workbook getWorkbook(File resource) {
        InputStream is = null;
        Workbook wb = null;
        boolean isExcel2003 = true;
        try {
            /** 判断文件的类型，是2003还是2007 */
            if (ExcelUtil.isExcel2007(resource.getName())) {
                isExcel2003 = false;
            }
            /** 调用本类提供的根据流读取的方法 */
            is = new FileInputStream(resource);
            wb = getWorkbook(isExcel2003, is);
            is.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            closeInputStream(is);
        }
        return wb;
    }

    static void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();

            } catch (IOException e) {
                is = null;
                e.printStackTrace();
            }
        }
    }

    public static Workbook getWorkbook(boolean isExcel2003, InputStream is) {
        Workbook wb = null;
        try {
            /** 调用本类提供的根据流读取的方法 */

            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }

            is.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            closeInputStream(is);
        }
        return wb;
    }


}
