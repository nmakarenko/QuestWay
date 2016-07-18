package com.test.questway;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.test.questway.fragment.FriendsFragment;
import com.test.questway.fragment.MailFragment;
import com.test.questway.fragment.OrganizersFragment;
import com.test.questway.fragment.QuestsFragment;
import com.test.questway.fragment.SettingsFragment;
import com.test.questway.fragment.TasksFragment;
import com.test.questway.fragment.TeamsFragment;
import com.test.questway.model.Photo;

public class ProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView ivPhoto;

    public static float density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        density = dm.density;

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer != null) {
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();



            drawer.openDrawer(Gravity.LEFT);
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //  View header = LayoutInflater.from(this).inflate(R.layout.nav_header_profile, null);
        //   navigationView.addHeaderView(header);
        View header = navigationView.getHeaderView(0);
        ivPhoto = (ImageView) header.findViewById(R.id.ivPhoto);
        ivPhoto.setImageBitmap(Photo.getCircularBitmap(
                BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.photo_me),
                (int) (ProfileActivity.density * 60)));
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
        getMenuInflater().inflate(R.menu.profile, menu);
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


        if (id == R.id.nav_friends) {
            FriendsFragment fragment = new FriendsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();
        } else if (id == R.id.nav_teams) {
            TeamsFragment fragment = new TeamsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();
        } else if (id == R.id.nav_messages) {
            MailFragment fragment = new MailFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();
        } else if (id == R.id.nav_quests) {
            QuestsFragment fragment = new QuestsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();

        } else if (id == R.id.nav_tasks) {
            TasksFragment fragment = new TasksFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();
        } else if (id == R.id.nav_organizers) {
            OrganizersFragment fragment = new OrganizersFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();
        } else if (id == R.id.nav_settings) {
            SettingsFragment fragment = new SettingsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerMain, fragment, "")
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }


}
