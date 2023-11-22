package com.qa.tutorialsninja.Utilties;

import java.util.Date;

public class Util {
    public static String generateEmailWithDateTimeStamp() {
        Date date = new Date();
        String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
        return "selenium" + timeStamp + "@gmail.com";
    }

    public static final int IMPLICIT_WAIT = 20;
    public static final int PAGE_LOAD_TIME = 100;
    public static final int SCRIPT_TIMEOUT = 1000;

}
