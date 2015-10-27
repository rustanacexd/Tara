package com.trytara.tara.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trytara.tara.R;
import com.trytara.tara.adapters.CategoryListAdapter;
import com.trytara.tara.models.Category;


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
        CategoryListAdapter adapter = new CategoryListAdapter(getActivity(), new Category().getCategoryItemsList());
        rvCategories.setAdapter(adapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategories.setHasFixedSize(true);

        return view;
    }

}
