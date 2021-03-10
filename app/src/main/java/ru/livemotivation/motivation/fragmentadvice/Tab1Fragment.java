package ru.livemotivation.motivation.fragmentadvice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.livemotivation.motivation.R;
import ru.livemotivation.motivation.Quote.RecyclerViewAdapterQuote;
import ru.livemotivation.motivation.Quote.RecyclerViewQuote;


public class Tab1Fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        ArrayList<RecyclerViewQuote> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.great_people1,"Цитаты великих людей","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.books_2,"Цитаты из книг","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.songs3,"Цитаты из песен","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.films4,"Цитаты из фильмов","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.life5,"Цитаты про жизнь","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.mean6,"Цитаты со смыслом","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.succes7,"Успех","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.frase8,"Умные фразы","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.happiness9,"Счастье","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.friemds10,"Дружба и друзья","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.life11,"Короткие о жизни","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.beautufull12,"Красивые цитаты","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.love13,"Любовь","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.dreams14,"Мечты","100+"));
        recyclerViewItems.add(new RecyclerViewQuote(R.drawable.though15,"Мысли","100+"));


        recyclerView = view.findViewById(R.id.recyclerViewQuote);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapterQuote(recyclerViewItems,getContext());
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}