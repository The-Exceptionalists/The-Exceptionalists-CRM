package com.ironhack.crm.classes;

import com.ironhack.crm.utils.Validator;

public class Contact {
    private static int contactCounter = 0;
    private int contactID;
    private String name;
    private String email;
    private String companyName;
    private String phoneNum;

    public Contact(String name, String email, String companyName, String phoneNum) {
        if(!Validator.validateEmail(email)) throw new IllegalArgumentException();

        this.name = name;
        this.email = email;
        this.companyName = companyName;
        this.phoneNum = phoneNum;
        contactID = contactCounter++;
    }



}
