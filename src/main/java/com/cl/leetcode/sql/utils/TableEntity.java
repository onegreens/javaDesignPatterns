package com.cl.leetcode.sql.utils;

import java.util.List;

public class TableEntity {
    public TableEntity() {
    }

    public TableEntity(String name) {
        this.name = name;
    }

    private String name;
    private List<ColumnEntity> columnEntities;
    private List<List<Object>> datas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ColumnEntity> getColumnEntities() {
        return columnEntities;
    }

    public void setColumnEntities(List<ColumnEntity> columnEntities) {
        this.columnEntities = columnEntities;
    }

    public List<List<Object>> getDatas() {
        return datas;
    }

    public void setDatas(List<List<Object>> datas) {
        this.datas = datas;
    }
}
