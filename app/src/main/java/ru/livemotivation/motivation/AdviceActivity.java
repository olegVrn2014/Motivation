package ru.livemotivation.motivation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import ru.livemotivation.motivation.fragmentadvice.Tab1Fragment;
import ru.livemotivation.motivation.fragmentadvice.Tab2Fragment;
import ru.livemotivation.motivation.fragmentadvice.Tab3Fragment;


public class AdviceActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advice);

        SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_basics_bottom);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_collections_bottom);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setText("Цитаты");
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText("Статьи");
        Objects.requireNonNull(tabLayout.getTabAt(2)).setText("Полезное");

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
                        Intent intent0 = new Intent(ru.livemotivation.motivation.AdviceActivity.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_advice:

                        break;

                    case R.id.ic_motivation:
                        Intent intent2 = new Intent(ru.livemotivation.motivation.AdviceActivity.this, MotivationActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_habits:
                        Intent intent3 = new Intent(ru.livemotivation.motivation.AdviceActivity.this, HabitsActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_settings:
                        Intent intent4 = new Intent(ru.livemotivation.motivation.AdviceActivity.this, SettingsActivity.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }
}