package com.example.aida.viewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aida.views.MainActivity;
import com.example.aida.R;
import com.example.aida.models.foodModels.Food;
import com.example.aida.models.foodModels.FoodCategories;
import com.example.aida.models.mealModels.Meal;
import com.example.aida.utility.Constants;
import com.example.aida.utility.Methods;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MealRecyclerViewAdapter extends RecyclerView.Adapter<MealRecyclerViewAdapter.MealItemViewHolder>{
    private ArrayList<Meal> mealEntries;
    private Context context;
    private Food selectedFood;

    public MealRecyclerViewAdapter(ArrayList<Meal> mealEntries, Context context) {
        this.mealEntries = mealEntries;
        this.context = context;
    }

    @NonNull
    @Override
    public MealItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_meal_item, parent, false);
        MealItemViewHolder mealItemViewHolder = new MealItemViewHolder(view);
        return mealItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MealItemViewHolder holder, final int position) {
        final Meal mealEntry = mealEntries.get(position);

        holder.cardTitle.setText(mealEntry.getFoodItem().getName());
        holder.cardSubtitle.setText(mealEntry.getFoodItem().getCategory().toString());

        ArrayAdapter<Food> adapter = new ArrayAdapter<>(holder.parentLayout.getContext(), R.layout.dropdown_menu_popup_item, MainActivity.foodItems);
        AutoCompleteTextView editTextFilledExposedDropdown = holder.cardDropdownMenu;
        editTextFilledExposedDropdown.setAdapter(adapter);

        if(mealEntry.getFoodItem().getCategory() == FoodCategories.NONE) {
            holder.cardQtyInput.setVisibility(View.GONE);
            holder.cardItmInput.setVisibility(View.VISIBLE);
        }
        else{
            holder.cardQtyInput.setVisibility(View.VISIBLE);
            holder.cardItmInput.setVisibility(View.GONE);
        }

        EditText qtyInput = holder.cardQtyInput.getEditText();
        if(qtyInput != null) {
            qtyInput.setText(Integer.toString(mealEntry.getFoodAmount()));
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cardQtyInput.getVisibility() == View.VISIBLE) {
                    selectedFood = null;
                    holder.cardQtyInput.setVisibility(View.GONE);
                    holder.cardItmInput.setVisibility(View.VISIBLE);
                }
                else{
                    String foodName = holder.cardDropdownMenu.getText().toString();
                    selectedFood = Methods.findFoodItemByName(foodName, MainActivity.foodItems);

                    if(selectedFood != null) {
                        holder.cardQtyInput.setVisibility(View.VISIBLE);
                        holder.cardItmInput.setVisibility(View.GONE);
                    }
                    else{
                        Toast.makeText(v.getContext(), Constants.ERR_FOOD_EMPTY, Toast.LENGTH_LONG).show();
                    }
                }

                if(selectedFood != null) {
                    holder.cardTitle.setText(selectedFood.getName());
                    holder.cardSubtitle.setText(selectedFood.getCategory().toString());
                }
                else{
                    holder.cardTitle.setText("None");
                    holder.cardSubtitle.setText("None");
                }
            }
        });
    }

    @Override
    public int getItemCount() { return mealEntries.size(); }

    public class MealItemViewHolder extends RecyclerView.ViewHolder{
        MaterialCardView parentLayout;
        MaterialTextView cardTitle;
        MaterialTextView cardSubtitle;
        AutoCompleteTextView cardDropdownMenu;
        TextInputLayout cardQtyInput;
        TextInputLayout cardItmInput;

        public MealItemViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.meal_item_card);
            cardTitle = itemView.findViewById(R.id.meal_card_title);
            cardSubtitle = itemView.findViewById(R.id.meal_card_subtitle);
            cardDropdownMenu = itemView.findViewById(R.id.mealsFilledExposedDropdown);
            cardQtyInput = itemView.findViewById(R.id.meal_qtyTextInput);
            cardItmInput = itemView.findViewById(R.id.meal_mealsExposedDropdownMenu);
        }
    }
}
