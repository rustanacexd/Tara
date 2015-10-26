package com.trytara.tara.datasource;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.POJOBusiness;

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

        ParseQuery<Business> query = ParseQuery.getQuery(Business.class);
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


    private static POJOBusiness parseObjectToBusiness(ParseObject object) {
        return new POJOBusiness.BusinessBuilder(
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