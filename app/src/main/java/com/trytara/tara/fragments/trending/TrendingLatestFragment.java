package com.trytara.tara.fragments.trending;


import android.content.Context;
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
import com.trytara.tara.models.Trending;
import com.trytara.tara.models.TrendingDataSource;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingLatestFragment extends Fragment {


    public TrendingLatestFragment() {
        // Required empty public constructor
    }

    /*public static TrendingLatestFragment newInstance(Context context, List<Trending> trendingList) {
        TrendingLatestFragment fragment = new TrendingLatestFragment();
        Bundle args = new Bundle();
        args.p
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest, container, false);

        RecyclerView rvTrendingLatest = (RecyclerView) view.findViewById(R.id.rvTrendingPopularList);

        TrendingLatestListAdapter adapter = new TrendingLatestListAdapter(getActivity(),
                new TrendingDataSource(getActivity()).getTrendingList());

        rvTrendingLatest.setAdapter(adapter);
        rvTrendingLatest.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }


}
