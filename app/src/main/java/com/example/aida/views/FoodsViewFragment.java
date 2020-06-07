package com.example.aida.views;

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
import com.example.aida.viewModels.FoodsViewViewModel;
import com.example.aida.viewAdapters.FoodsRecyclerViewAdapter;

public class FoodsViewFragment extends Fragment {

    private FoodsViewViewModel cViewModel;
    private FoodsRecyclerViewAdapter cAdapter;

    public static FoodsViewFragment newInstance() {
        return new FoodsViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_foods_view, container, false);

        MainActivity.cAddJournalItemFAB.setVisibility(View.GONE);
        MainActivity.cAddMealItemFAB.setVisibility(View.GONE);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewFVF);
        cAdapter = new FoodsRecyclerViewAdapter(MainActivity.foodItems, getActivity());
        recyclerView.setAdapter(cAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cViewModel = ViewModelProviders.of(this).get(FoodsViewViewModel.class);
    }

}
