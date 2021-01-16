package com.qiraht.kuliah.testingapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qiraht.kuliah.testingapps.fragment.FavoriteFragment;
import com.qiraht.kuliah.testingapps.fragment.ResultFragment;
import com.qiraht.kuliah.testingapps.fragment.ScheduleFragment;
import com.qiraht.kuliah.testingapps.model.MatchResult.EventsItem;
import com.qiraht.kuliah.testingapps.model.MatchResult.ResponseResult;
import com.qiraht.kuliah.testingapps.retrofit.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new ScheduleFragment());
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_result:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Match Result");
                }
                fragment = new ResultFragment();
                break;

            case R.id.navigation_schedule:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Match Schedule");
                }
                fragment = new ScheduleFragment();
                break;

            case R.id.navigation_favorite:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Favorite");
                }
                fragment = new FavoriteFragment();
                break;
        }

        return loadFragment(fragment);
    }



}