package com.trytara.tara.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.trytara.tara.models.Categories.Category;

public class Business{
    private String mName;
    private String mDescription;
    private String mContactNumber;
    private String mAddress;
    private Category mCategory;
    private List<Review> mReviews;
    private List<MenuItem> mMenus;
    private UUID mId;

    public Business(String name, String description, String contactNumber, String address, BusinessDataSource.RandomEnum<Category> category) {
        mName = name;
        mDescription = description;
        mContactNumber = contactNumber;
        mAddress = address;
        mReviews = new ArrayList<>();
        mMenus = new ArrayList<>();
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        mContactNumber = contactNumber;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public List<Review> getReviews() {
        return mReviews;
    }

    public void addReview(Review review) {
        mReviews.add(review);
    }

    public List<MenuItem> getMenus() {
        return mMenus;
    }

    public void addMenu(MenuItem menu) {
        mMenus.add(menu);
    }


    public static class Review {
        //TODO: Implement Class
        private String mContent;
        private float mRating;
        private Date mDate;
        private String mReviewer;

        public Review(String content, float rating, String reviewer) {
            mContent = content;
            mRating = rating;
            mDate = new Date();
            mReviewer = reviewer;
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
        public String toString() {
            return "Review{" +
                    "mContent='" + mContent + '\'' +
                    ", mRating=" + mRating +
                    ", mDate=" + mDate +
                    ", mReviewer='" + mReviewer + '\'' +
                    '}';
        }
    }

    public static class MenuItem {
        //TODO: Implement Class
        private String mTitle;
        private String mPrice;
        private String mDescription;
        private List<MenuItemCategory> mMenuItemCategories;
        private String mStatus;

        public String getStatus() {
            return mStatus;
        }

        public void setStatus(String status) {
            mStatus = status;
        }

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            mDescription = description;
        }


        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public List<MenuItemCategory> getMenuItemCategories() {
            return mMenuItemCategories;
        }

        public void addMenuItemCategory(MenuItemCategory menuItemCategory) {
            mMenuItemCategories.add(menuItemCategory);
        }

        public String getPrice() {
            return mPrice;
        }

        public void setPrice(String price) {
            mPrice = price;
        }

        private class MenuItemCategory {
            private String mName;

            public String getName() {
                return mName;
            }

            public void setName(String name) {
                mName = name;
            }
        }

        @Override
        public String toString() {
            return "MenuItem{" +
                    "mTitle='" + mTitle + '\'' +
                    ", mPrice='" + mPrice + '\'' +
                    ", mDescription='" + mDescription + '\'' +
                    ", mMenuItemCategories=" + mMenuItemCategories +
                    ", mStatus='" + mStatus + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Business{" +
                "mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mContactNumber='" + mContactNumber + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mCategory=" + mCategory +
                ", mReviews=" + mReviews +
                ", mMenus=" + mMenus +
                '}';
    }
}
