package com.ironhack.crm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validateName(String name) {
        return validate(name, "^[ÁÉÍÓÚA-Z][a-záéíóú]+(\\s+[ÁÉÍÓÚA-Z]?[a-záéíóú]+)*${1,31}");
    }

    public static boolean validateCompanyName(String name) {

        return name.length() > 0 && name.length() < 31;
    }

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean validateCommand(String command) {
        //validates if all the words in the command are correct
        return true;
    }
}
