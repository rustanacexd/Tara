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


public class BusinessDetailMenuFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        BusinessDetailMenuAdapter adapter = new BusinessDetailMenuAdapter(activity,
                activity.getBusiness().getItems(), activity);

        rvBusinessMenuList.setAdapter(adapter);
        rvBusinessMenuList.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    public BusinessDetailMenuFragment() {
        // Required empty public constructor
    }

}
