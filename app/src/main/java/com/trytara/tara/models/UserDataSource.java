package com.trytara.tara.models;

import com.parse.ParseUser;

import java.util.List;

public class UserDataSource {
    private static final String FIRST_NAME = "firstName";
    private static final String FACEBOOK_ID = "facebookId";
    private static final String ADDRESS = "address";


    private static User sCurrentUser;

    public static User getCurrentUser() {
        if (sCurrentUser == null && ParseUser.getCurrentUser() != null) {
            sCurrentUser = parseUserToUser(ParseUser.getCurrentUser());
        }

        return sCurrentUser;
    }

    private UserDataSource() {
    }

    private static User parseUserToUser(ParseUser parseUser) {
        User user = new User();
        user.setFirstName(parseUser.getString(FIRST_NAME));
        user.setObjectId(parseUser.getObjectId());
        user.setFacebookId(parseUser.getString(FACEBOOK_ID));
        user.setAddress(parseUser.getString(ADDRESS));

        return user;
    }

    public interface UserDataCallBacks {
        public void onUsersFetch(List<User> users);
    }
}
