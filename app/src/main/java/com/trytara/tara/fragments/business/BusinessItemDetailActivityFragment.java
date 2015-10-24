package com.trytara.tara.fragments.business;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessItemDetailReviewsAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class BusinessItemDetailActivityFragment extends Fragment {

    private static final String ARG_POSITION = "com.trytara.tara.fragments.business.BusinessItemDetailActivityFragment.position";

    private int mPosition;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    public static BusinessItemDetailActivityFragment newInstance(int position) {
        BusinessItemDetailActivityFragment fragment = new BusinessItemDetailActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

}
