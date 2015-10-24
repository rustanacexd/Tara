package com.trytara.tara.fragments.business;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessDetailMenuAdapter;
import com.trytara.tara.models.Business;


public class BusinessMenuFragment extends Fragment {
    private static final String ARG_BUSINESS = "com.trytara.tara.fragments.business.BusinessMenuFragment.business";

    private Business mBusiness;


    public static BusinessMenuFragment newInstance(Business business) {
        BusinessMenuFragment fragment = new BusinessMenuFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BUSINESS, business);
        fragment.setArguments(args);
        return fragment;
    }

    public BusinessMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBusiness = getArguments().getParcelable(ARG_BUSINESS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        BusinessDetailMenuAdapter adapter = new BusinessDetailMenuAdapter(getActivity(), mBusiness.getItems());
        rvBusinessMenuList.setAdapter(adapter);
        rvBusinessMenuList.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }


}
