package com.trytara.tara.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Item")
public class Item extends ParseObject {

    private static final String TITLE = "title";
    private static final String PRICE = "price";
    private static final String DESCRIPTION = "description";
    private static final String CATEGORY = "category";

    public Item() {
    }

    public String getTitle() {
        return getString(TITLE);
    }

    public void setTitle(String title) {
        put(TITLE, title);
    }

    public Double getPrice() {
        return getDouble(PRICE);
    }

    public String getDescription() {
        return getString(DESCRIPTION);
    }

    public void setDescription(String description) {
        put(DESCRIPTION, description);
    }

    public String getCategory() {
        return getString(CATEGORY);
    }

    public void setCategory(String title) {
        put(CATEGORY, title);
    }
}
