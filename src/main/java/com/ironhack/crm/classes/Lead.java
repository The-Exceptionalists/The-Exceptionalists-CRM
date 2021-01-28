package com.ironhack.crm.classes;

import com.ironhack.crm.enums.ItemType;
import com.ironhack.crm.utilities.Storage;
import com.ironhack.crm.utils.Validator;

public class Lead {
    //Properties
    private String id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;

    //Constructor for the database
    public Lead(String id, String name, String email, String companyName, String phoneNumber) {
        setId(id);
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    //Constructor for a new Lead
    public Lead(String name, String email, String companyName, String phoneNumber) {
        setId(Storage.getNewId(ItemType.LEAD));
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    //Checks if 'name' is a valid name (see Validator class)
    public void setName(String name) {

        if (!Validator.validateName(name)) {
            throw new IllegalArgumentException("Name wasn't correct");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    //Checks if 'email' is a valid email (see Validator class)
    public void setEmail(String email) {
        if (!Validator.validateEmail(email)) {
            throw new IllegalArgumentException("Name wasn't correct");
        }
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    //Checks if 'companyName' is a valid Company Name (see Validator class)
    public void setCompanyName(String companyName) {

        if (!Validator.validateCompanyName(companyName)) {

            throw new IllegalArgumentException("Company name wasn't correct");
        }

        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Checks if 'phoneNumber' is a valid Phone Number (see Validator class)
    public void setPhoneNumber(String phoneNumber) {

        if (!Validator.validatePhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Phone wasn't correct");
        }

        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        //Shows only the part of the id string that the user needs to see
        char[] idArray = id.toCharArray();
        int charCount = 0;
        for (int i = 2; i < idArray.length; i++) {
            if (idArray[i] != '0') {
                charCount = i;
                break;
            }
        }
        return "Lead{" +
                "id='" + id.substring(charCount) + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
