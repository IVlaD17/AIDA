package com.example.aida.dal;

import androidx.annotation.NonNull;

import com.example.aida.models.foodModels.Food;
import com.example.aida.viewModels.ViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FoodManager extends RestService {
    private ArrayList<Food> foods;

    public FoodManager(ViewModel viewModel, ArrayList<Food> foods) {
        super(viewModel);

        if(foods == null) {
            this.foods = new ArrayList<>();
        } else {
            this.foods = foods;
        }
    }

    // Used for Generating a Food Object from a Database Document
    private Food genFood(DocumentSnapshot document){
        String id = document.getId();
        String name = document.getData().get("name").toString();
        String category = document.getData().get("category").toString();
        float carbs = Float.valueOf(document.getData().get("carbohydrates").toString());
        float sugars = Float.valueOf(document.getData().get("sugars").toString());
        float fat = Float.valueOf(document.getData().get("fat").toString());
        float saturates = Float.valueOf(document.getData().get("saturates").toString());
        float energy = Float.valueOf(document.getData().get("energy").toString());
        float fiber = Float.valueOf(document.getData().get("fiber").toString());
        float protein = Float.valueOf(document.getData().get("protein").toString());
        float salt = Float.valueOf(document.getData().get("salt").toString());

        return new Food(id, name, category, carbs, sugars, fat, saturates, energy, fiber, protein, salt);
    }

    // Used for Getting Foods from the Database
    public void read(){
        database.collection(foodsPath).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    ArrayList<Food> foods = new ArrayList<>();
                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    for(DocumentSnapshot document : documents){
                        foods.add(genFood(document));
                    }

                    //TODO: Add Callback Method
                }
            }
        });
    }
}
