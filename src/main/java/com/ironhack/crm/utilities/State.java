package com.ironhack.crm.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Lead;
import com.ironhack.crm.classes.Opportunity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class State implements Runnable {

    public static void saveState() {
        writeLeads();
        writeAccounts();
    }

    public static void restoreState() {
        readLeads();
        readAccounts();

    }

    private static void writeLeads() {
        List<Lead> leads = Storage.getAllLeads();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String path = "src/main/resources/Database/leads.json";
        try {
            FileWriter fileWriter = new FileWriter(path);
            gson.toJson(leads, fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readLeads() {
        String path = "src/main/resources/Database/leads.json";
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Lead> leads = new Gson().fromJson(reader, new TypeToken<List<Lead>>() {
        }.getType());


        for (Lead lead : leads) {
            Storage.add(lead);
        }
    }

    private static void writeAccounts() {
        List<Account> accounts = Storage.getAllAccounts();
        Gson gson;
        gson = new GsonBuilder().setPrettyPrinting().create();
        String path = "src/main/resources/Database/accounts.json";
        try {
            FileWriter fileWriter = new FileWriter(path);
            gson.toJson(accounts, fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readAccounts() {


        String path = "src/main/resources/Database/opportunities.json";
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Account> accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
        }.getType());


        for (Account account : accounts) {
            Storage.add(account);
            for (Opportunity opportunity : account.getOpportunityList()) {
                Storage.add(opportunity);
            }
            for (Contact contact : account.getContactList()) {
                Storage.add(contact);
            }
        }

    }


    @Override
    public void run() {
        writeLeads();
    }
}
