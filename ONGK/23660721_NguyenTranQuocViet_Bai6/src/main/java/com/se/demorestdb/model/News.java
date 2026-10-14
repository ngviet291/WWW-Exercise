package com.se.demorestdb.model;

public class News {
    private int id;
    private String title;
    private String content;
    private String url;
    private String category;

    public News() {
    }

    public News(int id, String title, String content, String url, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
