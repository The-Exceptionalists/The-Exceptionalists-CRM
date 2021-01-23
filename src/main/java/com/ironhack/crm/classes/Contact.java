package com.ironhack.crm.classes;

import com.ironhack.crm.utils.Validator;

public class Contact {
    private static int contactCounter = 0;
    private String id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNum;

    public Contact(String name, String email, String companyName, String phoneNum) {

        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNum(phoneNum);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(!Validator.validateName(name)) throw new IllegalArgumentException("Name must be between 1 and 31 characters");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if(!Validator.validateEmail(email)) throw new IllegalArgumentException();
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    private void setCompanyName(String companyName) {
        if(!Validator.validateName(companyName)) throw new IllegalArgumentException("Company name must be between 1 and 31 characters");
        this.companyName = companyName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    private void setPhoneNum(String phoneNum) {
        if(!Validator.validatePhoneNumber(phoneNum)) throw new IllegalArgumentException();

        this.phoneNum = phoneNum;
    }
}
