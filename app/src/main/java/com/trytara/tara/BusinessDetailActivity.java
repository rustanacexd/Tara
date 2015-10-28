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
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Item;

import java.util.List;

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

    public String mBusinessId;
    public String mBusinessAbout;
    public String mPhoneNumber;
    public String mMobileNumber;
    public String mEmail;
    public String mAddress;
    public Business mBusiness;

    private AppBarLayout mAppBarLayout;
    private List<Item> mItems;

    private BusinessDetailMenuFragment mBusinessDetailMenuFragment;
    private BusinessReviewFragment mBusinessReviewFragment;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        mBusinessDetailMenuFragment = new BusinessDetailMenuFragment();
        mBusinessReviewFragment = new BusinessReviewFragment();

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

        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mBusinessDetailMenuFragment.mLayoutManager != null) {
                    mBusinessDetailMenuFragment.mLayoutManager.scrollToPositionWithOffset(0, 200);
                }

                if (mBusinessReviewFragment.mLinearLayoutManager != null) {
                    mBusinessReviewFragment.mLinearLayoutManager.scrollToPositionWithOffset(0, 200);
                }

                mAppBarLayout.setExpanded(true);
                mFab.hide();
            }
        });

        if (mBusiness == null) {
            Business.getBusiness(mBusinessId, new Business.OnGetBusinessCallback() {
                @Override
                public void onGetBusiness(Business business) {
                    mBusiness = business;
                    mItems = business.getItems();
                    onBusinessDetailMenuFragmentCreate();
                }
            });
        }

        initViews();

        ViewPager viewPager = (ViewPager) findViewById(R.id.business_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.business_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onBusinessDetailMenuFragmentCreate() {
        mBusinessDetailMenuFragment.mItemsList.addAll(mItems);
        mBusinessDetailMenuFragment.mAdapter.notifyDataSetChanged();
        mBusinessDetailMenuFragment.mProgress.setVisibility(View.GONE);
        mBusinessDetailMenuFragment.mRvBusinessMenuList.setVisibility(View.VISIBLE);
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
        adapter.addFrag(mBusinessDetailMenuFragment, "Menu");
        adapter.addFrag(new BusinessAboutFragment(), "About");
        adapter.addFrag(mBusinessReviewFragment, "Reviews");
        adapter.addFrag(new BusinessContactFragment(), "Contact");
        viewPager.setAdapter(adapter);
    }

    private enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private void initViews() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            private State state;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (state != State.EXPANDED) {

                    }
                    state = State.EXPANDED;
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != State.COLLAPSED) {
                        mFab.hide();
                    }
                    state = State.COLLAPSED;
                } else {
                    if (state != State.IDLE) {

                    }
                    state = State.IDLE;
                }
            }
        });
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
