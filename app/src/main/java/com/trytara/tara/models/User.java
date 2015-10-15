package com.trytara.tara.models;

public class User {
    private String mFirstName;
    private String mObjectId;
    private String mFacebookId;
    private String mAddress;

    public String getAddress() {
        return UserDataSource.getCurrentUser().getAddress();
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getLargePictureURL() {
        return  "https://graph.facebook.com/v2.3/" + mFacebookId + "/picture?type=large";
    }

    public String getFacebookId() {
        return mFacebookId;
    }

    public void setFacebookId(String facebookId) {
        mFacebookId = facebookId;
    }

    public String getObjectId() {
        return mObjectId;
    }

    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }


    public String getFirstName() {

        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
}
