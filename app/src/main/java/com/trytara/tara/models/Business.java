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

import static com.trytara.tara.models.Category.CategoryType;

@ParseClassName("Business")
public class Business extends ParseObject {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String ADDRESS = "address";
    private static final String ITEMS = "items";
    private static final String CATEGORY = "category";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String MOBILE_PHONE_NUMBER = "mobilePhoneNumber";
    private static final String EMAIL = "email";
    private static final String ABOUT = "about";
    private static final int MAX_CACHE_AGE = 1000 * 60 * 60 * 48;
    private static final String AVERAGE_RATE = "averageRate";
    private static final String REVIEWS = "reviews";
    private static final String TAG_LINE = "tagline";


    public Business() {
    }

    public String getEmail() {
        return getString(EMAIL);
    }

    public void setEmail(String email) {
        put(EMAIL, email);
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

    public void setDescription(String about) {
        put(DESCRIPTION, about);
    }

    public String getAbout() {
        return getString(ABOUT) != null ? getString(ABOUT) : "";
    }

    public void setAbout(String about) {
        put(ABOUT, about);
    }

    public String getAddress() {
        return getString(ADDRESS);
    }

    public void setAddress(String address) {
        put(ADDRESS, address);
    }

    public String getCategory() {
        return getString(CATEGORY);
    }

    public void setCategory(CategoryType categoryType) {
        put(CATEGORY, categoryType.toString());
    }

    public String getPhoneNumber() {
        return getString(PHONE_NUMBER) != null ? getString(PHONE_NUMBER) : "";
    }

    public void setPhoneNumber(String number) {
        put(PHONE_NUMBER, number);
    }

    public String getMobilePhoneNumber() {
        return getString(MOBILE_PHONE_NUMBER);
    }

    public void setMobilePhoneNumber(String number) {
        put(MOBILE_PHONE_NUMBER, number);
    }

    public float averageRate() {
        return (float) getDouble(AVERAGE_RATE);
    }

    public void setAverageRate(Double rating) {
        put(AVERAGE_RATE, rating);
    }

    public List<Review> getReviews() {
        return getList(REVIEWS);
    }

    public String getTagLine() {
        return getString(TAG_LINE);
    }

    public void setTagLine(String tagLine) {
        put(TAG_LINE, tagLine);
    }

    public static ParseQuery<Business> getQuery() {
        return ParseQuery.getQuery(Business.class);
    }

    public static void getAllBusiness(final OnGetAllBusinessCallback callback) {
        getQuery().setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY);
        getQuery().findInBackground(new FindCallback<Business>() {
            @Override
            public void done(List<Business> list, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetAllBusiness(list);
                    }
                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });
    }

    public static void getBusinessListByCategory(String slug,
                                                 final OnGetBusinessListByCategoryCallback callback) {

        getQuery().setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY);
        //query.setMaxCacheAge(MAX_CACHE_AGE);
        getQuery().whereEqualTo(CATEGORY, slug);
        getQuery().findInBackground(new FindCallback<Business>() {
            @Override
            public void done(List<Business> list, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetBusinessListByCategory(list);
                    }
                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });
    }

    public static void getBusiness(String businessId, final OnGetBusinessCallback callback) {
        getQuery().setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY);
        //query.setMaxCacheAge(MAX_CACHE_AGE);
        getQuery().getInBackground(businessId, new GetCallback<Business>() {
            @Override
            public void done(Business business, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetBusiness(business);
                    }

                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });
    }


    public List<Item> getItems() {
        return (List<Item>) this.get("items");
    }

    public interface OnGetAllBusinessCallback {
        void onGetAllBusiness(List<Business> businessList);
    }

    public interface OnGetBusinessCallback {
        void onGetBusiness(Business business);
    }

    public interface OnGetBusinessListByCategoryCallback {
        void onGetBusinessListByCategory(List<Business> businessList);
    }


    @Override
    public String toString() {
        return "Business{" + getName() + "}";
    }
}
