package com.trytara.tara.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import static com.trytara.tara.models.Business.BusinessBuilder;
import static com.trytara.tara.models.Business.ReviewBuilder;

public class BusinessDataSource implements BusinessDAO {

    private static BusinessDataSource sBusinessDataSource;
    private List<Business> mBusinesses;
    private Context mContext;


    private BusinessDataSource(Context context) {
        mContext = context.getApplicationContext();
        mBusinesses = createBusinessList(200, 20, 20);
    }

    public synchronized static BusinessDataSource get(Context context) {
        if (sBusinessDataSource == null) {
            sBusinessDataSource = new BusinessDataSource(context);
        }

        return sBusinessDataSource;
    }

    private List<Business> createBusinessList(int numBusiness, int numReviews, int numItems) {
        List<Business> businesses = new ArrayList<>();
        for (int i = 1; i <= numBusiness; i++) {


            Business business = new BusinessBuilder("Business " + i, "Lorem ipsum grabeh ka nonsense lol Lorem ipsum grabeh ka nonsense lol" +
                    "lol", "062-2142406", "Pagadian City").build();

            String temporaryReviewContent = "Review Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam";

            for (int j = 0; j <= numItems; j++) {
                String temporaryItemContent = "Temporary Business Item " + j;
                Business.Item item = new Business.ItemBuilder(temporaryItemContent, 400.0).build();

                for (int k = 0; k <= numReviews; k++) {
                    Business.Review review = new ReviewBuilder(temporaryReviewContent, 4.5f, "Reviewer Full name " + k).build();
                    business.addReview(review);
                    item.addReview(review);
                }
                business.addItem(item);
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
