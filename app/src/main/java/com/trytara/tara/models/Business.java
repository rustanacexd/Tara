package com.trytara.tara.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.trytara.tara.models.Categories.Category;

public class Business {
    private final String mName;
    private final String mDescription;
    private final String mContactNumber;
    private final String mAddress;
    private Category mCategory;
    private List<Review> mReviews;
    private List<Item> mItems;
    private final UUID mId;

    private Business(BusinessBuilder builder) {
        mName = builder.mName;
        mDescription = builder.mDescription;
        mContactNumber = builder.mContactNumber;
        mAddress = builder.mAddress;
        mReviews = new ArrayList<>();
        mItems = new ArrayList<>();
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public String getAddress() {
        return mAddress;
    }

    public List<Review> getReviews() {
        return mReviews;
    }

    public void addReview(Review review) {
        mReviews.add(review);
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void addItem(Item item) {
        mItems.add(item);
    }

    public static class Review {
        private String mContent;
        private float mRating;
        private Date mDate;
        private String mReviewer;

        private Review(ReviewBuilder builder) {
            mContent = builder.mContent;
            mRating = builder.mRating;
            mReviewer = builder.mReviewer;
            mDate = new Date();
        }

        public String getContent() {
            return mContent;
        }

        public float getRating() {
            return mRating;
        }

        public Date getDate() {
            return mDate;
        }

        public String getReviewer() {
            return mReviewer;
        }

    }

    public static class Item {
        private final String mTitle;
        private final Double mPrice;
        private final String mDescription;
        private final String mStatus;
        private final String mCategory;

        public Item(ItemBuilder builder) {
            mTitle = builder.mTitle;
            mPrice = builder.mPrice;
            mDescription = builder.mDescription;
            mStatus = builder.mStatus;
            mCategory = builder.mCategory;
        }

        public String getCategory() {
            return mCategory;
        }

        public String getStatus() {
            return mStatus;
        }

        public String getDescription() {
            return mDescription;
        }


        public String getTitle() {
            return mTitle;
        }

        public Double getPrice() {
            return mPrice;
        }

    }

    public static class BusinessBuilder {
        private final String mName;
        private final String mDescription;
        private final String mContactNumber;
        private final String mAddress;

        public BusinessBuilder(String name, String description, String contactNumber,
                               String address) {
            mName = name;
            mDescription = description;
            mContactNumber = contactNumber;
            mAddress = address;
        }

        public Business build() {
            return new Business(this);
        }
    }

    public static class ReviewBuilder {
        private final String mContent;
        private final float mRating;
        private final String mReviewer;

        public ReviewBuilder(String content, float rating, String reviewer) {
            mContent = content;
            mRating = rating;
            mReviewer = reviewer;
        }

        public Review build() {
            return new Review(this);
        }
    }

    public static class ItemBuilder {
        private final String mTitle;
        private final Double mPrice;
        private String mDescription;
        private String mStatus;
        private String mCategory;

        public ItemBuilder(String title, Double price) {
            mTitle = title;
            mPrice = price;
        }

        public ItemBuilder description(String description) {
            mDescription = description;
            return this;
        }

        public ItemBuilder status(String status) {
            mStatus = status;
            return this;
        }

        public ItemBuilder category(String category) {
            mCategory = mCategory;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

}
