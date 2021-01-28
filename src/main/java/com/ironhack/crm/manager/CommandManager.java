package com.ironhack.crm.manager;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Lead;
import com.ironhack.crm.classes.Opportunity;
import com.ironhack.crm.enums.Industry;
import com.ironhack.crm.enums.Product;
import com.ironhack.crm.enums.Status;
import com.ironhack.crm.utilities.Buffer;
import com.ironhack.crm.utilities.Output;
import com.ironhack.crm.utilities.State;
import com.ironhack.crm.utilities.Storage;
import com.ironhack.crm.utils.Validator;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    private static List<String> commandList;

    public static List<String> getCommandList() {
        return commandList;
    }

    //Method that asks for a command and validates it
    public static void introduceCommand() {
        CommandManager.setCommandList();
        Buffer.setUpLayout();
        Buffer.setPromptLineTwo("Introduce a command from the list:");
        Buffer.insertCentralPromptPoints(2);
        Buffer.insertCentralPromptPoints(1);
        Output.printScreen();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        command = command.toLowerCase();

        if (Validator.validateCommand(command)) {
            processCommand(command);
        } else {
            Buffer.setPromptLineOne("Command not found");
        }
    }

    //Method that handles all commands and calls the required method
    public static void processCommand(String command) {
        String[] words = command.toLowerCase().split(" ");
        switch (words[0]) {
            case "new" -> createObject(words[1]);
            case "show" -> showList(words[1]);
            case "convert" -> convertLeadToOpportunity(Integer.parseInt(words[1]));
            case "lookup" -> showObject(words[1], Integer.parseInt(words[2]));
            case "close-won" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_WON);
            case "close-lost" -> closeOpportunity(Integer.parseInt(words[1]), Status.CLOSED_LOST);
//            case "help" -> printCommandList();
            case "exit" -> saveChangesAndExit();
        }
    }

    private static void saveChangesAndExit() {
        new Thread(new State()).run();

        System.exit(0);
    }

    //Method that handles the object creation
    private static void createObject(String word) {
        if ("lead".equals(word)) {
            Lead lead = promptLead();
            Storage.add(lead);
            System.out.println("New lead successfully added!");
        }
    }

    //Method that handles the show command
    public static void showList(String objectType) {
        switch (objectType) {
            case "leads" -> {
                List<Lead> leadList = Storage.getAllLeads();
                printLeadList(leadList);
            }
            case "opportunities" -> {
                List<Opportunity> opportunityList = Storage.getAllOpportunities();
                printOpportunityList(opportunityList);
            }
            case "contacts" -> {
                List<Contact> contactList = Storage.getAllContacts();
                printContactList(contactList);
            }
            case "accounts" -> {
                List<Account> accountList = Storage.getAllAccounts();
                printAccountList(accountList);
            }
        }
    }

    //Method that handles the lead to opportunity conversion
    private static void convertLeadToOpportunity(int id) {
        try {
            //Searches a lead, changing the parameter id to the format used in Storage
            StringBuilder zeros = new StringBuilder();
            zeros.append("0".repeat(Math.max(0, 10 - String.valueOf(id).length())));
            Lead lead = Storage.searchLead("le" + zeros + id);
            Contact contact = leadToContact(lead);
            Opportunity opportunity = promptOpportunity(contact);
            Account account = promptAccount(contact.getCompanyName(), contact, opportunity);
            //Adds all objects to the storage class
            Storage.add(contact);
            Storage.add(opportunity);
            Storage.add(account);
            //Remove the lead
            Storage.removeLead("le" + zeros + id);
            //Return an error message if the id is not found
        } catch (IllegalArgumentException | NullPointerException e) {
            Buffer.setUpLayout();
            Buffer.setPromptLineOne("Lead with id " + id + " not found.");
            Buffer.insertCentralPromptPoints(2);
            Buffer.insertCentralPromptPoints(1);
            Output.printScreen();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    //Creates a Contact object from a Lead object
    private static Contact leadToContact(Lead lead) {
        String name = lead.getName();
        String email = lead.getEmail();
        String companyName = lead.getCompanyName();
        String phoneNumber = lead.getPhoneNumber();
        return new Contact(name, email, companyName, phoneNumber);
    }

    //Prompts all required parameters for the opportunity creation
    private static Opportunity promptOpportunity(Contact contact) {
        //Output for prompt Opportunity
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.insertStringIntoRepository("New Opportunity creation", 7);
        Scanner sc = new Scanner(System.in);
        String text = "Type of truck (Hybrid, Flatbed or Box):";
        printItemPrompt(text);
        String product = sc.nextLine().toLowerCase();
        //Keeps asking for the correct value
        while (!Validator.validateProduct(product)) {
            Buffer.setPromptLineTwo("Enter a correct product (Hybrid, Flatbed or Box): ");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            product = sc.nextLine().toLowerCase();
        }
        Buffer.insertStringIntoRepository("Product type: " + product, 10);
        Product productEnum = findProductEnum(product);
        text = "Number of trucks: ";
        printItemPrompt(text);
        String number = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateNumber(number)) {
            Buffer.setPromptLineTwo("Enter a correct number of trucks: ");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            number = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Number of trucks: " + number, 11);
        printItemPrompt("Opportunity created!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Opportunity created");
//        System.out.println("\n");
//        System.out.printf("New Account creation:");
        return new Opportunity(productEnum, Integer.parseInt(number), contact, Status.OPEN);
    }

    //Prompts all required parameters for the account creation
    private static Account promptAccount(String companyName, Contact contact, Opportunity opportunity) {
        //Output for prompt Account
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.insertStringIntoRepository("New Account creation", 7);
        Scanner sc = new Scanner(System.in);
        String text = "Choose an Industry (Produce, Ecommerce, Manufacturing, Medical, Other): ";
        printItemPrompt(text);
        String industry = sc.nextLine().toLowerCase();
        //Keeps asking for the correct value
        while (!Validator.validateIndustry(industry)) {
            Buffer.setPromptLineTwo("Enter industry: Produce, Ecommerce, Manufacturing, Medical, Other ");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            industry = sc.nextLine().toLowerCase();
        }
        Buffer.insertStringIntoRepository("Industry: " + industry, 11);
        Industry industryEnum = findIndustryEnum(industry);
        text = "Insert employee count: ";
        printItemPrompt(text);
        String employeeCount = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateNumber(employeeCount)) {
            Buffer.setPromptLineTwo("Enter a correct number of employees:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            employeeCount = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Number of employees: " + employeeCount, 11);
        text = "Insert city name:";
        printItemPrompt(text);
        String city = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateName(city)) {
            Buffer.setPromptLineTwo("Enter a correct value:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            city = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("City name: " + city, 12);
        text = "Insert country: ";
        printItemPrompt(text);
        String country = sc.nextLine();
        //Keeps asking for the correct value
        while (!Validator.validateName(country)) {
            Buffer.setPromptLineTwo("Enter a correct value:");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            country = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Country: " + country, 13);
        printItemPrompt("New Account created");
        return new Account(companyName, industryEnum, Integer.parseInt(employeeCount), city, country, contact, opportunity);
    }

    //Method that handles the lookup command
    public static void showObject(String objectType, int id) {
        //Searches an object, changing the parameter id to the format used in Storage
        Buffer.resetPromptMessages();
        Buffer.initStringsRepository();
        Buffer.setUpLayout();
        StringBuilder zeros = new StringBuilder();
        zeros.append("0".repeat(Math.max(0, 10 - String.valueOf(id).length())));
        switch (objectType) {
            case "opportunity" -> {
                try {
                    Opportunity opportunity = Storage.searchOpportunity("op" + zeros + id);
                    Buffer.insertOpportunityStringRepository(opportunity, 1, 1);
                    Buffer.insertItemSolo();
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException e) {
                    Buffer.setPromptLineOne("Opportunity with id " + id + " not found.");
                    Buffer.insertCentralPromptPoints(1);
                    Output.printScreen();
                    Buffer.resetPromptOne();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                }
            }
            case "lead" -> {
                try {
                    Lead lead = Storage.searchLead("le" + zeros + id);
                    Buffer.insertLeadStringRepository(lead, 1, 1);
                    Buffer.insertItemSolo();
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException e) {
                    Buffer.setPromptLineOne("Lead with id " + id + " not found.");
                    Buffer.insertCentralPromptPoints(1);
                    Output.printScreen();
                    Buffer.resetPromptOne();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                }
            }
            case "contact" -> {
                try {
                    Contact contact = Storage.searchContact("co" + zeros + id);
                    Buffer.insertContactStringRepository(contact, 1, 1);
                    Buffer.insertItemSolo();
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException e) {
                    Buffer.setPromptLineOne("Contact with id " + id + " not found.");
                    Buffer.insertCentralPromptPoints(1);
                    Output.printScreen();
                    Buffer.resetPromptOne();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                }
            }
            case "account" -> {
                try {
                    Account account = Storage.searchAccount("ac" + zeros + id);
                    Buffer.insertAccountStringRepository(account, 1, 1);
                    Buffer.insertItemSolo();
                    Output.printScreen();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                } catch (IllegalArgumentException | NullPointerException e) {
                    Buffer.setPromptLineOne("Account with id " + id + " not found.");
                    Buffer.insertCentralPromptPoints(1);
                    Output.printScreen();
                    Buffer.resetPromptOne();
                    Scanner sc = new Scanner(System.in);
                    String next = sc.nextLine();
                }
            }
        }
    }

    //Closes an opportunity given an id and the status
    private static void closeOpportunity(int id, Status close) {
        try {
            //Searches an opportunity, changing the parameter id to the format used in Storage
            Opportunity opportunity = Storage.searchOpportunity("op" + "0".repeat(Math.max(0, 10 - String.valueOf(id).length())) + id);
            //Compares the current value of status and it changes only if it's open
            if (opportunity.getStatus() == Status.OPEN) {
                opportunity.setStatus(close);
                Storage.update(opportunity);
                System.out.println("Opportunity closed!");
            } else if (opportunity.getStatus() == Status.CLOSED_LOST) {
                System.out.println("Opportunity already closed as lost.");
            } else if (opportunity.getStatus() == Status.CLOSED_WON) {
                System.out.println("Opportunity already closed as won.");
            }
            //Return an error message if the id is not found
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Opportunity with id " + id + " not found.");
        }
    }

    //Returns an enum depending on the String parameter
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

    //Returns an enum depending on the String parameter
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

    //Prompts all required parameters for the lead creation
    private static Lead promptLead() {
        Buffer.initStringsRepository();
        Buffer.resetPromptMessages();
        Buffer.insertStringIntoRepository("New Lead creation", 7);
        String text = "Insert Lead name:";
        Scanner sc = new Scanner(System.in);
        printItemPrompt(text);
        String name = sc.nextLine();
        while (!Validator.validateName(name)) {

            Buffer.setPromptLineOne("Enter a correct name");
            printItemPrompt(text);
            Buffer.resetPromptOne();
            name = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Name: " + name, 11);
        text = "Insert Lead email: ";
        printItemPrompt(text);
        String email = sc.nextLine();
        while (!Validator.validateEmail(email)) {
            Buffer.setPromptLineOne("Enter a correct email"); //Be more specific with the format
            printItemPrompt(text);
            email = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Email: " + email, 12);
        text = "Company name: ";
        printItemPrompt(text);
        String companyName = sc.nextLine();
        while (!Validator.validateCompanyName(companyName)) {
            Buffer.setPromptLineOne("Enter a correct company name"); //Be more specific with the format
            printItemPrompt(text);
            companyName = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Company: " + companyName, 13);
        text = "Phone number: ";
        printItemPrompt(text);
        String phoneNumber = sc.nextLine();
        while (!Validator.validatePhoneNumber(phoneNumber)) {
            Buffer.setPromptLineOne("Enter a correct phone number"); //Be more specific with the format
            printItemPrompt(text);
            phoneNumber = sc.nextLine();
        }
        Buffer.insertStringIntoRepository("Phone: " + phoneNumber, 14);
        printItemPrompt("Lead Created!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Lead(name, email, companyName, phoneNumber);
    }

    private static void printItemPrompt(String text) {
        Buffer.setPromptLineTwo(text);
        Buffer.insertCentralPromptPoints(1);
        Buffer.insertCentralPromptPoints(2);
        Buffer.insertItemSolo();
        Output.printScreen();
    }

    //Method that prints a list of leads
    private static void printLeadList(List<Lead> leadList) {
        System.out.println("=======List of Leads=======");
        for (Lead lead : leadList) {
            System.out.println(lead + "\n");
        }
        System.out.println();
    }

    //Method that prints a list of opportunities
    private static void printOpportunityList(List<Opportunity> oportunityList) {
        System.out.println("=======List of Oportunities=======");
        for (Opportunity opportunity : oportunityList) {
            System.out.println(opportunity + "\n");
        }
        System.out.println();
    }

    //Method that prints a list of contacts
    private static void printContactList(List<Contact> contactList) {
        System.out.println("=======List of Contacts=======");
        for (Contact contact : contactList) {
            System.out.println(contact + "\n");
        }
        System.out.println();
    }

    //Method that prints a list of accounts
    private static void printAccountList(List<Account> accountList) {
        System.out.println("=======List of Accounts=======");
        for (Account account : accountList) {
            System.out.println(account + "\n");
        }
        System.out.println();
    }

//    public static void printCommandList() {
//        System.out.println("=====Command List=====");
//        setCommandList();
//        for (String string : commandList) {
//            System.out.println(string);
//        }
//        System.out.println();
//    }
//    //Method that prints a list of commands
//    public static void printCommandList() {
//        System.out.println("=====Command List=====");
//        setCommandList();
//        for (String string : commandList) {
//            System.out.println(string);
//        }
//        System.out.println();
//    }

    //Method to create the command list for printing
    public static void setCommandList() {
        Buffer.insertStringIntoRepository("=====Command List=====", 40);
        Buffer.insertStringIntoRepository("", 41);
        Buffer.insertStringIntoRepository("NEW LEAD", 42);
        Buffer.insertStringIntoRepository("SHOW <ObjectInPlural>", 43);
        Buffer.insertStringIntoRepository("Show a list of objects", 44);
        Buffer.insertStringIntoRepository("CONVERT <Id>", 45);
        Buffer.insertStringIntoRepository("Convert Lead -> Opportunity", 46);
        Buffer.insertStringIntoRepository("LOOKUP <Object> <Id>", 47);
        Buffer.insertStringIntoRepository("Show an object", 48);
        Buffer.insertStringIntoRepository("CLOSE-WON <Id>", 49);
        Buffer.insertStringIntoRepository("Close Opportunity as won", 50);
        Buffer.insertStringIntoRepository("CLOSE-LOST <Id>", 51);
        Buffer.insertStringIntoRepository("Close Opportunity as lost", 52);
        Buffer.insertStringIntoRepository("", 53);
        Buffer.insertStringIntoRepository("", 54);
        Buffer.insertStringIntoRepository("EXIT", 55);
        Buffer.insertStringIntoRepository("Save and close the CRM", 56);
    }

}
