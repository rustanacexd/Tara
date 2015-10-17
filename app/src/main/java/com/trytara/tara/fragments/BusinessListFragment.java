package com.trytara.tara.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessListAdapter;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.BusinessDataSource;
import com.trytara.tara.models.Categories;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusinessListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusinessListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusinessListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusinessListFragment newInstance(String param1, String param2) {
        BusinessListFragment fragment = new BusinessListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BusinessListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_list, container, false);

        RecyclerView rvBusiness = (RecyclerView) view.findViewById(R.id.rvBusiness);
        BusinessListAdapter adapter = new BusinessListAdapter(getActivity(), BusinessDataSource.get(getActivity()).getBusinesses());
        rvBusiness.setAdapter(adapter);
        rvBusiness.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBusiness.setHasFixedSize(true);

        return view;
    }




}
