package com.hob.zahidhasan.sqlitedb;

/**
 * Created by zahid on 10/4/2017.
 */

public class Categories {
    private int id;
    private int parentId;
    private String categoryName;

    public Categories(int id, int parentId, String categoryName) {
        this.id = id;
        this.parentId = parentId;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public Categories() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
