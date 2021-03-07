package ru.livemotivation.motivation.screens.main;


import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import ru.livemotivation.motivation.App;
import ru.livemotivation.motivation.model.Note;

public class MainViewModel extends ViewModel {
    private LiveData<List<Note>> noteLiveData = App.getInstance().getNoteDao().getAllLiveData();

    public LiveData<List<Note>> getNoteLiveData() {
        return noteLiveData;
    }
}
