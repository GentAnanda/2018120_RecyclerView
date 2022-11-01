package com.example.recyclerview1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview1.R;
import com.example.recyclerview1.models.Drink;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.MyViewHolder> {
    List<Drink> drinkList;
    OnItemClickCallback onItemClickCallback;

    public DrinkAdapter(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public DrinkAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View drinkView = layoutInflater.inflate(R.layout.item_drink,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(drinkView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkAdapter.MyViewHolder holder, int position) {
        Drink drink = drinkList.get(position);
        holder.drinkName.setText(drink.getName());
        holder.drinkPrice.setText(drink.getPrice());
        Glide.with(holder.itemView.getContext())
                .load(drink.getLogo())
                .apply(new RequestOptions().override(80,80))
                .into(holder.drinkPhoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(drinkList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
//        return 0;
        return (drinkList != null) ? drinkList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView drinkName, drinkPrice;
        public ImageView drinkPhoto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            drinkName = itemView.findViewById(R.id.tv_title);
            drinkPrice = itemView.findViewById(R.id.tv_price);
            drinkPhoto = itemView.findViewById(R.id.image_logo);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Drink data);
    }
}
