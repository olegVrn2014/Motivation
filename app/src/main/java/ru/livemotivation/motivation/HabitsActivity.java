package ru.livemotivation.motivation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class HabitsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habits);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        ru.livemotivation.motivation.BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_quote:
                        Intent intent0 = new Intent(ru.livemotivation.motivation.HabitsActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_advice:
                        Intent intent1 = new Intent(ru.livemotivation.motivation.HabitsActivity.this, AdviceActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_motivation:
                        Intent intent2 = new Intent(ru.livemotivation.motivation.HabitsActivity.this, ru.livemotivation.motivation.MotivationActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_habits:

                        break;

                    case R.id.ic_settings:
                        Intent intent4 = new Intent(ru.livemotivation.motivation.HabitsActivity.this, ru.livemotivation.motivation.SettingsActivity.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

}

