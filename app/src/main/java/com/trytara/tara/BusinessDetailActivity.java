package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.trytara.tara.adapters.ViewPagerAdapter;
import com.trytara.tara.adapters.business.BusinessDetailMenuAdapter;
import com.trytara.tara.fragments.business.BusinessAboutFragment;
import com.trytara.tara.fragments.business.BusinessContactFragment;
import com.trytara.tara.fragments.business.BusinessDetailMenuFragment;
import com.trytara.tara.fragments.business.BusinessReviewFragment;
import com.trytara.tara.models.Item;

public class BusinessDetailActivity extends AppCompatActivity implements BusinessDetailMenuAdapter.OnBusinessItemClickListener {

    private static final String EXTRA_PREFIX = "com.trytara.tara.BusinessDetailActivity.";
    private static final String EXTRA_BUSINESS_ID = EXTRA_PREFIX + "businessId";
    private static final String EXTRA_BUSINESS_TITLE = EXTRA_PREFIX + "businessTitle";
    private static final String EXTRA_BUSINESS_DESCRIPTION = EXTRA_PREFIX + "businessDescription";
    private static final String EXTRA_BUSINESS_ABOUT = EXTRA_PREFIX + "businessAbout";
    private static final String EXTRA_BUSINESS_PHONE_NUMBER = EXTRA_PREFIX + "phoneNumber";
    private static final String EXTRA_BUSINESS_MOBILE_NUMBER = EXTRA_PREFIX + "mobileNumber";
    private static final String EXTRA_BUSINESS_EMAIL = EXTRA_PREFIX + "email";
    private static final String EXTRA_BUSINESS_ADDRESS = EXTRA_PREFIX + "address";

    private String mBusinessId;
    private String mBusinessAbout;
    private String mPhoneNumber;
    private String mMobileNumber;
    private String mEmail;
    private String mAddress;
    private FloatingActionButton mFab;
    private AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.business_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_BUSINESS_TITLE));
        TextView businessDescriptionView = (TextView) findViewById(R.id.business_description);
        businessDescriptionView.setText(getIntent().getStringExtra(EXTRA_BUSINESS_DESCRIPTION));

        Intent intent = getIntent();
        mBusinessId = intent.getStringExtra(EXTRA_BUSINESS_ID);
        mBusinessAbout = intent.getStringExtra(EXTRA_BUSINESS_ABOUT);
        mPhoneNumber = intent.getStringExtra(EXTRA_BUSINESS_PHONE_NUMBER);
        mMobileNumber = intent.getStringExtra(EXTRA_BUSINESS_MOBILE_NUMBER);
        mEmail = intent.getStringExtra(EXTRA_BUSINESS_EMAIL);
        mAddress = intent.getStringExtra(EXTRA_BUSINESS_ADDRESS);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.business_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.business_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public AppBarLayout getAppBarLayout() {
        return mAppBarLayout;
    }

    public FloatingActionButton getFab() {
        return mFab;
    }

    public String getBusinessId() {
        return mBusinessId;
    }

    public String getBusinessAbout() {
        return mBusinessAbout;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getMobileNumber() {
        return mMobileNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getAddress() {
        return mAddress;
    }

    public static Intent newIntent(Context packageContext, String id, String name,
                                   String description, String about, String phoneNumber,
                                   String mobileNumber, String email, String address) {

        Intent intent = new Intent(packageContext, BusinessDetailActivity.class);
        intent.putExtra(EXTRA_BUSINESS_ID, id);
        intent.putExtra(EXTRA_BUSINESS_TITLE, name);
        intent.putExtra(EXTRA_BUSINESS_DESCRIPTION, description);
        intent.putExtra(EXTRA_BUSINESS_ABOUT, about);
        intent.putExtra(EXTRA_BUSINESS_PHONE_NUMBER, phoneNumber);
        intent.putExtra(EXTRA_BUSINESS_MOBILE_NUMBER, mobileNumber);
        intent.putExtra(EXTRA_BUSINESS_EMAIL, email);
        intent.putExtra(EXTRA_BUSINESS_ADDRESS, address);
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
    public void onBusinessItemClick(Item item) {
        Intent i = BusinessItemDetailActivity.newIntent(this, item.getObjectId());
        startActivity(i);
    }

}
