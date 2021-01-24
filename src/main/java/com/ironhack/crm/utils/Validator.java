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
        return validate(name, "^[ÁÉÍÓÚA-Z]?[a-záéíóú]+(\\s+[ÁÉÍÓÚA-Z]?[a-záéíóú]+)*${1,31}");
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

        return validate(phoneNumber, regex);
    }

    public static boolean validateCommand(String command) {
        String[] word = command.split(" ");
        if (word.length > 1) {
            switch (word[0]) {
                case "new" -> {
                    //Convert switch to if when no more functionalities are added
                    switch (word[1]) {
                        case "lead" -> {
                            return word.length == 2;
                        }
                    }
                }
                case "show" -> {
                    //Convert switch to if when no more functionalities are added
                    switch (word[1]) {
                        case "leads" -> {
                            return word.length == 2;
                        }
                    }
                }
                case "lookup" -> {
                    //Convert switch to if when no more functionalities are added
                    switch (word[1]) {
                        case "opportunity" -> {
                            return true;
                        }
                    }
                }
                case "convert", "close-won", "close-lost" -> {
                    return validateNumber(word[1]);
                }

            }
        } else if (word.length == 1) {
            if(word[0].equals("help")) {
                return true;
            }else if(word[0].equals("exit")) {
                return true;
            }
        }

        return false;
    }

    public static boolean validateNumber(String number) {
        if(number.length() < 10) {
            if (validate(number, "[0-9]+") && Integer.parseInt(number) > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateIndustry(String industry) {
        switch (industry) {
            case "produce", "ecommerce", "manufacturing", "medical", "other" -> {
                return true;
            }
        }
        return false;
    }
}
