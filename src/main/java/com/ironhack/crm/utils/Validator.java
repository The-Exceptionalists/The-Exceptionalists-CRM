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

    public static boolean validateProduct(String product) {
        switch (product) {
            case "hybrid", "flatbed", "box" -> {
                return true;
            }
        }
        return false;
    }

    public static boolean validateCompanyName(String name) {

        return name.length() > 0 && name.length() < 31;
    }

    public static boolean validateEmail(String email) {
        return validate(email, "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$";

        /*String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        validPhoneNumbers= {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
                "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};*/
        return validate(phoneNumber, regex);
    }

    public static boolean validateCommand(String command) {
        //validates if all the words in the command are correct
        return true;
    }

    public static boolean validateNumber(String number) {
        if (validate(number, "[0-9]+") && Integer.parseInt(number) > 0) {
            return true;
        }
        return false;
    }
}
