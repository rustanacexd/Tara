package com.trytara.tara.fragments.business;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.R;


public class BusinessContactFragment extends Fragment {

    public BusinessContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_business_contact, container, false);

        BusinessDetailActivity activity = (BusinessDetailActivity) getActivity();

        TextView phoneNumber = (TextView) v.findViewById(R.id.phone_number);
        TextView mobilePhoneNumber = (TextView) v.findViewById(R.id.mobile_phone_number);
        TextView emailAddress = (TextView) v.findViewById(R.id.email_address);
        TextView address = (TextView) v.findViewById(R.id.address);

        phoneNumber.setText(activity.getPhoneNumber());
        mobilePhoneNumber.setText(activity.getPhoneNumber());
        emailAddress.setText(activity.getEmail());
        address.setText(activity.getAddress());

        return v;
    }



}
