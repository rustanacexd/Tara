package com.trytara.tara.fragments.business;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.BusinessItemDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessItemDetailReviewsAdapter;
import com.trytara.tara.models.Item;


public class BusinessItemDetailFragment extends Fragment {

    private BusinessItemDetailReviewsAdapter mAdapter;

    public BusinessItemDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_item_detail, container, false);

        RecyclerView rvBusinessItemReviews = (RecyclerView) view.findViewById(R.id.rvBusinessItemMenuReviews);

        mAdapter = new BusinessItemDetailReviewsAdapter(((BusinessItemDetailActivity) getActivity()).getItem());
        rvBusinessItemReviews.setAdapter(mAdapter);
        rvBusinessItemReviews.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((BusinessItemDetailActivity) getActivity()).getProgress().setVisibility(View.GONE);

        /*rvBusinessItemReviews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.getChildAt(0) != null) {
                    View view = recyclerView.getChildAt(0);
                    view.setTranslationY(-view.getTop() / 2);
                }
            }
        });*/
        rvBusinessItemReviews.setHasFixedSize(true);

        return view;
    }


}
