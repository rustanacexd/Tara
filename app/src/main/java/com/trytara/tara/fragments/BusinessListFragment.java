package com.trytara.tara.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessListAdapter;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.BusinessDataSource;

import java.util.List;


public class BusinessListFragment extends Fragment {

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

        final RecyclerView rvBusiness = (RecyclerView) view.findViewById(R.id.rvBusiness);

        BusinessDataSource.getAllBusinesses(new BusinessDataSource.BusinessDataCallbacks() {
            @Override
            public void onBusinessesFetch(List<Business> businesses) {
                BusinessListAdapter adapter = new BusinessListAdapter(getActivity(), businesses);
                rvBusiness.setAdapter(adapter);
                rvBusiness.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvBusiness.setHasFixedSize(true);
            }
        });


        return view;
    }

    public BusinessListFragment() {
        // Required empty public constructor
    }

}
