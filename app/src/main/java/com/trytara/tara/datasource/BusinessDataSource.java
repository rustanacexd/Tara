package com.trytara.tara.datasource;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.trytara.tara.models.Business;

import java.util.ArrayList;
import java.util.List;

public class BusinessDataSource {

    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_CONTACT_NUMBER = "contactNumber";
    private static final String KEY_ADDRESS = "address";

    public BusinessDataSource() {
    }

    public static void getAllBusinesses(final BusinessDataCallbacks callback) {

        /*ParseQuery<ParseObject> itemsQuery = ParseQuery.getQuery("Item");
        itemsQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(final List<ParseObject> itemsList, ParseException e) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Business");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, ParseException e) {
                        if (e == null) {
                            Log.d("DEBUG", "Business List: " + list);
                            List<Business> businessList = new ArrayList<>();
                            for (ParseObject object : list) {
                                businessList.add(parseObjectToBusiness(object));
                                object.put("items", itemsList);
                                object.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {
                                        Log.d("DEBUG", "object updated");
                                    }
                                });
                            }

                            if (callback != null) {
                                callback.onBusinessListFetch(businessList);
                            }

                        } else {
                            Log.d("DEBUG", e.getLocalizedMessage());
                        }
                    }
                });
            }
        });*/


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Business");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    Log.d("DEBUG", "Business List: " + list);
                    List<Business> businessList = new ArrayList<>();
                    for (ParseObject object : list) {
                        businessList.add(parseObjectToBusiness(object));
                    }

                    if (callback != null) {
                        callback.onBusinessListFetch(businessList);
                    }

                } else {
                    Log.d("DEBUG", e.getLocalizedMessage());
                }
            }
        });


    }


    private static Business parseObjectToBusiness(ParseObject object) {
        return new Business.BusinessBuilder(
                object.getObjectId(),
                object.getString(KEY_NAME),
                object.getString(KEY_DESCRIPTION),
                object.getString(KEY_CONTACT_NUMBER),
                object.getString(KEY_ADDRESS)
        ).build();
    }

    public interface BusinessDataCallbacks {
        public void onBusinessListFetch(List<Business> businessList);
    }

}