package com.example.aida.views.legacy;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aida.R;
import com.example.aida.viewModels.legacy.MealCalculatorViewModel;
import com.example.aida.viewAdapters.MealRecyclerViewAdapter;

public class MealCalculatorFragment extends Fragment {

    private MealCalculatorViewModel cViewModel;
    private static MealRecyclerViewAdapter cAdapter;

    public static MealCalculatorFragment newInstance() {
        return new MealCalculatorFragment();
    }

    public static MealRecyclerViewAdapter getMealRecyclerViewAdapter() { return cAdapter; }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meal_calculator, container, false);

        MainActivity.cAddJournalItemFAB.setVisibility(View.GONE);
        MainActivity.cAddMealItemFAB.setVisibility(View.VISIBLE);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewMCF);
        cAdapter = new MealRecyclerViewAdapter(MainActivity.mealEntries, getActivity());
        recyclerView.setAdapter(cAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cViewModel = ViewModelProviders.of(this).get(MealCalculatorViewModel.class);
    }
}
