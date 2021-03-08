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

