package com.neildg.mobidev_handsonrepo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.neildg.mobidev_handsonrepo.activity_catchup.PersonListActivity;
import com.neildg.mobidev_handsonrepo.activity_firebase.LoginActivity;
import com.neildg.mobidev_handsonrepo.activity_lifecycle.LifecycleActivity;
import com.neildg.mobidev_handsonrepo.activity_lifecycle.LifecycleActivityWorkspace;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.ChooseMusicActivity;
import com.neildg.mobidev_handsonrepo.activity_restaurant.ChooseRestoWorkActivity;
import com.neildg.mobidev_handsonrepo.activity_thread.ThreadActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This app was made by Neil Del Gallego.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_lifecycle_test){
            //initialize intent
            Intent i = new Intent(MainActivity.this,LifecycleActivity.class);
            this.startActivity(i);
        }
        if(id == R.id.nav_lifecycle_test_2) {
            Intent i = new Intent(MainActivity.this,LifecycleActivityWorkspace.class);
            this.startActivity(i);
        }

        if(id == R.id.nav_restaurant) {
            Intent i = new Intent(MainActivity.this, ChooseRestoWorkActivity.class);
            this.startActivity(i);
        }

        if(id == R.id.nav_music_player) {
            Intent i = new Intent(MainActivity.this, ChooseMusicActivity.class);
            this.startActivity(i);
        }

        if(id == R.id.nav_firebase) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            this.startActivity(i);
        }

        if(id == R.id.nav_catchup) {
            Intent i = new Intent(MainActivity.this, PersonListActivity.class);
            this.startActivity(i);
        }

        if(id == R.id.nav_thread) {
            Intent i = new Intent(MainActivity.this, ThreadActivity.class);
            this.startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
