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
        List<Lead> leads = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            leads = new Gson().fromJson(reader, new TypeToken<List<Lead>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("No hay leads en la base de datos");
        }

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
        List<Account> accounts = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("No hay contactos en la base de datos");
        }

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
