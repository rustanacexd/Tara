package com.trytara.tara.fragments.business;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessListAdapter;
import com.trytara.tara.adapters.business.BusinessItemDetailReviewsAdapter;
import com.trytara.tara.models.BusinessDataSource;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessItemDetailActivityFragment extends Fragment {

    public BusinessItemDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_item_detail, container, false);

        RecyclerView rvBusinessItemReviews = (RecyclerView) view.findViewById(R.id.rvBusinessItemMenuReviews);
        BusinessItemDetailReviewsAdapter adapter = new BusinessItemDetailReviewsAdapter();
        rvBusinessItemReviews.setAdapter(adapter);
        rvBusinessItemReviews.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBusinessItemReviews.setHasFixedSize(true);

        return view;
    }
}
