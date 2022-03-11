package com.sergei.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CallAdapter extends RecyclerView.Adapter<CallViewHolder> {

    private List<String> numbers;
    private LayoutInflater inflater;

    public CallAdapter(Context context, List<String> numbers){
        this.inflater = LayoutInflater.from(context);
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new CallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallViewHolder holder, int position) {
        String number = numbers.get(position);
        TextView txtView = holder.itemView.findViewById(R.id.txtNumber);
        txtView.setText(number);

    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }
}
