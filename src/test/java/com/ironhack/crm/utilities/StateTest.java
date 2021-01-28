package com.ironhack.crm.utilities;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.ironhack.crm.classes.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    String leadPath = "src/test/resources/Database/leads.json";
    String accountPath = "src/test/resources/Database/accounts.json";
    Reader reader = null;


    @Test
    void saveState_ensureLeadsAreWritten_JSONFile() {
        try {
            reader = Files.newBufferedReader(Paths.get(leadPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Lead> leads = new Gson().fromJson(reader, new TypeToken<List<Lead>>() {
        }.getType());

        assertEquals("Vicente Mendieta", leads.get(0).getName());

    }

    @Test
    void saveState_ensureAccountsAreWritten_JSONFile() {
        try {
            reader = Files.newBufferedReader(Paths.get(accountPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Account> accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
        }.getType());

        assertEquals("Microsoft", accounts.get(0).getCompanyName());
    }

    @Test
    void saveState_ensureContactsAreWritten_JSONFile() {

        try {
            reader = Files.newBufferedReader(Paths.get(accountPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Account> accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
        }.getType());

        assertEquals("Jose Perez", accounts.get(0).getContactList().get(0).getName());
    }

    @Test
    void saveState_ensureOpportunitiesAreWritten_JSONFile() {

        try {
            reader = Files.newBufferedReader(Paths.get(accountPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Account> accounts = new Gson().fromJson(reader, new TypeToken<List<Account>>() {
        }.getType());

        assertEquals("op0000000006", accounts.get(0).getOpportunityList().get(0).getId());
    }


}
