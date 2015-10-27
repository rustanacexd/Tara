package com.trytara.tara.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class POJOItem implements Parcelable {
    private final String mId;
    private final String mTitle;
    private final Double mPrice;
    private final String mDescription;
    private final String mStatus;
    private final String mCategory;
    private List<POJOReview> mReviews = new ArrayList<>();

    private POJOItem(ItemBuilder builder) {
        mId = builder.mId;
        mTitle = builder.mTitle;
        mPrice = builder.mPrice;
        mDescription = builder.mDescription;
        mStatus = builder.mStatus;
        mCategory = builder.mCategory;
    }

    private POJOItem(Parcel parcel) {
        mId = parcel.readString();
        mTitle = parcel.readString();
        mPrice = parcel.readDouble();
        mDescription = parcel.readString();
        mStatus = parcel.readString();
        mCategory = parcel.readString();
        parcel.readTypedList(mReviews, POJOReview.CREATOR);
    }

    public String getId() {
        return mId;
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

    public List<POJOReview> getReviews() {
        return mReviews;
    }

    public void addReview(POJOReview review) {
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

    public static final Parcelable.Creator<POJOItem> CREATOR = new ClassLoaderCreator<POJOItem>() {
        @Override
        public POJOItem createFromParcel(Parcel source, ClassLoader loader) {
            return new POJOItem(source);
        }

        @Override
        public POJOItem createFromParcel(Parcel source) {
            return new POJOItem(source);
        }

        @Override
        public POJOItem[] newArray(int size) {
            return new POJOItem[size];
        }
    };

    public static class ItemBuilder {
        private final String mId;
        private final String mTitle;
        private final Double mPrice;
        private String mDescription;
        private String mStatus;
        private String mCategory;

        public ItemBuilder(String id,String title, Double price) {
            mId = id;
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

        public POJOItem build() {
            return new POJOItem(this);
        }
    }


}
