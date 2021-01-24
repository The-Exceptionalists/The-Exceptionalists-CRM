package com.ironhack.crm.utilities;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Lead;
import com.ironhack.crm.classes.Opportunity;
import com.ironhack.crm.enums.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class Storage {

    private static int id = 0;

    private static HashMap<String, Account> accountHashMap = new HashMap<>();
    private static HashMap<String, Contact> contactHashMap = new HashMap<>();
    private static HashMap<String, Lead> leadHashMap = new HashMap<>();
    private static HashMap<String, Opportunity> opportunityHashMap = new HashMap<>();

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Account item) {
        accountHashMap.put(item.getId(), item);
    }

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Contact item) {
        contactHashMap.put(item.getId(), item);
    }

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Opportunity item) {
        opportunityHashMap.put(item.getId(), item);
    }

    /**
     * Add item to the correct hashmap
     *
     * @param item
     */
    public static void add(Lead item) {
        leadHashMap.put(item.getId(), item);
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Account item) {
        if (accountHashMap.containsKey(item.getId()))
            accountHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Contact item) {
        if (contactHashMap.containsKey(item.getId()))
            contactHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Opportunity item) {
        if (opportunityHashMap.containsKey(item.getId()))
            opportunityHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    /**
     * Receive the updated version of an item and store it in the right place.
     *
     * @param item
     */
    public static void update(Lead item) {
        if (leadHashMap.containsKey(item.getId()))
            leadHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }


//    example on how it should be used work
//    if (idIsAccount(id)){ searchAccount(id)}

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Account searchAccount(String id) {
        return accountHashMap.get(id);
    }

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Contact searchContact(String id) {
        return contactHashMap.get(id);
    }

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Opportunity searchOpportunity(String id) {
        return opportunityHashMap.get(id);
    }

    /**
     * Search for an item and returns it
     *
     * @param id String id of item you are searching
     * @return
     */
    public static Lead searchLead(String id) {
        return leadHashMap.get(id);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Account> getAllAccounts() {
        Collection<Account> values = accountHashMap.values();
        return new ArrayList<>(values);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Contact> getAllContacts() {
        Collection<Contact> values = contactHashMap.values();
        return new ArrayList<>(values);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Opportunity> getAllOpportunities() {
        Collection<Opportunity> values = opportunityHashMap.values();
        return new ArrayList<>(values);
    }

    /**
     * All items of a type finder
     *
     * @return an ArrayList of all item of a type
     */
    public static List<Lead> getAllLeads() {
        Collection<Lead> values = leadHashMap.values();
        return new ArrayList<>(values);
    }


    /**
     * Return a unique id generated involving the item class
     *
     * @param itemType
     * @return
     */
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

    public static boolean idIsAccount(String id) {
        return id.startsWith("ac") ? true : false;
    }

    public static boolean idIsContact(String id) {
        return id.startsWith("ct") ? true : false;
    }

    public static boolean idIsLead(String id) {
        return id.startsWith("le") ? true : false;
    }

    public static boolean idIsOpportunity(String id) {
        return id.startsWith("op") ? true : false;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Storage.id = id;
    }


}
