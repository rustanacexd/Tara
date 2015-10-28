package com.trytara.tara.fragments.business;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.BusinessItemDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessItemDetailReviewsAdapter;
import com.trytara.tara.models.Item;


public class BusinessItemDetailFragment extends Fragment {

    private BusinessItemDetailReviewsAdapter mAdapter;
    private Item mCurrentItem;

    public BusinessItemDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_business_item_detail, container, false);

        RecyclerView rvBusinessItemReviews = (RecyclerView) view.findViewById(R.id.rvBusinessItemMenuReviews);
        BusinessItemDetailActivity activity = (BusinessItemDetailActivity) getActivity();

        mCurrentItem = new Item();

        //mAdapter = new BusinessItemDetailReviewsAdapter(((BusinessItemDetailActivity) getActivity()).getItem());
        mAdapter = new BusinessItemDetailReviewsAdapter(mCurrentItem);
        rvBusinessItemReviews.setAdapter(mAdapter);
        rvBusinessItemReviews.setLayoutManager(new LinearLayoutManager(activity));
        activity.getProgress().setVisibility(View.GONE);


        Item.getItem(activity.getItemId(), new Item.OnGetItemCallback() {
            @Override
            public void onGetItem(Item item) {
                mCurrentItem = item;
                mAdapter.notifyDataSetChanged();

            }
        });


        rvBusinessItemReviews.setHasFixedSize(true);

        return view;
    }


}
