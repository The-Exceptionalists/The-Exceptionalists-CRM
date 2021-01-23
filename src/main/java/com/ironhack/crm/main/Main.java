package com.ironhack.crm.main;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.enums.Industry;
import com.ironhack.crm.utilities.Storage;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact());
        List<Opportunity> opportunityList = new ArrayList<>();
        opportunityList.add(new Opportunity());
        Account account = new Account("dsgg", Industry.PRODUCE, 1, "sda", "adfs", contactList, opportunityList);
//        System.out.println(account);

    }
}
