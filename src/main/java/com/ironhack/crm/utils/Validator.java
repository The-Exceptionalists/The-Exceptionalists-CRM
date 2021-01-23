package com.ironhack.crm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validate(String arg, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arg);

        return matcher.matches();
    }

    public static boolean validateName(String name) {
        return validate(name, "^[ÁÉÍÓÚA-Z][a-záéíóú]+(\\s+[ÁÉÍÓÚA-Z]?[a-záéíóú]+)*${1,31}");
    }
    public static boolean validateCompanyName(String name) {

        boolean correctName = false;

        if(name.length() > 0 && name.length() < 31) {
            correctName = true;
        }else {
            correctName = false;
        }

       return correctName;
    }

    public static boolean validateEmail(String email) {
        return validate(email, "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    }
    public static boolean validatePhoneNumber(String phoneNumber) {
        return validate(phoneNumber, "^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$");
    }
}
