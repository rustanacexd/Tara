package com.trytara.tara.fragments.business;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessDetailMenuAdapter;
import com.trytara.tara.models.Item;

import java.util.ArrayList;

public class BusinessDetailMenuFragment extends Fragment {

    public ArrayList<Item> mItemsList;
    public BusinessDetailMenuAdapter mAdapter;
    public GridLayoutManager mLayoutManager;
    public View mProgress;
    public RecyclerView mRvBusinessMenuList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        final BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();

        mRvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        mItemsList = new ArrayList<>();

        mAdapter = new BusinessDetailMenuAdapter(activity, mItemsList, activity);
        mProgress = view.findViewById(R.id.progress);

        mProgress.setVisibility(View.VISIBLE);
        mRvBusinessMenuList.setVisibility(View.GONE);

        mRvBusinessMenuList.setAdapter(mAdapter);
        mLayoutManager = new GridLayoutManager(activity, 2);
        mRvBusinessMenuList.setLayoutManager(mLayoutManager);

        if (activity.mBusiness != null) {
            activity.onBusinessDetailMenuFragmentCreate();
        }

        return view;
    }

    public BusinessDetailMenuFragment() {
        // Required empty public constructor
    }

}
