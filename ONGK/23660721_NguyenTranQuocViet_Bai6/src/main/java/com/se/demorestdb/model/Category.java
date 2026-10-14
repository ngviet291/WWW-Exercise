package com.se.demorestdb.model;

public class Category {
    private int id;
    private String name;
    private String manager;
    private String note;


    public Category() {
    }

    public Category(int id, String name, String manager, String note) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
