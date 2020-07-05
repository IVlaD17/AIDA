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
        for(int eI = 0; eI < entries.size(); eI++) {
            if(entry.getId().equals(entries.get(eI).getId())) {
                return false;
            }
        }

        entries.add(entry);
        return true;
    }
    public boolean updateEntry(JEntry entry) {
        for(int eI = 0; eI < entries.size(); eI++) {
            if(entry.getId().equals(entries.get(eI).getId())) {
                entries.set(eI, entry);
                return true;
            }
        }

        return false;
    }
    public boolean deleteEntry(JEntry entry) {
        for(int eI = 0; eI < entries.size(); eI++) {
            if(entry.getId().equals(entries.get(eI).getId())) {
                entries.remove(entry);
                return true;
            }
        }

        return false;
    }
}
