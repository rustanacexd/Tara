package com.trytara.tara.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.trytara.tara.models.Business.BusinessBuilder;
import static com.trytara.tara.models.Business.ReviewBuilder;

public class BusinessDataSource implements BusinessDAO {

    private static BusinessDataSource sBusinessDataSource;
    private List<Business> mBusinesses;
    private Context mContext;


    private BusinessDataSource(Context context) {
        mContext = context.getApplicationContext();
        mBusinesses = createBusinessList(200);
    }

    public synchronized static BusinessDataSource get(Context context) {
        if (sBusinessDataSource == null) {
            sBusinessDataSource = new BusinessDataSource(context);
        }

        return sBusinessDataSource;
    }

    private List<Business> createBusinessList(int numBusiness) {
        List<Business> businesses = new ArrayList<>();
        for (int i = 1; i <= numBusiness; i++) {


            Business business = new BusinessBuilder("Business " + i, "Lorem ipsum nonsense " +
                    "lol", "062-2142406", "Pagadian City").build();

            for (int j = 0; j <= 10; j++) {
                String temporaryReviewContent = "Review " + j + " Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                        "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam";
                business.addReview(new ReviewBuilder(temporaryReviewContent, 4.5f, "Reviewer Full name " + j).build());
            }

            businesses.add(business);
        }

        return businesses;
    }


    @Override
    public List<Business> getAllBusinesses() {
        return mBusinesses;
    }

    @Override
    public Business getBusiness(int id) {
        return mBusinesses.get(id);
    }

    @Override
    public void updateBusiness(Business business) {

    }

    @Override
    public void deleteBusiness(Business business) {

    }

}
