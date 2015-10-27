package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    public View getProgress() {
        return mProgress;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String itemId = getIntent().getStringExtra(EXTRA_ITEM_ID);

        mProgress = findViewById(R.id.progress);
        mProgress.setVisibility(View.VISIBLE);

        Item.getItem(itemId, new Item.OnGetItemCallback() {
            @Override
            public void onGetItem(Item item) {
                mItem = item;
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.item_fragment);
                if (fragment == null) {
                    fragment = new BusinessItemDetailFragment();
                    fm.beginTransaction()
                            .add(R.id.item_fragment, fragment)
                            .commit();

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
