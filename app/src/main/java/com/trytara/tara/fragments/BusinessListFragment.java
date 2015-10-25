package com.trytara.tara.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.LoginActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessListAdapter;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.BusinessDataSource;

import java.util.ArrayList;
import java.util.List;


public class BusinessListFragment extends Fragment {

    private BusinessListAdapter mAdapter;
    private List<Business> mBusinessList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DEBUG", "onCreate running");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("DEBUG", "onCreateView running");

        View view = inflater.inflate(R.layout.fragment_business_list, container, false);

        final View progress = view.findViewById(R.id.progress);
        final RecyclerView rvBusiness = (RecyclerView) view.findViewById(R.id.rvBusiness);

        progress.setVisibility(View.VISIBLE);
        rvBusiness.setVisibility(View.GONE);

        mBusinessList = new ArrayList<>();
        mAdapter = new BusinessListAdapter(getActivity(), mBusinessList);
        rvBusiness.setAdapter(mAdapter);
        rvBusiness.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBusiness.setHasFixedSize(true);

        BusinessDataSource.getAllBusinesses(new BusinessDataSource.BusinessDataCallbacks() {
            @Override
            public void onBusinessesFetch(List<Business> businesses) {
                progress.setVisibility(View.GONE);
                rvBusiness.setVisibility(View.VISIBLE);
                mBusinessList.addAll(businesses);
                mAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }

    public BusinessListFragment() {
        // Required empty public constructor
    }

}
