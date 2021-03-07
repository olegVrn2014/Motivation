package ru.livemotivation.motivation;

import android.app.Application;
import androidx.room.Room;
import ru.livemotivation.motivation.data.AppDatabase;
import ru.livemotivation.motivation.data.NoteDao;

public class App extends Application {

    private AppDatabase database;
    private NoteDao noteDao;

    private static ru.livemotivation.motivation.App instance;

    public static ru.livemotivation.motivation.App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}
