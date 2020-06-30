package com.example.aida.models.journalModels;

import java.util.ArrayList;

public class Journal {
    private ArrayList<JEntry> entries;

    // Default Constructor
    public Journal(){
        entries = new ArrayList<>();
    }

    // Generic Constructor
    public Journal(ArrayList<JEntry> entries){
        this.entries = entries;
    }

    public boolean createEntry(JEntry entry) {
        if(entries.contains(entry)) {
            return false;
        } else {
            entries.add(entry);
        }

        return true;
    }
    public boolean updateEntry(JEntry entry) {
        if(!entries.contains(entry)) {
            return false;
        } else {
            entries.set(entries.indexOf(entry), entry);
        }

        return true;
    }
    public boolean deleteEntry(JEntry entry) {
        if(!entries.contains(entry)) {
            return false;
        } else {
            entries.remove(entry);
        }

        return true;
    }
}
