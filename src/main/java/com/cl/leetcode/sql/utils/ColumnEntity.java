package com.cl.leetcode.sql.utils;

public class ColumnEntity {
    private String name;
    private String type;
    private Integer number;

    public ColumnEntity() {
    }

    public ColumnEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number == null ? 0 : number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
