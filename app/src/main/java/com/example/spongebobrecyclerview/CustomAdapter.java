package com.example.spongebobrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet, RecyclerViewInterface recyclerViewInterface) {
        this.dataSet = dataSet;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public void setFilteredList(ArrayList<DataModel> filteredList){
        this.dataSet = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(dataSet.get(position).getName());
        holder.textViewVersion.setText(dataSet.get(position).getSubtext());
        holder.imageView.setImageResource(dataSet.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
