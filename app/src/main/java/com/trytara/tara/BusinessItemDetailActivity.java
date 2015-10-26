package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.trytara.tara.fragments.business.BusinessItemDetailActivityFragment;
import com.trytara.tara.models.Item;


public class BusinessItemDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM = "com.trytara.tara.BusinessItemDetailActivity.item";

    private String mItemId;

    public String getItemId() {
        return mItemId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.item_fragment);

        mItemId = getIntent().getStringExtra(EXTRA_ITEM);

        if (fragment == null) {
            fragment = new BusinessItemDetailActivityFragment();
            fm.beginTransaction()
                    .add(R.id.item_fragment, fragment)
                    .commit();

        }
    }

    public static Intent newIntent(Context packageContext, Item item) {
        Intent intent = new Intent(packageContext, BusinessItemDetailActivity.class);
        //intent.putExtra(EXTRA_ITEM, item);
        return intent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void setBackData() {
        Intent data = new Intent();
        setResult(RESULT_OK, data);
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
