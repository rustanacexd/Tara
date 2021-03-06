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

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.MapsActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessListAdapter;
import com.trytara.tara.adapters.DividerItemDecoration;
import com.trytara.tara.models.Business;

import java.util.ArrayList;
import java.util.List;


public class BusinessListFragment extends Fragment implements BusinessListAdapter.OnBusinessListItemClickListener {

    private BusinessListAdapter mAdapter;
    private ArrayList<Business> mBusinessList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business_list, container, false);

        final View progress = view.findViewById(R.id.progress);
        final RecyclerView rvBusiness = (RecyclerView) view.findViewById(R.id.rvBusiness);

        progress.setVisibility(View.VISIBLE);
        rvBusiness.setVisibility(View.GONE);

        mBusinessList = new ArrayList<>();
        mAdapter = new BusinessListAdapter(getActivity(), mBusinessList, this);
        rvBusiness.setAdapter(mAdapter);
        rvBusiness.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        rvBusiness.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBusiness.setHasFixedSize(true);

        Business.getBusinessListByCategory(((MapsActivity) getActivity()).getCategorySlug(),
                new Business.OnGetBusinessListByCategoryCallback() {
                    @Override
                    public void onGetBusinessListByCategory(List<Business> businessList) {
                        progress.setVisibility(View.GONE);
                        rvBusiness.setVisibility(View.VISIBLE);
                        mBusinessList.addAll(businessList);
                        mAdapter.notifyDataSetChanged();
                    }
                });


        return view;
    }

    public BusinessListFragment() {
        // Required empty public constructor
    }


    @Override
    public void OnBusinessListItemClick(Business business) {
        Intent i = BusinessDetailActivity.newIntent(
                getActivity(),
                business.getObjectId(),
                business.getName(),
                business.getDescription(),
                business.getAbout(),
                business.getPhoneNumber(),
                business.getMobilePhoneNumber(),
                business.getEmail(),
                business.getAddress()
        );
        startActivity(i);
    }

}
