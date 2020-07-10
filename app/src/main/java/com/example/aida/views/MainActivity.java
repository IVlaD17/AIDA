package com.example.aida.views;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aida.R;
import com.example.aida.models.dateTimeModels.VDate;
import com.example.aida.models.dateTimeModels.VTime;
import com.example.aida.models.foodModels.Food;
import com.example.aida.models.journalModels.Activity;
import com.example.aida.models.journalModels.JEntry;
import com.example.aida.models.journalModels.Medication;
import com.example.aida.models.journalModels.Sleep;
import com.example.aida.models.mealModels.Meal;
import com.example.aida.models.userModels.Country;
import com.example.aida.models.userModels.User;
import com.example.aida.utility.Constants;
import com.example.aida.utility.Methods;
import com.example.aida.viewAdapters.JournalRecyclerViewAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar topAppBar;
    BottomNavigationView botAppBar;

    AppBarConfiguration appBarConfiguration;

    MaterialCardView cClockCardView;
    TimePicker cTimePicker;

    MaterialCardView cCalendarCardView;
    DatePicker cDatePicker;

    TextInputLayout cPickerOpener;

    public static NavController navController;

    public static FirebaseFirestore database;

    public static User loggedUser;
    public static JEntry selectedEntry;

    public static ArrayList<Country> countries;

    public static ArrayList<JEntry> journalEntries;
    public static ArrayList<Food> foodItems;
    public static ArrayList<Meal> mealEntries;

    public static FloatingActionButton cAddJournalItemFAB;
    public static FloatingActionButton cAddMealItemFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loggedUser = (User)getIntent().getSerializableExtra("LoggedUser");
        countries = (ArrayList<Country>)getIntent().getSerializableExtra("Countries");
        foodItems = (ArrayList<Food>)getIntent().getSerializableExtra("FoodItems");

        cClockCardView = findViewById(R.id.cntClockCLL);
        cTimePicker = findViewById(R.id.pckClockCLL);
        cClockCardView.setVisibility(View.GONE);

        cCalendarCardView = findViewById(R.id.cntCalendarCAL);
        cDatePicker = findViewById(R.id.pckCalendarCAL);
        cCalendarCardView.setVisibility(View.GONE);

        // Sets the toolbar as the Top App Bar;
        topAppBar = findViewById(R.id.toolbar_main);
        setSupportActionBar(topAppBar);

        botAppBar = findViewById(R.id.bar_bot_nav_main);

        //navView = findViewById(R.id.nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_main);

        // Creates the App Bar Configuration for the Bottom Nav Bar
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_journal_view, R.id.navigation_account_view,
                R.id.navigation_foods_view, R.id.navigation_meal_calculator).build();

        // Connects the Top App Bar to the Bottom App Bar
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // Connects the Bottom App Bar to the Navigation Host Fragment
        NavigationUI.setupWithNavController(botAppBar, navController);

        journalEntries = new ArrayList<>();
        mealEntries = new ArrayList<>();

        cAddJournalItemFAB = findViewById(R.id.addJournalEntryFabMA);
        cAddMealItemFAB = findViewById(R.id.addMealPlannerEntryFabMA);

        database = FirebaseFirestore.getInstance();
    }

    public static void getJournalEntries(final JournalRecyclerViewAdapter adapter){
        database.collection(Constants.ENTRIES_PATH)
                .whereEqualTo("userID", loggedUser.getId())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            journalEntries.clear();
                            List<DocumentSnapshot> documents = task.getResult().getDocuments();
                            for(DocumentSnapshot document : documents){
                                //JournalEntry newEntry = Methods.convertDBDataToJournalEntry(document);
                                //journalEntries.add(newEntry);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    // Navigation Methods
    public static void navigateToAccountCreateScreen(){
        navController.navigate(R.id.navigation_account_create);
    }
    public static void navigateToAccountEditScreen() {
        navController.navigate(R.id.navigation_account_edit);
    }
    public static void navigateToAccountViewScreen() {
        navController.navigate(R.id.navigation_account_view);
    }
    public static void navigateToFoodsViewScreen() {
        navController.navigate(R.id.navigation_foods_view);
    }
    public static void navigateToEntryAddScreen() {
        navController.navigate(R.id.navigation_journal_add_entry);
    }
    public static void navigateToEntryEditScreen(){
        navController.navigate(R.id.navigation_journal_edit_entry);
    }
    public static void navigateToJournalScreen() {
        navController.navigate(R.id.navigation_journal_view);
    }
    public static void navigateToLoginScreen() {
        navController.navigate(R.id.navigation_login);
    }
    public static void navigateToMealCalculatorScreen() {
        navController.navigate(R.id.navigation_meal_calculator);
    }

    public void closeDateTimePicker(View view){
        if(cCalendarCardView.getVisibility() == View.VISIBLE) {
            VDate cTempDate = new VDate(cDatePicker.getDayOfMonth(), cDatePicker.getMonth(), cDatePicker.getYear());
            cPickerOpener.getEditText().setText(cTempDate.toString());
            cCalendarCardView.setVisibility(View.GONE);
        }

        if(cClockCardView.getVisibility() == View.VISIBLE) {
            VTime cTempTime = new VTime(cTimePicker.getMinute(), cTimePicker.getHour(), 0);
            cPickerOpener.getEditText().setText(cTempTime.toString());
            cClockCardView.setVisibility(View.GONE);
        }

        toggleInputFieldsInteractions(view);
    }
    public void displayDatePicker(View view){
        cCalendarCardView.setVisibility(View.VISIBLE);
        cCalendarCardView.setCardElevation(5.0f);
        toggleInputFieldsInteractions(view);
    }
    public void displayTimePicker(View view){
        cClockCardView.setVisibility(View.VISIBLE);
        cClockCardView.setCardElevation(5.0f);
        toggleInputFieldsInteractions(view);
    }

    public void onAccountCardExpandClick(View view){
        ConstraintLayout cardLayout = (ConstraintLayout) view.getParent();

        MaterialButton expandButton = cardLayout.findViewById(R.id.account_card_expand_button);
        MaterialButton editButton = cardLayout.findViewById(R.id.account_card_button_one);
        MaterialButton removeButton = cardLayout.findViewById(R.id.account_card_button_two);
        TextView cardBodyText = cardLayout.findViewById(R.id.account_card_body);


        if(editButton.getVisibility() == View.GONE && removeButton.getVisibility() == View.GONE && cardBodyText.getMaxLines() == 1){
            editButton.setVisibility(View.VISIBLE);
            removeButton.setVisibility(View.VISIBLE);
            cardBodyText.setMaxLines(20);
            expandButton.setIconResource(R.drawable.ic_expand_less);
        }
        else{
            editButton.setVisibility(View.GONE);
            removeButton.setVisibility(View.GONE);
            cardBodyText.setMaxLines(1);
            expandButton.setIconResource(R.drawable.ic_expand_more);
        }
    }
    public void onAccountEditNavButtonClick(View view) {
        navigateToAccountEditScreen();
    }
    public void onEntryCardExpandClick(View view){
        ConstraintLayout cardLayout = (ConstraintLayout) view.getParent();

        MaterialButton expandButton = cardLayout.findViewById(R.id.entry_card_expand_button);
        MaterialButton removeButton = cardLayout.findViewById(R.id.entry_card_button_two);
        TextView cardBodyTextLeft = cardLayout.findViewById(R.id.entry_card_body_left);
        TextView cardBodyTextRight = cardLayout.findViewById(R.id.entry_card_body_right);

        if(removeButton.getVisibility() == View.GONE && cardBodyTextLeft.getMaxLines() == 1 && cardBodyTextRight.getMaxLines() == 1){
            removeButton.setVisibility(View.VISIBLE);
            cardBodyTextLeft.setMaxLines(4);
            cardBodyTextRight.setMaxLines(4);
            expandButton.setIconResource(R.drawable.ic_expand_less);
        }
        else{
            removeButton.setVisibility(View.GONE);
            cardBodyTextLeft.setMaxLines(1);
            cardBodyTextRight.setMaxLines(1);
            expandButton.setIconResource(R.drawable.ic_expand_more);
        }
    }
    public void onFoodCardExpandClick(View view){
        ConstraintLayout cardLayout = (ConstraintLayout) view.getParent();

        MaterialButton expandButton = cardLayout.findViewById(R.id.food_card_expand_button);
        MaterialButton addButton = cardLayout.findViewById(R.id.food_card_button_one);
        TextView cardBodyTextLeft = cardLayout.findViewById(R.id.food_card_body_left);
        TextView cardBodyTextRight = cardLayout.findViewById(R.id.food_card_body_right);


        if(addButton.getVisibility() == View.GONE && cardBodyTextLeft.getMaxLines() == 1 && cardBodyTextRight.getMaxLines() == 1){
            addButton.setVisibility(View.VISIBLE);
            cardBodyTextLeft.setMaxLines(4);
            cardBodyTextRight.setMaxLines(4);
            expandButton.setIconResource(R.drawable.ic_expand_less);
        }
        else{
            addButton.setVisibility(View.GONE);
            cardBodyTextLeft.setMaxLines(1);
            cardBodyTextRight.setMaxLines(1);
            expandButton.setIconResource(R.drawable.ic_expand_more);
        }
    }
    public void onJournalEntryAddButtonClick(View view){
        journalEntryAdd();
    }
    public void onJournalEntryEditButtonClick(View view){
        journalEntryEdit();
    }
    public void onJournalEntryRemoveButtonClick(View view){
        journalEntryDelete(view);
    }
    public void onJournalFABClick(View view){
        navController.navigate(R.id.navigation_journal_add_entry);
    }
    public void onMealEntryRemoveButtonClick(View view) { mealEntryDelete(view); }
    public void onMealEntrySaveButtonClick(View view) { mealEntrySave(view); }
    public void onMealPlannerFABClick(View view){
        mealEntryAdd();
    }
    public void onPhysActDropdownClicked(View view){
        Toast.makeText(this, "OnPhysActDropdownClicked", Toast.LENGTH_LONG).show();
    }
    public void onPhysActTimeStartClick(View view){
        TextInputLayout cClickedLayout = findViewById(R.id.physActSTTextInputEAF);

        if(cClickedLayout == null)
            cClickedLayout = findViewById(R.id.physActSTTextInputEEF);

        cPickerOpener = cClickedLayout;
        displayTimePicker(view);
    }
    public void onPhysActTimeEndClick(View view){
        TextInputLayout cClickedLayout = findViewById(R.id.physActETTextInputEAF);

        if(cClickedLayout == null)
            cClickedLayout = findViewById(R.id.physActETTextInputEEF);

        cPickerOpener = cClickedLayout;
        displayTimePicker(view);
    }
    public void onPickerCardCloseButtonClick(View view){
        closeDateTimePicker(view);
    }
    public void onRecordingDateClick(View view){
        TextInputLayout cClickedLayout = findViewById(R.id.recordDateTextInputEAF);

        if(cClickedLayout == null)
            cClickedLayout = findViewById(R.id.recordDateTextInputEEF);

        cPickerOpener = cClickedLayout;
        displayDatePicker(view);
    }
    public void onRecordingTimeClick(View view){
        TextInputLayout cClickedLayout = findViewById(R.id.recordTimeTextInputEAF);

        if(cClickedLayout == null)
            cClickedLayout = findViewById(R.id.recordTimeTextInputEEF);

        cPickerOpener = cClickedLayout;
        displayTimePicker(view);
    }
    public void onSleepSwitchChanged(View view){
        SwitchMaterial sleepSwitch = findViewById(R.id.sleepSwitchEAF);
        TextInputLayout startTimeInputLayout;
        TextInputLayout endTimeInputLayout;

        if(sleepSwitch != null){
            startTimeInputLayout = findViewById(R.id.sleepSTTextInputEAF);
            endTimeInputLayout = findViewById(R.id.sleepETTextInputEAF);

            if(startTimeInputLayout.getVisibility() == View.GONE && endTimeInputLayout.getVisibility() == View.GONE){
                startTimeInputLayout.setVisibility(View.VISIBLE);
                endTimeInputLayout.setVisibility(View.VISIBLE);
            }
            else{
                startTimeInputLayout.setVisibility(View.GONE);
                endTimeInputLayout.setVisibility(View.GONE);
            }
        }
        else {
            startTimeInputLayout = findViewById(R.id.sleepSTTextInputEEF);
            endTimeInputLayout = findViewById(R.id.sleepETTextInputEEF);

            if(startTimeInputLayout.getVisibility() == View.GONE && endTimeInputLayout.getVisibility() == View.GONE){
                startTimeInputLayout.setVisibility(View.VISIBLE);
                endTimeInputLayout.setVisibility(View.VISIBLE);
            }
            else{
                startTimeInputLayout.setVisibility(View.GONE);
                endTimeInputLayout.setVisibility(View.GONE);
            }
        }
    }
    public void onSleepTimeStartClick(View view){
        TextInputLayout cClickedLayout = findViewById(R.id.sleepSTTextInputEAF);

        if(cClickedLayout == null)
            cClickedLayout = findViewById(R.id.sleepSTTextInputEEF);

        cPickerOpener = cClickedLayout;
        displayTimePicker(view);
    }
    public void onSleepTimeEndClick(View view){
        TextInputLayout cClickedLayout = findViewById(R.id.sleepETTextInputEAF);

        if(cClickedLayout == null)
            cClickedLayout = findViewById(R.id.sleepETTextInputEEF);

        cPickerOpener = cClickedLayout;
        displayTimePicker(view);
    }

    void journalEntryAdd(){
        VDate date;
        VTime time = null;
        VTime sleepStart = null;
        VTime sleepEnd = null;
        VTime activityStart = null;
        VTime activityEnd = null;

        SwitchMaterial sleepSwitch;
        TextInputLayout dateInputField;
        TextInputLayout timeInputField;
        TextInputLayout glucoseInputField;
        TextInputLayout carbsInputField;
        TextInputLayout primaryMedNameInputField;
        TextInputLayout primaryMedQtyInputField;
        TextInputLayout secondaryMedNameInputField;
        TextInputLayout secondaryMedQtyInputField;
        TextInputLayout sleepStartInputField;
        TextInputLayout sleepEndInputField;
        TextInputLayout activityTypeInputField;
        TextInputLayout activityStartInputField;
        TextInputLayout activityEndInputField;

        sleepSwitch = findViewById(R.id.sleepSwitchEAF);
        Boolean hasSlept = sleepSwitch.isChecked();

        dateInputField = findViewById(R.id.recordDateTextInputEAF);
        if(Methods.isNullOrWhiteSpace(dateInputField.getEditText().getText().toString()))
            date = Constants.ZERO_DATE;
        else
            date = new VDate(dateInputField.getEditText().getText().toString());

        timeInputField = findViewById(R.id.recordTimeTextInputEAF);
        if(Methods.isNullOrWhiteSpace(timeInputField.getEditText().getText().toString()))
            time = Constants.ZERO_TIME;
        else
            time = new VTime(timeInputField.getEditText().getText().toString());

        glucoseInputField = findViewById(R.id.glucLvlTextInputEAF);
        String glucoseLevelStr = glucoseInputField.getEditText().getText().toString();

        carbsInputField = findViewById(R.id.carbTextInputEAF);
        String carbsAmountStr = carbsInputField.getEditText().getText().toString();

        primaryMedNameInputField = findViewById(R.id.medPrimaryExposedDropdownMenuEAF);
        String primaryMedName = primaryMedNameInputField.getEditText().getText().toString();

        primaryMedQtyInputField = findViewById(R.id.medPrimaryTextInputEAF);
        String primaryMedQtyStr = primaryMedQtyInputField.getEditText().getText().toString();

        secondaryMedNameInputField = findViewById(R.id.medSecondaryExposedDropdownMenuEAF);
        String secondaryMedName = secondaryMedNameInputField.getEditText().getText().toString();

        secondaryMedQtyInputField = findViewById(R.id.medSecondaryTextInputEAF);
        String secondaryMedQtyStr = secondaryMedQtyInputField.getEditText().getText().toString();

        sleepStartInputField = findViewById(R.id.sleepSTTextInputEAF);
        if(Methods.isNullOrWhiteSpace(sleepStartInputField.getEditText().getText().toString()))
            sleepStart = Constants.ZERO_TIME;
        else
            sleepStart = new VTime(sleepStartInputField.getEditText().getText().toString());

        sleepEndInputField = findViewById(R.id.sleepETTextInputEAF);
        if(Methods.isNullOrWhiteSpace(sleepEndInputField.getEditText().getText().toString()))
            sleepEnd = Constants.ZERO_TIME;
        else
            sleepEnd = new VTime(sleepEndInputField.getEditText().getText().toString());

        activityTypeInputField = findViewById(R.id.physActExposedDropdownMenuEAF);
        String activityType = activityTypeInputField.getEditText().getText().toString();

        activityStartInputField = findViewById(R.id.physActSTTextInputEAF);
        if(Methods.isNullOrWhiteSpace(activityStartInputField.getEditText().getText().toString()))
            activityStart = Constants.ZERO_TIME;
        else
            activityStart = new VTime(activityStartInputField.getEditText().getText().toString());

        activityEndInputField = findViewById(R.id.physActETTextInputEAF);
        if(Methods.isNullOrWhiteSpace(activityEndInputField.getEditText().getText().toString()))
            activityEnd = Constants.ZERO_TIME;
        else
            activityEnd = new VTime(activityEndInputField.getEditText().getText().toString());

        if(!Methods.isNullOrWhiteSpace(glucoseLevelStr) && !Methods.isNullOrWhiteSpace(carbsAmountStr) && !Methods.isNullOrWhiteSpace(primaryMedName)
                && !Methods.isNullOrWhiteSpace(primaryMedQtyStr) && !Methods.isNullOrWhiteSpace(secondaryMedName)
                && !Methods.isNullOrWhiteSpace(secondaryMedQtyStr) && !Methods.isNullOrWhiteSpace(activityType)) {
            int glucoseLevel = Integer.valueOf(glucoseLevelStr);
            int carbsAmount = Integer.valueOf(carbsAmountStr);
            float primaryMedQty = Float.valueOf(primaryMedQtyStr);
            float secondaryMedQty = Float.valueOf(secondaryMedQtyStr);

            Medication primaryMedication = new Medication(primaryMedName, primaryMedQty);
            Medication secondaryMedication = new Medication(secondaryMedName, secondaryMedQty);
            Sleep sleep = new Sleep(hasSlept, sleepStart, sleepEnd);
            Activity physicalActivity = new Activity(activityType, activityStart, activityEnd);

            JEntry entry = new JEntry("", loggedUser.getId(), date, time, glucoseLevel, carbsAmount,
                    primaryMedication, secondaryMedication, sleep, physicalActivity);

            database.collection(Constants.ENTRIES_PATH).document().set(entry.toDBOject());
            navController.navigate(R.id.navigation_journal_view);
        }
        else{
            Toast.makeText(getApplicationContext(), Constants.ERR_EMPTY_FIELD, Toast.LENGTH_LONG).show();
        }
    }
    void journalEntryDelete(View view){
        MaterialCardView cardLayout = (MaterialCardView) view.getParent().getParent();
        RecyclerView journalView = findViewById(R.id.recyclerViewJVF);
        int entryPosition = journalView.getChildAdapterPosition(cardLayout);

        JEntry entry = journalEntries.get(entryPosition);
        database.collection(Constants.ENTRIES_PATH).document(entry.getId()).delete();
        journalEntries.remove(entryPosition);
        JournalViewFragment.getMealRecyclerViewAdapter().notifyDataSetChanged();
    }
    void journalEntryEdit(){
        SwitchMaterial sleepSwitch;
        TextInputLayout dateInputField;
        TextInputLayout timeInputField;
        TextInputLayout glucoseInputField;
        TextInputLayout carbsInputField;
        TextInputLayout primaryMedNameInputField;
        TextInputLayout primaryMedQtyInputField;
        TextInputLayout secondaryMedNameInputField;
        TextInputLayout secondaryMedQtyInputField;
        TextInputLayout sleepStartInputField;
        TextInputLayout sleepEndInputField;
        TextInputLayout activityTypeInputField;
        TextInputLayout activityStartInputField;
        TextInputLayout activityEndInputField;

        sleepSwitch = findViewById(R.id.sleepSwitchEEF);
        Boolean hasSlept = sleepSwitch.isChecked();

        dateInputField = findViewById(R.id.recordDateTextInputEEF);
        VDate date = new VDate(dateInputField.getEditText().getText().toString());

        timeInputField = findViewById(R.id.recordTimeTextInputEEF);
        VTime time = new VTime(timeInputField.getEditText().getText().toString());

        glucoseInputField = findViewById(R.id.glucLvlTextInputEEF);
        String glucoseLevelStr = glucoseInputField.getEditText().getText().toString();

        carbsInputField = findViewById(R.id.carbTextInputEEF);
        String carbsAmountStr = carbsInputField.getEditText().getText().toString();

        primaryMedNameInputField = findViewById(R.id.medPrimaryExposedDropdownMenuEEF);
        String primaryMedName = primaryMedNameInputField.getEditText().getText().toString();

        primaryMedQtyInputField = findViewById(R.id.medPrimaryTextInputEEF);
        String primaryMedQtyStr = primaryMedQtyInputField.getEditText().getText().toString();

        secondaryMedNameInputField = findViewById(R.id.medSecondaryExposedDropdownMenuEEF);
        String secondaryMedName = secondaryMedNameInputField.getEditText().getText().toString();

        secondaryMedQtyInputField = findViewById(R.id.medSecondaryTextInputEEF);
        String secondaryMedQtyStr = secondaryMedQtyInputField.getEditText().getText().toString();

        sleepStartInputField = findViewById(R.id.sleepSTTextInputEEF);
        VTime sleepStart = new VTime(sleepStartInputField.getEditText().getText().toString());

        sleepEndInputField = findViewById(R.id.sleepETTextInputEEF);
        VTime sleepEnd = new VTime(sleepEndInputField.getEditText().getText().toString());

        activityTypeInputField = findViewById(R.id.physActExposedDropdownMenuEEF);
        String activityType = activityTypeInputField.getEditText().getText().toString();

        activityStartInputField = findViewById(R.id.physActSTTextInputEEF);
        VTime activityStart = new VTime(activityStartInputField.getEditText().getText().toString());

        activityEndInputField = findViewById(R.id.physActETTextInputEEF);
        VTime activityEnd = new VTime(activityEndInputField.getEditText().getText().toString());

        if(!Methods.isNullOrWhiteSpace(glucoseLevelStr) && !Methods.isNullOrWhiteSpace(carbsAmountStr) && !Methods.isNullOrWhiteSpace(primaryMedName)
                && !Methods.isNullOrWhiteSpace(primaryMedQtyStr) && !Methods.isNullOrWhiteSpace(secondaryMedName) && !Methods.isNullOrWhiteSpace(secondaryMedQtyStr)
                && !Methods.isNullOrWhiteSpace(activityType)) {
            int glucoseLevel = Integer.valueOf(glucoseLevelStr);
            int carbsAmount = Integer.valueOf(carbsAmountStr);
            float primaryMedQty = Float.valueOf(primaryMedQtyStr);
            float secondaryMedQty = Float.valueOf(secondaryMedQtyStr);

            Medication primaryMedication = new Medication(primaryMedName, primaryMedQty);
            Medication secondaryMedication = new Medication(secondaryMedName, secondaryMedQty);
            Sleep sleep = new Sleep(hasSlept, sleepStart, sleepEnd);
            Activity physicalActivity = new Activity(activityType, activityStart, activityEnd);

            JEntry entry = new JEntry(selectedEntry.getId(), selectedEntry.getUserID(), date, time, glucoseLevel, carbsAmount,
                    primaryMedication, secondaryMedication, sleep, physicalActivity);
            database.collection(Constants.ENTRIES_PATH).document(selectedEntry.getId()).update(entry.toDBOject());
            navController.navigate(R.id.navigation_journal_view);
        }
        else{
            Toast.makeText(getApplicationContext(), Constants.ERR_EMPTY_FIELD, Toast.LENGTH_LONG).show();
        }
    }
    void mealEntryAdd(){
        Meal newMealEntry = new Meal();

        mealEntries.add(newMealEntry);
        MealCalculatorFragment.getMealRecyclerViewAdapter().notifyDataSetChanged();
    }
    void mealEntryDelete(View view){
        MaterialCardView cardLayout = (MaterialCardView) view.getParent().getParent();
        RecyclerView calculatorView = findViewById(R.id.recyclerViewMCF);
        int entryPosition = calculatorView.getChildAdapterPosition(cardLayout);

        mealEntries.remove(entryPosition);
        MealCalculatorFragment.getMealRecyclerViewAdapter().notifyDataSetChanged();

        updateTotalCarbsLabel();
    }
    void mealEntrySave(View view){
        MaterialCardView cardLayout = (MaterialCardView) view.getParent().getParent();
        RecyclerView calculatorView = findViewById(R.id.recyclerViewMCF);
        int entryPosition = calculatorView.getChildAdapterPosition(cardLayout);

        TextView cardTitle = findViewById(R.id.meal_card_title);
        TextInputLayout qtyInput = findViewById(R.id.meal_qtyTextInput);

        String foodName = cardTitle.getText().toString();
        String foodQty = qtyInput.getEditText().getText().toString();

        if(!Methods.isNullOrWhiteSpace(foodName) && !Methods.isNullOrWhiteSpace(foodQty)) {
            Food foodItem = Methods.findFoodItemByName(foodName, foodItems);
            int quantity = Integer.valueOf(foodQty);

            mealEntries.get(entryPosition).setItem(foodItem);
            mealEntries.get(entryPosition).setQuantity(quantity);

            updateTotalCarbsLabel();
        }
        else{
            Toast.makeText(getApplicationContext(), Constants.ERR_EMPTY_FIELD, Toast.LENGTH_LONG).show();
        }
    }

    void toggleInputFieldsInteractions(View view){
        ConstraintLayout cPickerOpenerParent = (ConstraintLayout) cPickerOpener.getParent();

        View[] cInputViews = new View[cPickerOpenerParent.getChildCount() - 1];
        for (int iTextInputIndex = 0; iTextInputIndex < cInputViews.length; iTextInputIndex++)
            cInputViews[iTextInputIndex] = cPickerOpenerParent.getChildAt(iTextInputIndex);

        for (View cInputView : cInputViews)
            if (cInputView != cPickerOpener)
                cInputView.setEnabled(!cInputView.isEnabled());
    }
    void updateTotalCarbsLabel(){
        int totalCarbs = 0;

        TextInputLayout totalCarbsTextInput = findViewById(R.id.totalCarbsLabelMCF);

        for(Meal entry : mealEntries){
            if(entry.getItem() != null)
                totalCarbs += (entry.getItem().getCarbohydrates() / 100) * entry.getQuantity();
        }

        totalCarbsTextInput.getEditText().setText(String.valueOf(totalCarbs));
    }
}
