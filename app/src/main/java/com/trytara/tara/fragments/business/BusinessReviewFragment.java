package com.trytara.tara.fragments.business;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.BusinessReviewsListAdapter;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.BusinessDataSource;


public class BusinessReviewFragment extends Fragment {

    private static final String ARG_BUSINESS_POSITION = "arg_business_position";

    // TODO: Rename and change types of parameters
    private int mBusinessPosition;

    public static BusinessReviewFragment newInstance(int businessPosition) {
        BusinessReviewFragment fragment = new BusinessReviewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BUSINESS_POSITION, businessPosition);
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
            mBusinessPosition = getArguments().getInt(ARG_BUSINESS_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business_review, container, false);

        RecyclerView rvBusinessMenuList = (RecyclerView) view.findViewById(R.id.rvBusinessReviewsList);

        Business business = BusinessDataSource.get(getActivity()).getBusiness(mBusinessPosition);
        BusinessReviewsListAdapter adapter = new BusinessReviewsListAdapter(getActivity(),business.getReviews());

        rvBusinessMenuList.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvBusinessMenuList.setLayoutManager(manager);

        return view;
    }


}
