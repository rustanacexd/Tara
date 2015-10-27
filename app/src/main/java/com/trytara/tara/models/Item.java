package com.trytara.tara.models;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

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

    public static void getAllItems(final OnGetAllItemsListener callback) {
        ParseQuery<Item> query = ParseQuery.getQuery(Item.class);
        query.findInBackground(new FindCallback<Item>() {
            @Override
            public void done(List<Item> list, ParseException e) {
                if (e == null) {
                    Log.d("DEBUG", "Item Lists: " + list);

                    if (callback != null) {
                        callback.OnGetAllItems(list);
                    }

                } else {
                    Log.d("DEBUG", e.getLocalizedMessage());
                }
            }
        });
    }

    public static void getItems(Business business, OnGetAllItemsListener callback) {
        if (callback != null) {
            ArrayList<Item> itemList = (ArrayList<Item>) business.get("items");
            callback.OnGetAllItems(itemList);
        }
    }

    public interface OnGetAllItemsListener {
        void OnGetAllItems(List<Item> itemList);
    }

    public interface OnGetItemsListener {
        void onGetItems(List<Item> itemList);
    }

}
