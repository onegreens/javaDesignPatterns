package com.cl.javaNote.execl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cl on 2017/8/17.
 * 读取一个excel文件
 */
public class ExcelReader_MapList {
    private int fistRow;
    private static String key = "key=";
    private int maxCloumn = 0;
    File resource2 ;

    private List<Map<String, Object>> mapsList;

    public ExcelReader_MapList(File file, int fistRow) {
        this.resource2 = file;
        this.fistRow = fistRow;
        mapsList = new ArrayList<>();
    }

    public List<Map<String, Object>> init() throws IOException {
        readExcel(resource2);
        return mapsList;
    }

    private void readExcel(File file) {
        Workbook wb = getWorkbook(file);
        handlerSheet(wb);
        /** 返回最后读取的结果 */
    }

    private void handlerSheet(Workbook wb) {
        int sheetNumber = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNumber; i++) {
            Sheet sheet = wb.getSheetAt(i);
            handlerRow(sheet);

        }
    }

    void handlerRow(Sheet sheet) {
        int rowNum = sheet.getLastRowNum();
        for (int i = fistRow; i < rowNum; i++) {
            Map<String, Object> map = new HashMap();
            map.put("rowNum", i);
            Row row = sheet.getRow(i);
            handlerCell(map, row);
            mapsList.add(map);
        }
    }

    void handlerCell(Map<String, Object> map, Row row) {
        int cellNum = row.getLastCellNum();
        maxCloumn = Math.max(maxCloumn, cellNum);
        for (int i = 0; i < cellNum; i++) {
            Cell cell = row.getCell(i);

            map.put(key + i, getCellValue(cell));
        }
    }


    private Workbook getWorkbook(CommonsMultipartFile file) {
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

    private Workbook getWorkbook(File resource) {
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

    void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();

            } catch (IOException e) {
                is = null;
                e.printStackTrace();
            }
        }
    }

    private Workbook getWorkbook(boolean isExcel2003, InputStream is) {
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

    String getCellValue(Cell cell) {
        String cellvalue = null;
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC: {
                    short format = cell.getCellStyle().getDataFormat();
                    if (format == 14 || format == 31 || format == 57 || format == 58) {   //excel中的时间格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                        cellvalue = sdf.format(date);
                    }
                    // 判断当前的cell是否为Date
                    else if (HSSFDateUtil.isCellDateFormatted(cell)) {  //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                        // 如果是Date类型则，取得该Cell的Date值           // 对2014-02-02格式识别不出是日期格式
                        Date date = cell.getDateCellValue();
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = formater.format(date);
                    } else { // 如果是纯数字
                        // 取得当前Cell的数值
                        cellvalue = NumberToTextConverter.toText(cell.getNumericCellValue());

                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getStringCellValue().replaceAll("'", "''");
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    cellvalue = null;
                    break;
                // 默认的Cell值
                default: {
                    cellvalue = "";
                }
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }


    public int getFistRow() {
        return fistRow;
    }

    public void setFistRow(int fistRow) {
        this.fistRow = fistRow;
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        ExcelReader_MapList.key = key;
    }

    public int getMaxCloumn() {
        return maxCloumn;
    }

    public void setMaxCloumn(int maxCloumn) {
        this.maxCloumn = maxCloumn;
    }
}
