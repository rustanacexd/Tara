package com.trytara.tara.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class POJOReview implements Parcelable {
    private final String mId;
    private String mContent;
    private float mRating;
    private String mReviewer;

    private POJOReview(ReviewBuilder builder) {
        mId = builder.mId;
        mContent = builder.mContent;
        mRating = builder.mRating;
        mReviewer = builder.mReviewer;

    }

    private POJOReview(Parcel parcel) {
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

    public static final Parcelable.Creator<POJOReview> CREATOR = new ClassLoaderCreator<POJOReview>() {
        @Override
        public POJOReview createFromParcel(Parcel source, ClassLoader loader) {
            return new POJOReview(source);
        }

        @Override
        public POJOReview createFromParcel(Parcel source) {
            return new POJOReview(source);
        }

        @Override
        public POJOReview[] newArray(int size) {
            return new POJOReview[size];
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

        public POJOReview build() {
            return new POJOReview(this);
        }
    }
}
