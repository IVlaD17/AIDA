package com.example.aida.dal;

import com.example.aida.models.JournalEntry;
import com.example.aida.models.User;

import java.util.ArrayList;

public class JournalManager {
    // Used for Getting Journal Entries Recorded by the User from the Database
    public ArrayList<JournalEntry> read(User user){
        return null;
    }

    // Used for Adding a new Journal Entry in the Database
    public boolean create(JournalEntry entry){
        return false;
    }

    // Used for Editing a Journal Entry in the Database
    public boolean update(JournalEntry entry){
        return false;
    }

    // Used for Deleting a Journal Entry from the Database
    public boolean delete(JournalEntry entry){
        return false;
    }
}
