package edu.hawaii.its.mis.service;

public class Result {

    private String value;

    // Constructor.
    public Result(String value) {
        this.value = nv(value);
    }

    public String getValue() {
        return value;
    }

    public int getLength() {
        return value.length();
    }

    // Helper method.
    protected String nv(String s) {
        return s != null ? s : "";
    }
}
