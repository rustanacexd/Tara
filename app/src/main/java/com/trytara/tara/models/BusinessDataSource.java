package com.trytara.tara.models;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class BusinessDataSource {

    public BusinessDataSource() {
    }

    public static void getAllBusinesses(final BusinessDataCallbacks callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Business");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    Log.d("DEBUG", list.toString());
                    List<Business> businessList = new ArrayList<>();
                    for (ParseObject object : list) {
                        businessList.add(parseObjectToBusiness(object));
                    }

                    if (callback != null) {
                        callback.onBusinessesFetch(businessList);
                    }

                } else {
                    Log.d("DEBUG", e.getLocalizedMessage());
                }
            }
        });

    }

    private static Business parseObjectToBusiness(ParseObject object) {
        return new Business.BusinessBuilder(
                object.getString("name"),
                object.getString("description"),
                object.getString("contactNumber"),
                object.getString("address")
        ).build();
    }

    public interface BusinessDataCallbacks {
        public void onBusinessesFetch(List<Business> businesses);
    }

}