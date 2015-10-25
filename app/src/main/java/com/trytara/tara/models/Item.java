package com.trytara.tara.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Item implements Parcelable {
    private final String mTitle;
    private final Double mPrice;
    private final String mDescription;
    private final String mStatus;
    private final String mCategory;
    private List<Review> mReviews = new ArrayList<>();

    private Item(ItemBuilder builder) {
        mTitle = builder.mTitle;
        mPrice = builder.mPrice;
        mDescription = builder.mDescription;
        mStatus = builder.mStatus;
        mCategory = builder.mCategory;
    }

    private Item(Parcel parcel) {
        mTitle = parcel.readString();
        mPrice = parcel.readDouble();
        mDescription = parcel.readString();
        mStatus = parcel.readString();
        mCategory = parcel.readString();
        parcel.readTypedList(mReviews, Review.CREATOR);
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

    public List<Review> getReviews() {
        return mReviews;
    }

    public void addReview(Review review) {
        mReviews.add(review);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeDouble(mPrice);
        dest.writeString(mDescription);
        dest.writeString(mStatus);
        dest.writeString(mCategory);
        dest.writeTypedList(mReviews);
    }

    public static final Parcelable.Creator<Item> CREATOR = new ClassLoaderCreator<Item>() {
        @Override
        public Item createFromParcel(Parcel source, ClassLoader loader) {
            return new Item(source);
        }

        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

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
