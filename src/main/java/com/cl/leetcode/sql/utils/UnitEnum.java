package com.cl.leetcode.sql.utils;

public enum UnitEnum {
    STRING("class java.lang.String", "VARCHAR"),
    INTEGER("class java.lang.Integer", "INT"),
    DATE("class java.lang.Integer", "DATE"),
    DATETIME("class java.lang.Integer", "DATETIME"),
    LONG("class java.lang.Long", "LONG");
    private String clazz;
    private String unit;

    UnitEnum(String clazz, String unit) {
        this.clazz = clazz;
        this.unit = unit;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
