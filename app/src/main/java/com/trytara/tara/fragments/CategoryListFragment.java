package com.trytara.tara.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.trytara.tara.models.Categories;

import java.util.ArrayList;
import java.util.List;


public class CategoryListFragment extends Fragment{

    private ListView mListView;
    private ListAdapter mAdapter;

    public CategoryListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new CategoriesListAdapter(Categories.sCategoryItemsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories_list, container, false);

        // Set the adapter
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = MapsActivity.newIntent(getActivity(), Categories.sCategoryItemsList.get(position).mName);
                getActivity().startActivity(i);
            }
        });
        mListView.setDivider(null);

        return view;
    }

    private class CategoriesListAdapter extends ArrayAdapter<Categories.CategoryItem> {
        private List<Integer> mDrawables = new ArrayList<>();

        public CategoriesListAdapter(List<Categories.CategoryItem> objects) {
            super(getActivity(), R.layout.category_row_item, R.id.category_name, objects);

            for (Categories.CategoryItem c : objects) {
                mDrawables.add(c.mDrawableResource);
            }

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = super.getView(position, convertView, parent);
            Categories.CategoryItem category = getItem(position);
            TextView categoryDescription = (TextView) convertView.findViewById(R.id.category_descripton);
            categoryDescription.setText(category.mDescription);
            ImageView categoryImage = (ImageView) convertView.findViewById(R.id.category_image);
            categoryImage.setImageResource(mDrawables.get(position));
            return convertView;
        }

    }

    /**
     * The default mDescription for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

}
