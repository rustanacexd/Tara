package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trytara.tara.adapters.ViewPagerAdapter;
import com.trytara.tara.adapters.business.BusinessDetailMenuAdapter;
import com.trytara.tara.fragments.business.BusinessAboutFragment;
import com.trytara.tara.fragments.business.BusinessContactFragment;
import com.trytara.tara.fragments.business.BusinessDetailMenuFragment;
import com.trytara.tara.fragments.business.BusinessReviewFragment;
import com.trytara.tara.models.Item;

public class BusinessDetailActivity extends AppCompatActivity implements BusinessDetailMenuAdapter.OnBusinessItemClickListener {

    private static final String EXTRA_PREFIX = "com.trytara.tara.BusinessDetailActivity";
    private static final String EXTRA_BUSINESS_ID = EXTRA_PREFIX + "businessId";
    private static final String EXTRA_BUSINESS_TITLE = EXTRA_PREFIX + "businessTitle";
    private static final String EXTRA_BUSINESS_DESCRIPTION = EXTRA_PREFIX + "businessDescription";

    private static final int REQUEST_BACK = 563;
    private String mBusinessId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.business_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_BUSINESS_TITLE));
        TextView businessDescriptionView = (TextView) findViewById(R.id.business_description);
        mBusinessId = getIntent().getStringExtra(EXTRA_BUSINESS_ID);
        businessDescriptionView.setText(getIntent().getStringExtra(EXTRA_BUSINESS_DESCRIPTION));

        ViewPager viewPager = (ViewPager) findViewById(R.id.business_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.business_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public String getBusinessId() {
        return mBusinessId;
    }


    public static Intent newIntent(Context packageContext, String businessId, String businessName,
                                   String businessDescription) {
        Intent intent = new Intent(packageContext, BusinessDetailActivity.class);
        intent.putExtra(EXTRA_BUSINESS_ID, businessId);
        intent.putExtra(EXTRA_BUSINESS_TITLE, businessName);
        intent.putExtra(EXTRA_BUSINESS_DESCRIPTION, businessDescription);
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
        Intent i = BusinessItemDetailActivity.newIntent(this, item);
        startActivityForResult(i, REQUEST_BACK);
    }



    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        if (requestCode == REQUEST_BACK) {
            mBusiness = data.getParcelableExtra(BusinessItemDetailActivity.EXTRA_BUSINESS);
        }
    }*/
}
