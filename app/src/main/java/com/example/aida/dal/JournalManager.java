package com.example.aida.dal;

import androidx.annotation.NonNull;

import com.example.aida.models.dateTimeModels.VDate;
import com.example.aida.models.dateTimeModels.VTime;
import com.example.aida.models.journalModels.Activity;
import com.example.aida.models.journalModels.JEntry;
import com.example.aida.models.journalModels.Medication;
import com.example.aida.models.journalModels.Sleep;
import com.example.aida.models.userModels.User;
import com.example.aida.viewModels.ViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class JournalManager extends RestService {
    private ArrayList<JEntry> entries;

    public JournalManager(ViewModel viewModel, ArrayList<JEntry> entries) {
        super(viewModel);

        if(entries == null) {
            this.entries = new ArrayList<>();
        } else {
            this.entries = entries;
        }
    }

    public ArrayList<JEntry> getEntries() {
        return entries;
    }

    // Used for Getting Journal Entries Recorded by the User from the Database
    public void read(final User user){
        database.collection(entriesPath).whereEqualTo("userID", user.getId()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    ArrayList<JEntry> entries = new ArrayList<>();
                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    for(DocumentSnapshot document : documents){
                        JEntry newEntry = genJEntry(document, user.getId());
                        entries.add(newEntry);
                    }

                    //TODO: Add Callback Method
                }
            }
        });
    }

    // Used for Adding a new Journal Entry in the Database
    public void create(JEntry entry){
        database.collection(entriesPath).document().set(entry.toDBOject());
    }

    // Used for Editing a Journal Entry in the Database
    public void update(JEntry entry){
        database.collection(entriesPath).document(entry.getId()).update(entry.toDBOject());
    }

    // Used for Deleting a Journal Entry from the Database
    public void delete(JEntry entry){
        database.collection(entriesPath).document(entry.getId()).delete();
    }

    // Used for Generating a JEntry Object from a Database Document
    private JEntry genJEntry(DocumentSnapshot document, String userID){
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

        return new JEntry(id, userID, date, time, glycaemia, carbs, primaryMedication, secondaryMedication, sleep, physicalActivity);
    }
}
