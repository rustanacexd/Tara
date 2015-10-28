package com.trytara.tara.fragments.business;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessReviewsListAdapter;
import com.trytara.tara.models.Review;

import java.util.ArrayList;
import java.util.List;


public class BusinessReviewFragment extends Fragment {

    private BusinessReviewsListAdapter mAdapter;
    private List<Review> mReviewList;

    public BusinessReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business_review, container, false);

        BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();
        mReviewList = new ArrayList<>();
        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessReviewsList);
        mAdapter = new BusinessReviewsListAdapter(activity, mReviewList);
        rvBusinessMenuList.setAdapter(mAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        rvBusinessMenuList.setLayoutManager(manager);

        Review.getReviewsByBusiness(activity.getBusinessId(), new Review.OnGetReviewsByBusinessCallback() {
            @Override
            public void onGetReviewsByBusiness(List<Review> reviewsList) {
                mReviewList.addAll(reviewsList);
                mAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }


}
