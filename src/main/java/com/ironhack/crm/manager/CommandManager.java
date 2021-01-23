package com.ironhack.crm.manager;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Lead;
import com.ironhack.crm.classes.Opportunity;
import com.ironhack.crm.enums.Industry;
import com.ironhack.crm.enums.Product;
import com.ironhack.crm.enums.Status;
import com.ironhack.crm.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    private static List<String> commandList;


    public List<String> getCommandList() {
        return commandList;
    }

    public static void introduceCommand() {
        printCommandList();
        System.out.println("Introduce a command from the list:");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        if (!Validator.validateCommand(command)) throw new IllegalArgumentException();
        processCommand(command);
    }

    public static void processCommand(String command) {
        String[] words = command.toLowerCase().split(" ");
        switch (words[0]) {
            case "new" -> createObject(words[1]);
            case "show" -> showList(words[1]);
            case "convert" -> convertLeadToOpportunity(Integer.parseInt(words[1]));
            case "lookup" -> showObject(words[1], Integer.parseInt(words[2]));
            case "close-won" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_WON);
            case "close-lost" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_LOST);
            case "exit" -> System.exit(0);
        }
    }

    private static void closeOpportunity(int id, Status closedLost) {
        //Storage method to get the Opportunity by id and change status
    }

    private static void convertLeadToOpportunity(int id) {
        //Storage method to get Lead by id
        //Lead lead = Storage.getLeadById();
        //Contact contact = leadToContact(lead);
        //Opportunity opportunity = promptOpportunity();
        //Account account = promptAccount(contact.companyName, contact, opportunity);
        //Storage method to add new Contact
        //Storage method to add new Opportunity
        //Storage method to add new Account
        //Storage method to convert Lead to Null
    }

    private static void createObject(String word) {
        switch (word) {
            case "lead" -> {
                Lead lead = promptLead();
                //Storage method for inserting new lead in Storage
            }
        }
    }

    private static Contact leadToContact(Lead lead) {
        String name = lead.getName();
        String email = lead.getEmail();
        String companyName = lead.getCompanyName();
        String phoneNumber = lead.getPhoneNumber();
        return new Contact(name, email, companyName, phoneNumber);
    }

    private static Account promptAccount(String companyName, Contact contact, Opportunity opportunity) {
        //Output for prompt Account
        Scanner sc = new Scanner(System.in);
        System.out.println("Industry (Produce, Ecommerce, Manufacturing, Medical, Other): ");
        String industry = sc.nextLine().toLowerCase();
        while (!Validator.validateIndustry(industry)) {
            System.out.println("Enter a correct industry (Produce, Ecommerce, Manufacturing, Medical, Other): ");
            industry = sc.nextLine().toLowerCase();
        }
        Industry industryEnum = findIndustryEnum(industry);
        System.out.println("Employee count: ");
        String employeeCount = sc.nextLine();
        while (!Validator.validateNumber(employeeCount)) {
            System.out.println("Enter a correct number of employees: ");
            employeeCount = sc.nextLine();
        }
        System.out.println("City: ");
        String city = sc.nextLine();
        while (!Validator.validateName(city)) {
            System.out.println("Enter a correct value: ");
            city = sc.nextLine();
        }
        System.out.println("City: ");
        String country = sc.nextLine();
        while (!Validator.validateName(country)) {
            System.out.println("Enter a correct value: ");
            country = sc.nextLine();
        }
        return new Account(companyName, industryEnum, Integer.parseInt(employeeCount), city, country, contact, opportunity);
    }

    private static Industry findIndustryEnum(String industry) {
        switch (industry) {
            case "produce" -> {
                return Industry.PRODUCE;
            }
            case "ecommerce" -> {
                return Industry.ECOMMERCE;
            }
            case "manufacturing" -> {
                return Industry.MANUFACTURING;
            }
            case "medical" -> {
                return Industry.MEDICAL;
            }
            case "other" -> {
                return Industry.OTHER;
            }
        }
        return null;
    }

    private static Opportunity promptOpportunity(Contact contact) {
        //Output for prompt Opportunity
        Scanner sc = new Scanner(System.in);
        System.out.println("Type of truck (Hybrid, Flatbed or Box): ");
        String product = sc.nextLine().toLowerCase();
        while (!Validator.validateProduct(product)) {
            System.out.println("Enter a correct product(Hybrid, Flatbed or Box): ");
            product = sc.nextLine().toLowerCase();
        }
        Product productEnum = findProductEnum(product);
        System.out.println("Number of trucks: ");
        String number = sc.nextLine();
        while (!Validator.validateNumber(number)) {
            System.out.println("Enter a correct number of trucks: ");
            number = sc.nextLine();
        }
        return new Opportunity(productEnum, Integer.parseInt(number), contact, Status.OPEN);

    }

    private static Product findProductEnum(String product) {
        switch (product) {
            case "hybrid" -> {
                return Product.HYBRID;
            }
            case "flatbed" -> {
                return Product.FLATBED;
            }
            case "box" -> {
                return Product.BOX;
            }
        }
        return null;
    }

    private static Lead promptLead() {
        //Output for prompt Lead
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        while (!Validator.validateName(name)) {
            System.out.println("Enter a correct name"); //Be more specific with the format
            name = sc.nextLine();
        }
        String email = sc.nextLine();
        while (!Validator.validateEmail(email)) {
            System.out.println("Enter a correct email"); //Be more specific with the format
            email = sc.nextLine();
        }
        String companyName = sc.nextLine();
        while (!Validator.validateCompanyName(companyName)) {
            System.out.println("Enter a correct company name"); //Be more specific with the format
            companyName = sc.nextLine();
        }
        String phoneNumber = sc.nextLine();
        while (!Validator.validatePhoneNumber(phoneNumber)) {
            System.out.println("Enter a correct phone number"); //Be more specific with the format
            phoneNumber = sc.nextLine();
        }

        return new Lead(name, email, companyName, phoneNumber);
    }

    public static void showList(String objectType) {
        //Storage method for returning the list of a specific object
    }

    public static void showObject(String objectType, int id) {
        //Storage method for returning an object by id
    }

    public static void printCommandList() {
        System.out.println("=====Command List=====");
        for (String string : commandList) {
            System.out.println(string);
        }
        System.out.println();
    }

    public static void setCommandList() {
        commandList = new ArrayList<>();
        commandList.add("New Lead : Add a new Lead");
        commandList.add("Show Leads : Shows a list of all the Leads");
        commandList.add("Convert <id> : Converts a Lead into an Opportunity");
        commandList.add("Lookup Opportunity <id> : Shows an Opportunity.");
        commandList.add("Close-Won <id> : Closes an Opportunity as won.");
        commandList.add("Close-Lost <id> : Closes an Opportunity as lost.");
        commandList.add("Exit : Closes the CRM.");
    }

}
