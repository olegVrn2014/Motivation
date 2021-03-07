package ru.livemotivation.motivation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_main:
                        Intent intent0 = new Intent(ru.livemotivation.motivation.SettingsActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_basics:
                        Intent intent1 = new Intent(ru.livemotivation.motivation.SettingsActivity.this, AdviceActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_oop:
                        Intent intent2 = new Intent(ru.livemotivation.motivation.SettingsActivity.this, ru.livemotivation.motivation.MotivationActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_collections:
                        Intent intent3 = new Intent(ru.livemotivation.motivation.SettingsActivity.this, HabitsActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_other:
                        break;
                }

                return false;
            }
        });
    }

}