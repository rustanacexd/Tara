package com.trytara.tara.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Review implements Parcelable {
    private final String mId;
    private String mContent;
    private float mRating;
    private String mReviewer;

    private Review(ReviewBuilder builder) {
        mId = builder.mId;
        mContent = builder.mContent;
        mRating = builder.mRating;
        mReviewer = builder.mReviewer;

    }

    private Review(Parcel parcel) {
        mId = parcel.readString();
        mContent = parcel.readString();
        mRating = parcel.readFloat();
        mReviewer = parcel.readString();
    }

    public String getContent() {
        return mContent;
    }

    public float getRating() {
        return mRating;
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
        dest.writeString(mId);
        dest.writeString(mContent);
        dest.writeFloat(mRating);
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

    public static class ReviewBuilder {
        private final String mId;
        private final String mContent;
        private final float mRating;
        private final String mReviewer;

        public ReviewBuilder(String id, String content, float rating, String reviewer) {
            mId = id;
            mContent = content;
            mRating = rating;
            mReviewer = reviewer;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
