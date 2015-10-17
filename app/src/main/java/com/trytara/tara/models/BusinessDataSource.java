package com.trytara.tara.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.trytara.tara.models.Business.*;

public class BusinessDataSource {

    private static BusinessDataSource sBusinessDataSource;
    private List<Business> mBusinesses;
    private Context mContext;


    private BusinessDataSource(Context context) {
        mContext = context.getApplicationContext();
        mBusinesses = createBusinessList(15);
    }

    public synchronized static BusinessDataSource get(Context context) {
        if (sBusinessDataSource == null) {
            sBusinessDataSource = new BusinessDataSource(context);
        }

        return sBusinessDataSource;
    }

    private static final RandomEnum<Categories.Category> r = new RandomEnum<>(Categories.Category.class);

    private List<Business> createBusinessList(int numBusiness) {
        List<Business> businesses = new ArrayList<>();
        for (int i = 1; i <= numBusiness; i++) {

            Business business = new Business("Business " + i, "Lorem ipsum nonsense lol", "2142406",
                    "Pagadian City", r);

            for (int j = 0; j <= 10; j++) {
                Review review = new Review("Review " + j + " Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                        "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                        "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                        "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                        "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                        "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 4.6, "Tidus Jecht");

                business.addReview(review);
            }


            businesses.add(business);
        }

        return businesses;
    }


    public List<Business> getBusinesses() {
        return mBusinesses;
    }

    public Business getBusiness(int position) {
        return mBusinesses.get(position);
    }

    public static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }


}
