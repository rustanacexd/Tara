package com.trytara.tara.fragments.business;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
    public GridLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        final BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();

        final RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        mItemsList = new ArrayList<>();

        mAdapter = new BusinessDetailMenuAdapter(activity, mItemsList, activity);
        final View progress = view.findViewById(R.id.progress);

        progress.setVisibility(View.VISIBLE);
        rvBusinessMenuList.setVisibility(View.GONE);

        rvBusinessMenuList.setAdapter(mAdapter);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        rvBusinessMenuList.setLayoutManager(mLayoutManager);

        Business.getBusiness(activity.getBusinessId(), new Business.OnGetBusinessCallback() {
            @Override
            public void onGetBusiness(Business business) {
                progress.setVisibility(View.GONE);
                rvBusinessMenuList.setVisibility(View.VISIBLE);
                mItemsList.addAll(business.getItems());
                mAdapter.notifyDataSetChanged();

            }
        });


        return view;
    }

    public BusinessDetailMenuFragment() {
        // Required empty public constructor
    }

}
