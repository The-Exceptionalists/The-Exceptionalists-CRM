package com.ironhack.crm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    //Method to validate a regular expression (regex)
    public static boolean validate(String arg, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arg);

        return matcher.matches();
    }

    //Returns true if 'name' starts with a capital letter and can be two or more words separated with spaces
    //and this words must start with a capital letter
    public static boolean validateName(String name) {
        return validate(name, "^[ÁÉÍÓÚA-Z][a-záéíóú]+(\\s+[ÁÉÍÓÚA-Z]?[a-záéíóú]+)*${1,31}");
    }

    //Returns true if 'product' is one of the cases on the Switch
    public static boolean validateProduct(String product) {
        switch (product) {
            case "hybrid", "flatbed", "box" -> {
                return true;
            }
        }
        return false;
    }

    //Returns true if 'name' has a length between 1 and 30
    public static boolean validateCompanyName(String name) {

        return name.length() > 0 && name.length() < 31;
    }

    //Returns true if 'email' is something plus '@' plus something with only letters plus '.' plus
    //something with only letters
    public static boolean validateEmail(String email) {
        return validate(email, "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    }

    //Returns true if 'phoneNumber' has the format of some types of phone numbers
    //(see ValidatorTest to more details)
    public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$";

        return validate(phoneNumber, regex);
    }

    //Returns true if 'command' is a valid command (new, show, lookup, etc.) and has the correct sintaxis
    public static boolean validateCommand(String command) {
        String[] word = command.toLowerCase().split(" ");
        if (word.length > 1) {
            switch (word[0]) {
                case "new" -> {
                    if ("lead".equals(word[1])) {
                        return word.length == 2;
                    }
                }
                case "show" -> {
                    switch (word[1]) {
                        case "leads", "opportunities", "contacts", "accounts" -> {
                            return word.length == 2;
                        }
                    }
                }
                case "lookup" -> {
                    switch (word[1]) {
                        case "opportunity", "contact", "lead", "account" -> {
                            if (word.length == 3) {
                                return validateNumber(word[2]);
                            }
                            return false;
                        }
                    }
                }
                case "convert", "close-won", "close-lost" -> {
                    if (word.length == 2) {
                        return validateNumber(word[1]);
                    }
                    return false;
                }

            }
        } else if (word.length == 1) {
            if (word[0].equals("help")) {
                return true;
            } else if (word[0].equals("exit")) {
                return true;
            }
        }

        return false;
    }

    //Returns true if 'number' is a positive number
    public static boolean validateNumber(String number) {
        if (number.length() < 10) {
            if (validate(number, "[0-9]+") && Integer.parseInt(number) > 0) {
                return true;
            }
        }
        return false;
    }

    //Returns true if 'industry' is one of the cases on the Switch
    public static boolean validateIndustry(String industry) {
        switch (industry) {
            case "produce", "ecommerce", "manufacturing", "medical", "other" -> {
                return true;
            }
        }
        return false;
    }
}
