package com.trytara.tara;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.trytara.tara.adapters.ViewPagerAdapter;
import com.trytara.tara.fragments.BusinessMenuFragment;

public class BusinessDetailActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.business_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Business Name");*/
        getSupportActionBar().setTitle("Business Name");

        mViewPager = (ViewPager) findViewById(R.id.business_viewpager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.business_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new BusinessMenuFragment(), "Menu");
        adapter.addFrag(new BusinessMenuFragment(), "About");
        adapter.addFrag(new BusinessMenuFragment(), "Reviews");
        adapter.addFrag(new BusinessMenuFragment(), "Contact");
        viewPager.setAdapter(adapter);
    }


}
