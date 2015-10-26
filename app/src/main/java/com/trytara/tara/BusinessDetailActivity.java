package com.trytara.tara;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.trytara.tara.adapters.ViewPagerAdapter;
import com.trytara.tara.adapters.business.BusinessDetailMenuAdapter;
import com.trytara.tara.fragments.business.BusinessAboutFragment;
import com.trytara.tara.fragments.business.BusinessContactFragment;
import com.trytara.tara.fragments.business.BusinessDetailMenuFragment;
import com.trytara.tara.fragments.business.BusinessReviewFragment;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Item;

import java.util.ArrayList;
import java.util.List;

public class BusinessDetailActivity extends AppCompatActivity implements BusinessDetailMenuAdapter.OnBusinessItemClickListener {

    private ViewPager mViewPager;
    private static final String EXTRA_PREFIX = "com.trytara.tara.BusinessDetailActivity";
    private static final String EXTRA_BUSINESS = EXTRA_PREFIX + "business";
    private static final int REQUEST_BACK = 563;
    private Business mBusiness;

    public Business getBusiness() {
        return mBusiness;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mBusiness = getIntent().getParcelableExtra(EXTRA_BUSINESS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.business_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView businessDescription = (TextView) findViewById(R.id.business_description);
        businessDescription.setText(mBusiness.getDescription());
        getSupportActionBar().setTitle(mBusiness.getName());

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


    public static Intent newIntent(Context packageContext, Business business) {
        Intent intent = new Intent(packageContext, BusinessDetailActivity.class);
        intent.putExtra(EXTRA_BUSINESS, business);
        return intent;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new BusinessDetailMenuFragment(), "Menu");
        adapter.addFrag(new BusinessAboutFragment(), "About");
        adapter.addFrag(new BusinessReviewFragment(), "Reviews");
        adapter.addFrag(new BusinessContactFragment(), "Contact");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onBusinessItemClick(Item item) {
        Intent i = BusinessItemDetailActivity.newIntent(this, item, mBusiness);
        startActivityForResult(i, REQUEST_BACK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        if (requestCode == REQUEST_BACK) {
            mBusiness = data.getParcelableExtra(BusinessItemDetailActivity.EXTRA_BUSINESS);
        }
    }
}
