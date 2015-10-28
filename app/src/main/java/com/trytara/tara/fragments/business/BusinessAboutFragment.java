package com.trytara.tara.fragments.business;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessStaffAdapter;


public class BusinessAboutFragment extends Fragment {

    public BusinessAboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_about, container, false);

        TextView aboutContent = (TextView) view.findViewById(R.id.about_content);
        aboutContent.setText(((BusinessDetailActivity) getActivity()).mBusinessAbout);

        RecyclerView rvStaffList = (RecyclerView) view.findViewById(R.id.rvStaffList);
        BusinessStaffAdapter adapter = new BusinessStaffAdapter(getActivity());

        rvStaffList.setHasFixedSize(true);
        rvStaffList.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvStaffList.setLayoutManager(manager);

        return view;
    }


}
