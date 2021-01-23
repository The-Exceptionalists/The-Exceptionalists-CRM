package com.ironhack.crm.main.helpers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHelpers {

    //Scanner Input validates

    //We use this function to validate a correct int
    //here if we need a message
    public static int validateIntMenu(String sout, String arg) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println(sout);
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        selection = Integer.parseInt(input);
        return selection;
    }
    //here if we doesn't
    public static int validateIntMenu(String arg) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        selection = Integer.parseInt(input);
        return selection;
    }


    //We use this function to validate a correct String
    //here if we need a message
    public static String validateStringMenu(String sout, String arg) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println(sout);
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        return input;
    }
    //here if we doesn't
    public static String validateStringMenu(String arg) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        return input;
    }

    //direct arg to functions validations

    public static int validateInt(String arg, String regex) {

        int selection;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arg);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("insert a correct number");
        }
        selection = Integer.parseInt(arg);
        return selection;
    }

    public static Boolean validateString(String arg, String regex) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arg);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("insert a correct input");
        }

        return matcher.matches();
    }
}
