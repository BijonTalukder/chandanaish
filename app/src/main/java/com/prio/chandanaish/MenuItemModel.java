package com.prio.chandanaish;

public class MenuItemModel {
    private final String title;
    private final int imageResId;

    public MenuItemModel(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}
