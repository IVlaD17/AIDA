package com.example.aida.dal;

import androidx.annotation.NonNull;

import com.example.aida.models.journalModels.Activity;
import com.example.aida.models.JournalEntry;
import com.example.aida.models.journalModels.Medication;
import com.example.aida.models.journalModels.Sleep;
import com.example.aida.models.User;
import com.example.aida.models.dateTimeModels.VDate;
import com.example.aida.models.dateTimeModels.VTime;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class JournalManager extends RestService {
    //TODO: Add ViewModel Constructor

    // Used for Generating a JEntry Object from a Database Document
    private JournalEntry genJEntry(DocumentSnapshot document){
        String id = document.getId();

        VDate date = new VDate(document.getData().get("date").toString());
        VTime time = new VTime(document.getData().get("time").toString());

        int glycaemia = Integer.valueOf(document.getData().get("glucose").toString());
        int carbs = Integer.valueOf(document.getData().get("carbohydrates").toString());

        Boolean hasSlept = Boolean.valueOf(document.getData().get("hasSlept").toString());
        VTime sleepStart = new VTime(document.getData().get("sleepEnd").toString());
        VTime sleepEnd = new VTime(document.getData().get("sleepStart").toString());
        Sleep sleep = new Sleep(hasSlept, sleepStart, sleepEnd);

        String activityType = document.getData().get("physicalActivityType").toString();
        VTime activityStart = new VTime(document.getData().get("physicalActivityStart").toString());
        VTime activityEnd = new VTime(document.getData().get("physicalActivityEnd").toString());
        Activity physicalActivity = new Activity(activityType, activityStart, activityEnd);

        String primaryMedicationName = document.getData().get("primaryMedicationName").toString();
        float primaryMedicationQuantity = Float.valueOf(document.getData().get("primaryMedicationQuantity").toString());
        Medication primaryMedication = new Medication(primaryMedicationName, primaryMedicationQuantity);

        String secondaryMedicationName = document.getData().get("secondaryMedicationName").toString();
        float secondaryMedicationQuantity = Float.valueOf(document.getData().get("secondaryMedicationQuantity").toString());
        Medication secondaryMedication = new Medication(secondaryMedicationName, secondaryMedicationQuantity);

        return new JournalEntry(id, date, time, glycaemia, carbs, primaryMedication, secondaryMedication, sleep, physicalActivity);
    }

    // Used for Getting Journal Entries Recorded by the User from the Database
    public void read(User user){
        database.collection(entriesPath).whereEqualTo("userID", user.getId()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    ArrayList<JournalEntry> entries = new ArrayList<>();
                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    for(DocumentSnapshot document : documents){
                        JournalEntry newEntry = genJEntry(document);
                        entries.add(newEntry);
                    }

                    //TODO: Add Callback Method
                }
            }
        });
    }

    // Used for Adding a new Journal Entry in the Database
    public void create(JournalEntry entry){
        database.collection(entriesPath).document().set(entry.getDBFormat());
    }

    // Used for Editing a Journal Entry in the Database
    public void update(JournalEntry entry){
        database.collection(entriesPath).document(entry.getId()).update(entry.getDBFormat());
    }

    // Used for Deleting a Journal Entry from the Database
    public void delete(JournalEntry entry){
        database.collection(entriesPath).document(entry.getId()).delete();
    }
}
