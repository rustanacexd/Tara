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
import com.trytara.tara.models.BusinessDataSource;


public class BusinessMenuFragment extends Fragment {
    private static final String ARG_POSITION = "com.trytara.tara.fragments.business.position";

    private int mPosition;


    public static BusinessMenuFragment newInstance(int param1) {
        BusinessMenuFragment fragment = new BusinessMenuFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, param1);
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
            mPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        Business business = BusinessDataSource.get(getActivity()).getBusiness(mPosition);
        BusinessDetailMenuAdapter adapter = new BusinessDetailMenuAdapter(getActivity(), business.getItems());
        rvBusinessMenuList.setAdapter(adapter);
        rvBusinessMenuList.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }


}
