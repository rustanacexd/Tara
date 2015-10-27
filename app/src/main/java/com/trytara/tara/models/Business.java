package com.trytara.tara.models;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

@ParseClassName("Business")
public class Business extends ParseObject {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String ADDRESS = "address";
    private static final String ITEMS = "items";

    public Business() {
    }

    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public String getDescription() {
        return getString(DESCRIPTION);
    }

    public void setDescription(String description) {
        put(DESCRIPTION, description);
    }

    public String getAddress() {
        return getString(ADDRESS);
    }

    public void setAddress(String address) {
        put(ADDRESS, address);
    }

    public static void getAllBusinesses(final OnBusinessListFetchListener callback) {
        ParseQuery<Business> query = ParseQuery.getQuery(Business.class);
        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
        query.findInBackground(new FindCallback<Business>() {
            @Override
            public void done(List<Business> list, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onBusinessListFetch(list);
                    }
                } else {
                    Log.d("DEBUG", e.getLocalizedMessage());
                }
            }
        });
    }

    public static void getBusiness(String businessId, final OnGetSelectedBusinessListener callback) {
        ParseQuery<Business> query = ParseQuery.getQuery(Business.class);
        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
        query.include(ITEMS);
        query.getInBackground(businessId, new GetCallback<Business>() {
            @Override
            public void done(Business business, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetSelectedBusiness(business);
                    }

                } else {
                    Log.d("DEBUG", e.getLocalizedMessage());
                }
            }
        });
    }

    public List<Item> getItems() {
        return (List<Item>) this.get("items");
    }

    public interface OnBusinessListFetchListener {
        void onBusinessListFetch(List<Business> businessList);
    }

    public interface OnGetSelectedBusinessListener {
        void onGetSelectedBusiness(Business business);
    }

    @Override
    public String toString() {
        return "Business{" + getName() + "}";
    }
}
