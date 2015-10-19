package com.trytara.tara.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.trytara.tara.MapsActivity;
import com.trytara.tara.R;
import com.trytara.tara.adapters.CategoryListAdapter;
import com.trytara.tara.models.Categories;

import java.util.ArrayList;
import java.util.List;


public class CategoryListFragment extends Fragment {

    public CategoryListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categories_list, container, false);
        RecyclerView rvCategories = (RecyclerView) view.findViewById(R.id.listview);
        CategoryListAdapter adapter = new CategoryListAdapter(getActivity(), Categories.getCategoryItemsList());
        rvCategories.setAdapter(adapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategories.setHasFixedSize(true);

        return view;
    }

}
