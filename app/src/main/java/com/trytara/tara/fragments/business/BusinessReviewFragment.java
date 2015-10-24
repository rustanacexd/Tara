package com.trytara.tara.fragments.business;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.business.BusinessReviewsListAdapter;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.BusinessDataSource;


public class BusinessReviewFragment extends Fragment {

    private static final String ARG_BUSINESS = "com.trytara.tara.fragments.business.arg_business";

    // TODO: Rename and change types of parameters
    private Business mBusiness;

    public static BusinessReviewFragment newInstance(Business business) {
        BusinessReviewFragment fragment = new BusinessReviewFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BUSINESS, business);
        fragment.setArguments(args);
        return fragment;
    }

    public BusinessReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBusiness = getArguments().getParcelable(ARG_BUSINESS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business_review, container, false);

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessReviewsList);
        BusinessReviewsListAdapter adapter = new BusinessReviewsListAdapter(getActivity(), mBusiness.getReviews());

        rvBusinessMenuList.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvBusinessMenuList.setLayoutManager(manager);

        return view;
    }


}
