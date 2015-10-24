package com.trytara.tara.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.trytara.tara.models.Categories.Category;

public class Business implements Parcelable {
    private final String mName;
    private final String mDescription;
    private final String mContactNumber;
    private final String mAddress;
    private Category mCategory;
    private List<Review> mReviews = new ArrayList<>();
    private List<Item> mItems = new ArrayList<>();

    private Business(BusinessBuilder builder) {
        mName = builder.mName;
        mDescription = builder.mDescription;
        mContactNumber = builder.mContactNumber;
        mAddress = builder.mAddress;
    }

    private Business(Parcel parcel) {
        mName = parcel.readString();
        mDescription = parcel.readString();
        mContactNumber = parcel.readString();
        mAddress = parcel.readString();
        parcel.readTypedList(mReviews, Review.CREATOR);
        parcel.readTypedList(mItems, Item.CREATOR);
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mContactNumber);
        dest.writeString(mAddress);
        dest.writeTypedList(mReviews);
        dest.writeTypedList(mItems);
    }

    public static final Parcelable.Creator<Business> CREATOR = new ClassLoaderCreator<Business>() {
        @Override
        public Business createFromParcel(Parcel source) {
            return new Business(source);
        }

        @Override
        public Business[] newArray(int size) {
            return new Business[size];
        }

        @Override
        public Business createFromParcel(Parcel source, ClassLoader loader) {
            return new Business(source);
        }
    };

    public static class Review implements Parcelable {
        private String mContent;
        private float mRating;
        private Date mDate;
        private String mReviewer;

        private Review(ReviewBuilder builder) {
            mContent = builder.mContent;
            mRating = builder.mRating;
            mDate = new Date();
            mReviewer = builder.mReviewer;

        }

        private Review(Parcel parcel) {
            mContent = parcel.readString();
            mRating = parcel.readFloat();
            mDate = new Date(parcel.readLong());
            mReviewer = parcel.readString();
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mContent);
            dest.writeFloat(mRating);
            dest.writeLong(mDate.getTime());
            dest.writeString(mReviewer);
        }

        public static final Parcelable.Creator<Review> CREATOR = new ClassLoaderCreator<Review>() {
            @Override
            public Review createFromParcel(Parcel source, ClassLoader loader) {
                return new Review(source);
            }

            @Override
            public Review createFromParcel(Parcel source) {
                return new Review(source);
            }

            @Override
            public Review[] newArray(int size) {
                return new Review[size];
            }
        };
    }

    public static class Item implements Parcelable {
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
