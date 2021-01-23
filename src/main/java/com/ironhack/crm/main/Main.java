package com.ironhack.crm.main;

import com.ironhack.crm.classes.Account;
import com.ironhack.crm.classes.Contact;
import com.ironhack.crm.classes.Opportunity;
import com.ironhack.crm.enums.Industry;
import com.ironhack.crm.enums.Product;
import com.ironhack.crm.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Ivan", "asd@hotmail.com", "Hehe", "+20 00"));
        List<Opportunity> opportunityList = new ArrayList<>();
        opportunityList.add(new Opportunity(Product.BOX, 20, contactList.get(0), Status.OPEN));
        Account account = new Account("dsgg", Industry.PRODUCE, 1, "sda", "adfs", contactList, opportunityList);
        System.out.println(account);

    }
}
