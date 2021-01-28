package com.ironhack.crm.classes;

import com.ironhack.crm.enums.ItemType;
import com.ironhack.crm.utilities.Storage;
import com.ironhack.crm.utils.Validator;

public class Contact {
    //Properties
    private String id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNum;

    //Constructor for the database
    public Contact(String id, String name, String email, String companyName, String phoneNum) {
        setId(id);
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNum(phoneNum);
    }

    //Constructor for a new Contact
    public Contact(String name, String email, String companyName, String phoneNum) {
        setId(Storage.getNewId(ItemType.CONTACT));
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNum(phoneNum);
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
        if (!Validator.validateName(name))
            throw new IllegalArgumentException("Name must be between 1 and 31 characters");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    //Checks if 'email' is a valid email (see Validator class)
    public void setEmail(String email) {
        if (!Validator.validateEmail(email)) throw new IllegalArgumentException();
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    //Checks if 'companyName' is a valid Company Name (see Validator class)
    public void setCompanyName(String companyName) {
        if (!Validator.validateCompanyName(companyName))
            throw new IllegalArgumentException("Company name must be between 1 and 31 characters");
        this.companyName = companyName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    //Checks if 'phoneNum' is a valid Phone Number (see Validator class)
    public void setPhoneNum(String phoneNum) {
        if (!Validator.validatePhoneNumber(phoneNum)) throw new IllegalArgumentException();

        this.phoneNum = phoneNum;
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
        return "Contact{" +
                "id='" + id.substring(charCount) + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
