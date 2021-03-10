package ru.livemotivation.motivation.Quote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.livemotivation.motivation.AdviceActivity;
import ru.livemotivation.motivation.App;
import ru.livemotivation.motivation.HabitsActivity;
import ru.livemotivation.motivation.MainActivity;
import ru.livemotivation.motivation.MotivationActivity;
import ru.livemotivation.motivation.R;
import ru.livemotivation.motivation.SettingsActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class QuoteGreatPeople extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_great_people);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Цитаты великих людей");



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        ru.livemotivation.motivation.BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_note:
                        Intent intent0 = new Intent(QuoteGreatPeople.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_advice:
                        Intent intent1 = new Intent(QuoteGreatPeople.this, AdviceActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_motivation:
                        Intent intent2 = new Intent(QuoteGreatPeople.this, MotivationActivity.class);
                        startActivity(intent2);
                        break;


                    case R.id.ic_habits:
                        Intent intent3 = new Intent(QuoteGreatPeople.this, HabitsActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_settings:
                        Intent intent4 = new Intent(QuoteGreatPeople.this, SettingsActivity.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_quote, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
//            case R.id.action_search:
//                Toast.makeText(this, "Поиск", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }


}