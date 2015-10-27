package com.trytara.tara.fragments.business;

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
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Item;

import java.util.ArrayList;


public class BusinessDetailMenuFragment extends Fragment {

    private ArrayList<Item> mItemsList;
    private BusinessDetailMenuAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        final BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        mItemsList = new ArrayList<>();

        mAdapter = new BusinessDetailMenuAdapter(activity, mItemsList, activity);

        Business.getBusiness(activity.getBusinessId(), new Business.OnGetSelectedBusinessListener() {
            @Override
            public void onGetSelectedBusiness(Business business) {
                mItemsList.addAll(business.getItems());
                mAdapter.notifyDataSetChanged();

            }
        });

        rvBusinessMenuList.setAdapter(mAdapter);
        rvBusinessMenuList.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    public BusinessDetailMenuFragment() {
        // Required empty public constructor
    }

}
