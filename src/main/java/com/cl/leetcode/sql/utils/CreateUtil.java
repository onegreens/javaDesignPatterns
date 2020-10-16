package com.cl.leetcode.sql.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateUtil {
    public static void insert(TableEntity tableEntity) {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into ");
        sql.append(tableEntity.getName());
        sql.append(" values ");
        List<List<Object>> datas = tableEntity.getDatas();
        for (int i = 0; i < datas.size(); i++) {
            if (i != 0) sql.append(",");
            sql.append(datas.get(i).toString().replace("[", "(").replace("]", ")"));
        }
        sql.append(" ; ");
        System.out.println(sql);
    }

    public static void createTable(TableEntity tableEntity) {
        StringBuffer sql = new StringBuffer();
        sql.append("create table ");
        sql.append(tableEntity.getName());
        sql.append(" ( ");
        List<ColumnEntity> columnEntities = tableEntity.getColumnEntities();
        if (columnEntities != null && columnEntities.size() > 0)
            for (int i = 0; i < columnEntities.size(); i++) {
                if (i != 0) sql.append(",");
                sql.append(" ")
                        .append(columnEntities.get(i).getName())
                        .append(" ")
                        .append(columnEntities.get(i).getType());
                if (!(columnEntities.get(i).getType().equals(UnitEnum.DATE.getUnit()) || columnEntities.get(i).getType().equals(UnitEnum.DATETIME.getUnit()))) {
                    sql.append(" (")
                            .append(columnEntities.get(i).getNumber())
                            .append(" )");
                }

                if (i == 0)
                    sql.append("  PRIMARY KEY");
            }
        sql.append(" ); ");
        System.out.println(sql);
    }

    public static void parseJson(String json) {
        try {
            Map<String, Object> obj = JSONHelper.json2Map(json);
            Map<String, Object> headers = (Map<String, Object>) obj.get("headers");
            Map<String, Object> rows = (Map<String, Object>) obj.get("rows");
            for (String tableName : headers.keySet()) {
                TableEntity tableEntity = new TableEntity(tableName);
                List<ColumnEntity> columnEntities = new ArrayList<>();
                List<String> columns = (List<String>) headers.get(tableName);
                for (int i = 0; i < columns.size(); i++) {
                    columnEntities.add(new ColumnEntity(columns.get(i)));
                }
                List<List<Object>> datas = (List<List<Object>>) rows.get(tableName);
                for (int i = 0; i < datas.size(); i++) {
                    List<Object> data = datas.get(i);
                    for (int j = 0; j < data.size(); j++) {
                        Object val = data.get(j);
                        if (i == 0) {
                            if (val.getClass().toString().equals(UnitEnum.INTEGER.getClazz())) {
                                columnEntities.get(j).setType(UnitEnum.INTEGER.getUnit());
                            } else if (val.getClass().toString().equals(UnitEnum.LONG.getClazz())) {
                                columnEntities.get(j).setType(UnitEnum.LONG.getUnit());
                            } else if (val.toString().contains("-")) {
                                if (val.toString().contains(":")) {
                                    columnEntities.get(j).setType(UnitEnum.DATETIME.getUnit());
                                } else {
                                    columnEntities.get(j).setType(UnitEnum.DATE.getUnit());
                                }
                            } else {
                                columnEntities.get(j).setType(UnitEnum.STRING.getUnit());

                            }
                        }

                        if (val.toString().length() > columnEntities.get(j).getNumber()) {
                            columnEntities.get(j).setNumber(val.toString().length());
                        }
                    }

                }
                tableEntity.setColumnEntities(columnEntities);
                tableEntity.setDatas(datas);
                createTable(tableEntity);
                insert(tableEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
