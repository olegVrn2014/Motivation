package ru.livemotivation.motivation.Quote;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.livemotivation.motivation.MotivationActivity;
import ru.livemotivation.motivation.R;
import ru.livemotivation.motivation.SettingsActivity;

public class RecyclerViewAdapterQuote extends RecyclerView.Adapter<RecyclerViewAdapterQuote.RececlerViewViewHolder> {
    private ArrayList<RecyclerViewQuote> arrayList;
    Context context;


    class RececlerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public RececlerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }

        @Override
        public void onClick(View v) {
            switch (getAdapterPosition()){
                case 0:
                    Intent intent = new Intent(context, QuoteGreatPeople.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(context, QuoteFromBooks.class);
                    context.startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(context, QuoteFromSongs.class);
                    context.startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(context, QuoteFromFilms.class);
                    context.startActivity(intent3);
                    break;
                case 4:
                    Intent intent4 = new Intent(context, QuoteAboutLife.class);
                    context.startActivity(intent4);
                    break;
                case 5:
                    Intent intent5 = new Intent(context, QuiteWithMeans.class);
                    context.startActivity(intent5);
                    break;
                case 6:
                    Intent intent6 = new Intent(context, QuiteSuccess.class);
                    context.startActivity(intent6);
                    break;
                case 7:
                    Intent intent7 = new Intent(context, QuiteSmartFrases.class);
                    context.startActivity(intent7);
                    break;
                case 8:
                    Intent intent8 = new Intent(context, QuiteHappiness.class);
                    context.startActivity(intent8);
                    break;
                case 9:
                    Intent intent9 = new Intent(context, QuiteFriends.class);
                    context.startActivity(intent9);
                    break;
                case 10:
                    Intent intent10 = new Intent(context, QuiteAboutLifeShort.class);
                    context.startActivity(intent10);
                    break;
                case 11:
                    Intent intent11 = new Intent(context, QuiteBeautifull.class);
                    context.startActivity(intent11);
                    break;
                case 12:
                    Intent intent12 = new Intent(context, QuiteLove.class);
                    context.startActivity(intent12);
                    break;
                case 13:
                    Intent intent13 = new Intent(context, QuiteDreams.class);
                    context.startActivity(intent13);
                    break;
                case 14:
                    Intent intent14 = new Intent(context, QuiteThough.class);
                    context.startActivity(intent14);
                    break;
            }


        }
    }

    public RecyclerViewAdapterQuote(ArrayList<RecyclerViewQuote> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RececlerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_advice_quote, viewGroup, false);
        RececlerViewViewHolder receclerViewViewHolder = new RececlerViewViewHolder(view);
        return receclerViewViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RececlerViewViewHolder receclerViewViewHolder, int i) {
        RecyclerViewQuote recyclerViewItem = arrayList.get(i);
        receclerViewViewHolder.imageView.setImageResource(recyclerViewItem.getImageResource());
        receclerViewViewHolder.textView1.setText(recyclerViewItem.getText1());
        receclerViewViewHolder.textView2.setText(recyclerViewItem.getText2());

    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

