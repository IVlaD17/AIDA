package com.example.aida.viewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aida.R;
import com.example.aida.models.Food;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class FoodsRecyclerViewAdapter extends RecyclerView.Adapter<FoodsRecyclerViewAdapter.FoodItemViewHolder> {
    private ArrayList<Food> foodItems;
    private Context context;

    public FoodsRecyclerViewAdapter(ArrayList<Food> foodItems, Context context) {
        this.foodItems = foodItems;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_food_item, parent, false);
        FoodItemViewHolder foodItemViewHolder = new FoodItemViewHolder(view);
        return foodItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        Food foodItem = foodItems.get(position);
        holder.cardTitle.setText(foodItem.getName());
        holder.cardSubtitle.setText(foodItem.getCategory().toString());
        holder.cardBodyLeft.setText(foodItem.leftColumn());
        holder.cardBodyRight.setText(foodItem.rightColumn());
    }

    @Override
    public int getItemCount() { return foodItems.size(); }

    public class FoodItemViewHolder extends RecyclerView.ViewHolder{
        MaterialCardView parentLayout;
        MaterialTextView cardTitle;
        MaterialTextView cardSubtitle;
        MaterialTextView cardBodyLeft;
        MaterialTextView cardBodyRight;

        public FoodItemViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.food_card);
            cardTitle = itemView.findViewById(R.id.food_card_title);
            cardSubtitle = itemView.findViewById(R.id.food_card_subtitle);
            cardBodyLeft = itemView.findViewById(R.id.food_card_body_left);
            cardBodyRight = itemView.findViewById(R.id.food_card_body_right);
        }
    }
}
