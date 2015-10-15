package com.trytara.tara.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BusinessDataSource {

    private static final RandomEnum<Categories.Category> r = new RandomEnum<>(Categories.Category.class);

    public static List<Business> createBusinessList(int numBusiness) {
        List<Business> businesses = new ArrayList<>();
        for (int i = 1; i <= numBusiness; i++) {
            businesses.add(new Business("Business " + i, "Lorem ipsum nonsense lol", "2142406",
                    "Pagadian City", r));
        }

        return businesses;
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
