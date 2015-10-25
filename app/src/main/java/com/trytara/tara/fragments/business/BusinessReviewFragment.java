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


public class BusinessReviewFragment extends Fragment {

    public BusinessReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business_review, container, false);

        BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessReviewsList);
        BusinessReviewsListAdapter adapter = new BusinessReviewsListAdapter(activity,
                activity.getBusiness().getReviews());

        rvBusinessMenuList.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvBusinessMenuList.setLayoutManager(manager);

        return view;
    }


}
