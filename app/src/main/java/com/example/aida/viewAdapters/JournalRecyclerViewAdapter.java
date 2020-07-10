package com.example.aida.viewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aida.models.journalModels.JEntry;
import com.example.aida.views.legacy.MainActivity;
import com.example.aida.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class JournalRecyclerViewAdapter extends RecyclerView.Adapter<JournalRecyclerViewAdapter.JournalItemViewHolder> {
    private ArrayList<JEntry> journalEntries;
    private Context context;

    public JournalRecyclerViewAdapter(ArrayList<JEntry> journalEntries, Context context){
        this.journalEntries = journalEntries;
        this.context = context;
    }

    @NonNull
    @Override
    public JournalItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_jentry, parent, false);
        JournalItemViewHolder journalItemViewHolder = new JournalItemViewHolder(view);
        return journalItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JournalItemViewHolder holder, int position) {
        final JEntry entry = journalEntries.get(position);
        holder.cardTitle.setText(entry.getDate().toString());
        holder.cardSubtitle.setText(entry.getTime().toString());
        holder.cardBodyLeft.setText(entry.toString());
        holder.cardBodyRight.setText(entry.toString());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.selectedEntry = entry;
                MainActivity.navigateToEntryEditScreen();
            }
        });
    }

    @Override
    public int getItemCount() { return journalEntries.size(); }

    public class JournalItemViewHolder extends RecyclerView.ViewHolder{

        MaterialCardView parentLayout;
        MaterialTextView cardTitle;
        MaterialTextView cardSubtitle;
        MaterialTextView cardBodyLeft;
        MaterialTextView cardBodyRight;

        public JournalItemViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.cntJEntryCardJCL);
            cardTitle = itemView.findViewById(R.id.lblDateJCL);
            cardSubtitle = itemView.findViewById(R.id.lblTimeJCL);
            cardBodyLeft = itemView.findViewById(R.id.lblDataLabelsJCL);
            cardBodyRight = itemView.findViewById(R.id.lblDataValuesJCL);
        }
    }
}
