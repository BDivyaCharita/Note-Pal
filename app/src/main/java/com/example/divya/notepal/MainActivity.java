package com.example.divya.notepal;

import android.support.annotation.IdRes;
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

    BottomBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
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
        unread.show();
    }



}
