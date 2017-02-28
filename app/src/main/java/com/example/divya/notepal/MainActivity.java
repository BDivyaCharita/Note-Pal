package com.example.divya.notepal;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_RETAINED_FRAGMENT = "NotesFragment";

    private NotesFragment mNoteFragment;
    private SpecialDaysFragment mSpecialDayFragment;
    private RemindersFragment mReminderFragment;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    BottomBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;
                switch (item.getItemId())
                {
                    case R.id.notes:
                        //
                        break;
                    case R.id.specialDays:
                       // intent = new Intent(MainActivity.this, MainActivity.this);
                       // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                       // startActivity(intent);
                }

                return false;
            }
        });


       /* mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId == R.id.notes)
                {
                    NotesFragment n = new NotesFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, n).commit();
                }
                else if(menuItemId == R.id.specialDays)
                {
                    SpecialDaysFragment n = new SpecialDaysFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, n).commit();
                }

                else if(menuItemId == R.id.reminders)
                {
                    RemindersFragment n = new RemindersFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, n).commit();
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }

        });

        mBottomBar.mapColorForTab(0, "#F44336");
        mBottomBar.mapColorForTab(1, "#F44336");
        mBottomBar.mapColorForTab(2, "#F44336");

        BottomBarBadge unread;
        unread = mBottomBar.makeBadgeForTabAt(1, "#FF0044", 13);
        unread.show(); */
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);

    }

}
