package com.trytara.tara.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.trytara.tara.MapsActivity;
import com.trytara.tara.R;
import com.trytara.tara.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    private OnCategoryFragmentItemClickListener mListener;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_categories, container, false);

        final ListView listview = (ListView) v.findViewById(R.id.listview);

        final List<Category> list = new ArrayList<>();

        Category c = new Category("Restaurant", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.restaurant);
        list.add(c);
        c = new Category("Hotels", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.hotels);
        list.add(c);
        c = new Category("Coffee Shop", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.coffee_shop);
        list.add(c);
        c = new Category("Pharmacy", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.pharmacy);
        list.add(c);
        c = new Category("Restaurant", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.restaurant);
        list.add(c);

        final CategoriesAdapter adapter = new CategoriesAdapter(list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //onButtonPressed();
                Intent i = new Intent(getActivity(), MapsActivity.class);
                getActivity().startActivity(i);
            }
        });
        listview.setDivider(null);

        return v;
    }

    private class CategoriesAdapter extends ArrayAdapter<Category> {
        private List<Integer> mDrawables = new ArrayList<>();

        public CategoriesAdapter(List<Category> objects) {
            super(getActivity(), R.layout.category_row_item, R.id.category_name, objects);

            for (Category c : objects) {
                mDrawables.add(c.getCategoryPictureURL());
            }

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = super.getView(position, convertView, parent);
            Category category = getItem(position);
            TextView categoryDescription = (TextView) convertView.findViewById(R.id.category_descripton);
            categoryDescription.setText(category.getCategoryDescription());
            convertView.setBackgroundResource(mDrawables.get(position));
            return convertView;
        }

    }

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onCategoryFragmentItemClick();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnCategoryFragmentItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnCategoryFragmentItemClickListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnCategoryFragmentItemClickListener {
        public void onCategoryFragmentItemClick();
    }
}
