package com.trytara.tara;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.trytara.tara.fragments.business.BusinessItemDetailActivityFragment;

public class BusinessItemDetailActivity extends AppCompatActivity {

    private static final String EXTRA_POSITION = "com.trytara.tara.BusinessItemDetailActivity.position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment);

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        if (fragment == null) {
            fragment = BusinessItemDetailActivityFragment.newInstance(position);
            fm.beginTransaction()
                    .add(R.id.fragment, fragment)
                    .commit();

        }
    }

    public static Intent newIntent(Context packageContext, int position) {
        Intent intent = new Intent(packageContext, BusinessItemDetailActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        return intent;
    }

}
