package com.example.aida.utility;

public class Constants {
    public static MTime ZERO_TIME = new MTime(0, 0, 0);
    public static MDate ZERO_DATE = new MDate(0, 0, 0);
    public static MDateTime ZERO_DATE_TIME = new MDateTime(ZERO_DATE, ZERO_TIME);
    public static String[] DIABETES_TYPES = new String[] {"Type 1 DM", "Type 2 DM"};
    public static String[] T1_MEDS = new String[] { "None", "T1M1", "T1M2", "T1M3", "T1M4", "T1M5", "T1M6", "T1M7", "T1M8", "T1M9", "T1M10"};
    public static String[] T2_MEDS = new String[] { "None", "T2M1", "T2M2", "T2M3", "T2M4", "T2M5", "T2M6", "T2M7", "T2M8", "T2M9", "T2M10"};
    public static String[] ACTIVITIES = new String[] { "None", "Football", "Basketball", "Tennis"};

    public static String ERR_ACC_EXISTS = "There already is an account registered to that email address!";
    public static String ERR_DOCUMENT_FOUND = "No document found: ";
    public static String ERR_DOCUMENT_GET = "Error getting documents: ";
    public static String ERR_EMAIL_WRONG = "No account with that email was found!";
    public static String ERR_EMPTY_FIELD = "You did not fill in all fields!";
    public static String ERR_FOOD_EMPTY = "You must select a food item first!";
    public static String ERR_PASS_WRONG = "The password you entered was incorrect!";
    public static String ERR_PASS_NO_MATCH = "The passwords don't match!";

    public static String MSG_ACC_CREATE_SUCCESS = "Your account was created successfully!";

    public static String LOGIN_SUCCESS = "You logged in successfully!";

    public static String USERS_PATH = "users";
    public static String CITIES_PATH = "cities";
    public static String COUNTRIES_PATH = "countries";
    public static String ENTRIES_PATH = "entries";
    public static String FOODS_PATH = "foods";
}
