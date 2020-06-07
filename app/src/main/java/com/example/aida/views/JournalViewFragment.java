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
import com.example.aida.viewModels.JournalViewViewModel;
import com.example.aida.viewAdapters.JournalRecyclerViewAdapter;

public class JournalViewFragment extends Fragment {

    private JournalViewViewModel cViewModel;
    private static JournalRecyclerViewAdapter cAdapter;

    public static JournalViewFragment newInstance() {
        return new JournalViewFragment();
    }

    public static JournalRecyclerViewAdapter getMealRecyclerViewAdapter() { return cAdapter; }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_journal_view, container, false);

        MainActivity.cAddJournalItemFAB.setVisibility(View.VISIBLE);
        MainActivity.cAddMealItemFAB.setVisibility(View.GONE);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewJVF);
        cAdapter = new JournalRecyclerViewAdapter(MainActivity.journalEntries, getActivity());
        recyclerView.setAdapter(cAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MainActivity.getJournalEntries(cAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cViewModel = ViewModelProviders.of(this).get(JournalViewViewModel.class);
    }
}
