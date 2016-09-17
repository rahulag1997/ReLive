package com.example.rahul.relive;



import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout fullLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private int selectedNavItemId;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        /**
         * This is going to be our actual root layout.
         */
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        /**
         * {@link FrameLayout} to inflate the child's view. We could also use a {@link android.view.ViewStub}
         */
        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        /**
         * Note that we don't pass the child's layoutId to the parent,
         * instead we pass it our inflated layout.
         */
        super.setContentView(fullLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        if (useToolbar())
        {
            setSupportActionBar(toolbar);
        }
        else
        {
            toolbar.setVisibility(View.GONE);
        }

        setUpNavView();
    }

    /**
     * Helper method that can be used by child classes to
     * specify that they don't want a {@link Toolbar}
     * @return true
     */
    protected boolean useToolbar()
    {
        return true;
    }

    protected void setUpNavView()
    {
        navigationView.setNavigationItemSelectedListener(this);

        if( useDrawerToggle()) { // use the hamburger menu
            drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar,
                    R.string.nav_drawer_opened,
                    R.string.nav_drawer_closed);

            fullLayout.setDrawerListener(drawerToggle);
            drawerToggle.syncState();
        } else if(useToolbar() && getSupportActionBar() != null) {
            // Use home/back button instead
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(getResources()
                    .getDrawable(R.drawable.back));
        }
    }

    /**
     * Helper method to allow child classes to opt-out of having the
     * hamburger menu.
     * @return
     */
    protected boolean useDrawerToggle()
    {
        return true;
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        fullLayout.closeDrawer(GravityCompat.START);
        selectedNavItemId = menuItem.getItemId();

        return onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.nav_camera:
                startActivity(new Intent(this, NewMoment.class));
                finish();
                return true;

            case R.id.nav_gallery:
                startActivity(new Intent(this, Buddies.class));
                return true;

            case R.id.nav_slideshow:
                startActivity(new Intent(this, ViewMoments.class));
                return true;

            case R.id.nav_manage :
                startActivity(new Intent(this, Settings.class));
                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    }



