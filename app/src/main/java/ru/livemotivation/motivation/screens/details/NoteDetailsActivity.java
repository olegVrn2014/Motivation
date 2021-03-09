package ru.livemotivation.motivation.screens.details;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.livemotivation.motivation.AdviceActivity;
import ru.livemotivation.motivation.App;
import ru.livemotivation.motivation.BottomNavigationViewHelper;
import ru.livemotivation.motivation.HabitsActivity;
import ru.livemotivation.motivation.MainActivity;
import ru.livemotivation.motivation.MotivationActivity;
import ru.livemotivation.motivation.R;
import ru.livemotivation.motivation.SettingsActivity;
import ru.livemotivation.motivation.model.Note;

public class NoteDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_NOTE = "NoteDetailsActivity.EXTRA_NOTE";

    private Note note;

    private EditText editText;
    private Button buttonAdd;

    public static void start(Activity caller, Note note) {
        Intent intent = new Intent(caller, NoteDetailsActivity.class);
        if (note != null) {
            intent.putExtra(EXTRA_NOTE, note);
        }
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setTitle(getString(R.string.new_note));

        editText = findViewById(R.id.text);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if (editText.getText().length() > 0) {
                            note.text = editText.getText().toString();
                            note.done = false;
                            note.timestamp = System.currentTimeMillis();
                            if (getIntent().hasExtra(EXTRA_NOTE)) {
                                App.getInstance().getNoteDao().update(note);
                            } else {
                                App.getInstance().getNoteDao().insert(note);
                            }
                            finish();
                        }

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_quote:
                        break;

                    case R.id.ic_advice:
                        Intent intent1 = new Intent(NoteDetailsActivity.this, AdviceActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_motivation:
                        Intent intent2 = new Intent(NoteDetailsActivity.this, MotivationActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_habits:
                        Intent intent3 = new Intent(NoteDetailsActivity.this, HabitsActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_settings:
                        Intent intent4 = new Intent(NoteDetailsActivity.this, SettingsActivity.class);
                        startActivity(intent4);

                        break;
                }
                return false;
            }
        });

        if (getIntent().hasExtra(EXTRA_NOTE)) {
            note = getIntent().getParcelableExtra(EXTRA_NOTE);
            editText.setText(note.text);
        } else {
            note = new Note();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_save:
                if (editText.getText().length() > 0) {
                    note.text = editText.getText().toString();
                    note.done = false;
                    note.timestamp = System.currentTimeMillis();
                    if (getIntent().hasExtra(EXTRA_NOTE)) {
                        App.getInstance().getNoteDao().update(note);
                    } else {
                        App.getInstance().getNoteDao().insert(note);
                    }
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
