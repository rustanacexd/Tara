package com.trytara.tara.models;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.App;

import java.util.List;

@ParseClassName("Item")
public class Item extends ParseObject {

    private static final String TITLE = "title";
    private static final String PRICE = "price";
    private static final String DESCRIPTION = "description";
    private static final String CATEGORY = "category";
    private static final String AVERAGE_RATE = "averageRate";
    private static final String BUSINESS = "business";

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

    public void setPrice(Double price) {
        put(PRICE, price);
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

    public Double getAverageRate() {
        return getDouble(AVERAGE_RATE);
    }

    public void setAverageRate(Double rating) {
        put(AVERAGE_RATE, rating);
    }

    public void setBusiness(ParseObject object) {
        put(BUSINESS, object);
    }

    public static void getAllItems(final OnGetAllItemsCallback callback) {
        ParseQuery<Item> query = ParseQuery.getQuery(Item.class);
        query.findInBackground(new FindCallback<Item>() {
            @Override
            public void done(List<Item> list, ParseException e) {
                if (e == null) {
                    Log.d(App.TAG, "getAllItems: " + list);

                    if (callback != null) {
                        callback.OnGetAllItems(list);
                    }

                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });
    }

    public static void getItem(String itemId, final OnGetItemCallback callback) {
        ParseQuery<Item> query = ParseQuery.getQuery(Item.class);
        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
        query.getInBackground(itemId, new GetCallback<Item>() {
            @Override
            public void done(Item item, ParseException e) {
                if (e == null) {
                    Log.d(App.TAG, "getItem: " + item.toString());
                    if (callback != null) {
                        callback.onGetItem(item);
                    }
                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });
    }

    public static void getItemsByBusiness(Business business, final OnGetItemsByBusinessCallback callback) {
        ParseQuery<Item> itemParseQuery = ParseQuery.getQuery(Item.class);
        itemParseQuery.findInBackground(new FindCallback<Item>() {
            @Override
            public void done(List<Item> list, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetItemsByBusiness(list);
                    }
                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public String toString() {
        return "Item{" + getTitle() + "}";
    }

    public interface OnGetAllItemsCallback {
        void OnGetAllItems(List<Item> itemList);
    }

    public interface OnGetItemCallback {
        void onGetItem(Item item);
    }

    public interface OnGetItemsByBusinessCallback {
        void onGetItemsByBusiness(List<Item> itemList);
    }

}
