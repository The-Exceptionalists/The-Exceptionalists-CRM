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

//class Item<T>{
//    T obj;
//    Item(T obj){
//        this.obj = obj;
//    }
//}

public class Storage {

    private static int id = 0;

    private static HashMap<String, Account> accountHashMap = new HashMap<>();
    private static HashMap<String, Contact> contactHashMap = new HashMap<>();
    private static HashMap<String, Lead> leadHashMap = new HashMap<>();
    private static HashMap<String, Opportunity> opportunityHashMap = new HashMap<>();

    public static int add(Account item) {
        accountHashMap.put(item.getId(), item);
        return 0;
    }

    public static int add(Contact item) {
        contactHashMap.put(item.getId(), item);
        return 0;
    }

    public static int add(Opportunity item) {
        opportunityHashMap.put(item.getId(), item);
        return 0;
    }

    public static int add(Lead item) {
        leadHashMap.put(item.getId(), item);
        return 0;
    }

    public static void update(Account item) {
        if (accountHashMap.containsKey(item.getId()))
            accountHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    public static void update(Contact item) {
        if (contactHashMap.containsKey(item.getId()))
            contactHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    public static void update(Opportunity item) {
        if (opportunityHashMap.containsKey(item.getId()))
            opportunityHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }

    public static void update(Lead item) {
        if (leadHashMap.containsKey(item.getId()))
            leadHashMap.replace(item.getId(), item);
        else throw new IllegalArgumentException(item.getId() + "not found");
    }


//    example on how it should be used work
//    if (idIsAccount(id)){ searchAccount(id)}

    public static Account searchAccount(String id) {
        return accountHashMap.get(id);
    }

    public static Contact searchContact(String id) {
        return contactHashMap.get(id);
    }

    public static Opportunity searchOpportunity(String id) {
        return opportunityHashMap.get(id);
    }

    public static Lead searchLead(String id) {
        return leadHashMap.get(id);
    }

    public static List<Account> getAllAccounts(){
        Collection<Account> values = accountHashMap.values();
        return new ArrayList<>(values);
    }

    public static List<Contact> getAllContacts(){
        Collection<Contact> values = contactHashMap.values();
        return new ArrayList<>(values);
    }

    public static List<Opportunity> getAllOpportunities(){
        Collection<Opportunity> values = opportunityHashMap.values();
        return new ArrayList<>(values);
    }

    public static List<Lead> getAllLeads(){
        Collection<Lead> values = leadHashMap.values();
        return new ArrayList<>(values);
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

    public static boolean idIsAccount(String id){
        return id.startsWith("ac") ? true : false;
    }

    public static boolean idIsContact(String id){
        return id.startsWith("ct") ? true : false;
    }

    public static boolean idIsLead(String id){
        return id.startsWith("le") ? true : false;
    }

    public static boolean idIsOpportunity(String id){
        return id.startsWith("op") ? true : false;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Storage.id = id;
    }


}
