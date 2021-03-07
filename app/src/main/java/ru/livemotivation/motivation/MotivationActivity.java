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


public class MotivationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        ru.livemotivation.motivation.BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_main:
                        Intent intent0 = new Intent(ru.livemotivation.motivation.MotivationActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_basics:
                        Intent intent1 = new Intent(ru.livemotivation.motivation.MotivationActivity.this, AdviceActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_oop:

                        break;

                    case R.id.ic_collections:
                        Intent intent3 = new Intent(ru.livemotivation.motivation.MotivationActivity.this, HabitsActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_other:
                        Intent intent4 = new Intent(ru.livemotivation.motivation.MotivationActivity.this, SettingsActivity.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });
    }


}