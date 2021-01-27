package com.ironhack.crm.utilities;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.ironhack.crm.classes.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

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

        if (leads != null) {
            for (Lead lead : leads) {
                Storage.add(lead);
                Storage.setUpId();
            }
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


        String path = "src/main/resources/Database/accounts.json";
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Account> accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
        }.getType());

        if (accounts != null) {

            for (Account account : accounts) {
                Storage.add(account);
                Storage.setUpId();
                if (account.getOpportunityList() != null) {
                    for (Opportunity opportunity : account.getOpportunityList()) {
                        Storage.add(opportunity);
                        Storage.setUpId();
                    }
                }
                if (account.getContactList() != null) {

                    for (Contact contact : account.getContactList()) {
                        Storage.add(contact);
                        Storage.setUpId();
                    }
                }
            }
        }

    }


    @Override
    public void run() {
        writeLeads();
        writeAccounts();
        Thread.currentThread().interrupt();
    }
}
