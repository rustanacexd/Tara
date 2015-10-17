package com.trytara.tara.fragments.trending;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessListAdapter;
import com.trytara.tara.adapters.trending.TrendingLatestListAdapter;
import com.trytara.tara.models.BusinessDataSource;
import com.trytara.tara.models.TrendingDataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingLatestFragment extends Fragment {


    public TrendingLatestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest, container, false);

        RecyclerView rvBusiness = (RecyclerView) view.findViewById(R.id.rvTrendingPopularList);
        TrendingLatestListAdapter adapter = new TrendingLatestListAdapter(getActivity(),
                TrendingDataSource.get(getActivity()).getTrendingList());

        rvBusiness.setAdapter(adapter);
        rvBusiness.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }


}
