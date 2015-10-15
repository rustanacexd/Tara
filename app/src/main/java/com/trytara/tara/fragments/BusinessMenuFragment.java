package com.trytara.tara.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessDetailMenuAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusinessMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusinessMenuFragment extends Fragment {
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
     * @return A new instance of fragment BusinessMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusinessMenuFragment newInstance(String param1, String param2) {
        BusinessMenuFragment fragment = new BusinessMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_menu, container, false);

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessMenuList);
        BusinessDetailMenuAdapter adapter = new BusinessDetailMenuAdapter(getActivity());
        rvBusinessMenuList.setAdapter(adapter);
        rvBusinessMenuList.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        return view;
    }


}