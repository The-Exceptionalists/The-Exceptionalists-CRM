package com.ironhack.crm.utilities;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Lead;
import com.ironhack.crm.classes.Opportunity;
import com.ironhack.crm.enums.ItemType;

import java.util.HashMap;

public class Storage {

    private static int id = 0;

    HashMap<String, Account> accountHashMap = new HashMap<>();
    HashMap<String, Contact> contactHashMap = new HashMap<>();
    HashMap<String, Lead> leadHashMap = new HashMap<>();
    HashMap<String, Opportunity> opportunityHashMap = new HashMap<>();

    public static <T extends Account, Contact, Opportunity, Lead> int update(T item) {
        System.out.println("ClassName: " + item.getClass().getName());

        switch (item.getClass().getName()) {
            case "com.ironhack.crm.classes.Account" -> System.out.println(item.getCompanyName());
        }
        return 0;
    }

    public static <T extends Account, Contact, Opportunity> int add(T item) {
        System.out.println("ClassName: " + item.getClass().getName());

        switch (item.getClass().getName()) {
            case "com.ironhack.crm.classes.Account" -> System.out.println(item.getCompanyName());
        }

        return 0;
    }


    public static <T extends Account, Contact, Opportunity> T search(String id) {
        T itemFound = null;

        return itemFound;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Storage.id = id;
    }

    public static String getNewId(ItemType itemType) {
        String prefix = null;
        switch (itemType) {
            case LEAD -> prefix = "le";
            case ACCOUNT -> prefix = "ac";
            case CONTACT -> prefix = "ct";
            case OPPORTUNITY -> prefix = "op";
        }
        Storage.id++;
        return prefix + Storage.id;
    }
}
