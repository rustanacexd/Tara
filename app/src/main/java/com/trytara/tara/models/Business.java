package com.trytara.tara.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


public class Business implements Parcelable {
    private final String mId;
    private final String mName;
    private final String mDescription;
    private final String mContactNumber;
    private final String mAddress;
    private List<Review> mReviews = new ArrayList<>();
    private List<Item> mItems = new ArrayList<>();

    private Business(BusinessBuilder builder) {
        mId = builder.mId;
        mName = builder.mName;
        mDescription = builder.mDescription;
        mContactNumber = builder.mContactNumber;
        mAddress = builder.mAddress;
    }

    private Business(Parcel parcel) {
        mId = parcel.readString();
        mName = parcel.readString();
        mDescription = parcel.readString();
        mContactNumber = parcel.readString();
        mAddress = parcel.readString();
        parcel.readTypedList(mReviews, Review.CREATOR);
        parcel.readTypedList(mItems, Item.CREATOR);
    }

    public String getId() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
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

    public static class BusinessBuilder {
        private final String mId;
        private final String mName;
        private final String mDescription;
        private final String mContactNumber;
        private final String mAddress;

        public BusinessBuilder(String id, String name, String description, String contactNumber,
                               String address) {
            mId = id;
            mName = name;
            mDescription = description;
            mContactNumber = contactNumber;
            mAddress = address;
        }

        public Business build() {
            return new Business(this);
        }
    }

}
