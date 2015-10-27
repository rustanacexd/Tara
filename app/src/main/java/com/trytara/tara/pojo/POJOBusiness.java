package com.trytara.tara.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


public class POJOBusiness implements Parcelable {
    private final String mId;
    private final String mName;
    private final String mDescription;
    private final String mContactNumber;
    private final String mAddress;
    private List<POJOReview> mReviews = new ArrayList<>();
    private List<POJOItem> mItems = new ArrayList<>();

    private POJOBusiness(BusinessBuilder builder) {
        mId = builder.mId;
        mName = builder.mName;
        mDescription = builder.mDescription;
        mContactNumber = builder.mContactNumber;
        mAddress = builder.mAddress;
    }

    private POJOBusiness(Parcel parcel) {
        mId = parcel.readString();
        mName = parcel.readString();
        mDescription = parcel.readString();
        mContactNumber = parcel.readString();
        mAddress = parcel.readString();
        parcel.readTypedList(mReviews, POJOReview.CREATOR);
        parcel.readTypedList(mItems, POJOItem.CREATOR);
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

    public List<POJOReview> getReviews() {
        return mReviews;
    }

    public void addReview(POJOReview review) {
        mReviews.add(review);
    }

    public List<POJOItem> getItems() {
        return mItems;
    }

    public void addItem(POJOItem item) {
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

    public static final Parcelable.Creator<POJOBusiness> CREATOR = new ClassLoaderCreator<POJOBusiness>() {
        @Override
        public POJOBusiness createFromParcel(Parcel source) {
            return new POJOBusiness(source);
        }

        @Override
        public POJOBusiness[] newArray(int size) {
            return new POJOBusiness[size];
        }

        @Override
        public POJOBusiness createFromParcel(Parcel source, ClassLoader loader) {
            return new POJOBusiness(source);
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

        public POJOBusiness build() {
            return new POJOBusiness(this);
        }
    }

}
