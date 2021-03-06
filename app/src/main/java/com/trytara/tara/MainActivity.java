package com.trytara.tara;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import com.parse.FindCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.trytara.tara.fragments.AddBusinessFragment;
import com.trytara.tara.fragments.CategoryListFragment;
import com.trytara.tara.fragments.TrendingListFragment;
import com.trytara.tara.models.Business;

import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Debug";

    private ProfilePictureView mProfilePictureView;
    private TextView mFacebookName;
    private TextView mAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        navigationView.setNavigationItemSelectedListener(this);

        mProfilePictureView = (ProfilePictureView) headerLayout.findViewById(R.id.facebook_profile_photo);
        mProfilePictureView.setPresetSize(ProfilePictureView.SMALL);

        mFacebookName = (TextView) headerLayout.findViewById(R.id.facebook_name);
        mAddress = (TextView) headerLayout.findViewById(R.id.address);

        Button logOutButton = (Button) headerLayout.findViewById(R.id.logout);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOutInBackground(new LogOutCallback() {
                    @Override
                    public void done(ParseException e) {
                        finish();
                    }
                });
            }
        });


        if (ParseUser.getCurrentUser() != null) {
//            Log.d(TAG, "UPDATE FB INFO");
            mProfilePictureView.setProfileId(ParseUser.getCurrentUser().getString("facebookID"));
            mFacebookName.setText(ParseUser.getCurrentUser().getString("name"));
            String address = ParseUser.getCurrentUser().getString("address");
            if (TextUtils.isEmpty(address)) {
                mAddress.setText("No address given");
            } else {
                mAddress.setText(ParseUser.getCurrentUser().getString("address"));
            }
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new CategoryListFragment())
                .commit();

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = new Fragment();
        switch (id) {
            case R.id.nav_categories:
                fragment = new CategoryListFragment();
                break;
            case R.id.nav_search:
                break;
            case R.id.nav_trending:
                fragment = new TrendingListFragment();
                break;
            case R.id.nav_favorites:
                break;
            case R.id.nav_recently_viewed:
                break;
            case R.id.nav_checkins:
                break;
            case R.id.nav_reviews:
                break;
            case R.id.nav_add_business:
                fragment = new AddBusinessFragment();
                break;
            case R.id.nav_my_business:
                break;
            case R.id.settings:
                break;
            case R.id.nav_report_bug:
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setTitle(item.getTitle());
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
