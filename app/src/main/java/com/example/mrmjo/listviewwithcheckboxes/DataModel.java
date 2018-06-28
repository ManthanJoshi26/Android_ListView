package com.example.mrmjo.listviewwithcheckboxes;

public class DataModel {

    public String name;
    public String version;
    boolean checked;

    DataModel(String name, String version, boolean checked) {
        this.name = name;
        this.version = version;
        this.checked = checked;

    }
}