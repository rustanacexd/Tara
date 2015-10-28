package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.trytara.tara.fragments.business.BusinessItemDetailFragment;
import com.trytara.tara.models.Item;


public class BusinessItemDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM_ID = "com.trytara.tara.BusinessItemDetailActivity.item";

    private Item mItem;
    private View mProgress;
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private String mItemId;

    public View getProgress() {
        return mProgress;
    }

    public String getItemId() {
        return mItemId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_item_detail);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);


        mItemId = getIntent().getStringExtra(EXTRA_ITEM_ID);

        mProgress = findViewById(R.id.progress);
        mProgress.setVisibility(View.VISIBLE);
        

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.item_fragment);
        if (fragment == null) {
            fragment = new BusinessItemDetailFragment();
            fm.beginTransaction()
                    .add(R.id.item_fragment, fragment)
                    .commit();

        }

        initViews();
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
                        //mCollapsingToolbarLayout.setTitle("EXPANDED");
                        getSupportActionBar().setTitle("BUSINESS NAME");
                        mCollapsingToolbarLayout.setTitleEnabled(false);
                    }
                    state = State.EXPANDED;
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != State.COLLAPSED) {
                        //mCollapsingToolbarLayout.setTitle("COLLAPSED");
                        mCollapsingToolbarLayout.setTitleEnabled(false);
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


    public Item getItem() {
        return mItem;
    }

    public static Intent newIntent(Context packageContext, String itemId) {
        Intent intent = new Intent(packageContext, BusinessItemDetailActivity.class);
        intent.putExtra(EXTRA_ITEM_ID, itemId);
        return intent;
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
}
