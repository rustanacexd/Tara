package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.trytara.tara.adapters.ViewPagerAdapter;
import com.trytara.tara.fragments.business.BusinessAboutFragment;
import com.trytara.tara.fragments.business.BusinessContactFragment;
import com.trytara.tara.fragments.business.BusinessMenuFragment;
import com.trytara.tara.fragments.business.BusinessReviewFragment;

public class BusinessDetailActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private static final String EXTRA_PREFIX = "com.trytara.tara.";
    private static final String EXTRA_BUSINESS_POSITION = EXTRA_PREFIX + "business_position";
    private int mBusinessPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mBusinessPosition = getIntent().getIntExtra(EXTRA_BUSINESS_POSITION, 0);

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

    public static Intent newIntent(Context packageContext, int position) {
        Intent intent = new Intent(packageContext, BusinessDetailActivity.class);
        intent.putExtra(EXTRA_BUSINESS_POSITION, position);
        return intent;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(BusinessMenuFragment.newInstance(mBusinessPosition), "Menu");
        adapter.addFrag(new BusinessAboutFragment(), "About");
        adapter.addFrag(BusinessReviewFragment.newInstance(mBusinessPosition), "Reviews");
        adapter.addFrag(new BusinessContactFragment(), "Contact");
        viewPager.setAdapter(adapter);
    }


}
