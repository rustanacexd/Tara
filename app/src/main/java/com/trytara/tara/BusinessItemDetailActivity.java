package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.trytara.tara.fragments.business.BusinessItemDetailActivityFragment;
import com.trytara.tara.models.Business.Item;

public class BusinessItemDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM = "com.trytara.tara.BusinessItemDetailActivity.item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.item_fragment);

        Item item = getIntent().getParcelableExtra(EXTRA_ITEM);

        if (fragment == null) {
            fragment = BusinessItemDetailActivityFragment.newInstance(item);
            fm.beginTransaction()
                    .add(R.id.item_fragment, fragment)
                    .commit();

        }
    }

    public static Intent newIntent(Context packageContext, Item item) {
        Intent intent = new Intent(packageContext, BusinessItemDetailActivity.class);
        intent.putExtra(EXTRA_ITEM, item);
        return intent;
    }

}
