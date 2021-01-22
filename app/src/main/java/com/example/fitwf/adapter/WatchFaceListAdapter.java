package com.example.fitwf.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitwf.R;

import static com.example.fitwf.Utils.Base.changeVisibility;
import static com.example.fitwf.Utils.Text.changeSelectedWithDelay;

public class WatchFaceListAdapter extends RecyclerView.Adapter<WatchFaceListAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_wf, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View card) {
            super(card);
            imageView = card.findViewById(R.id.imageView10);
            textView = card.findViewById(R.id.textView7);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeVisibility(textView);
                    changeSelectedWithDelay(textView);
                }
            });
        }
    }
}















