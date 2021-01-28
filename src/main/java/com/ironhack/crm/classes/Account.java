package com.ironhack.crm.classes;

import com.ironhack.crm.enums.Industry;
import com.ironhack.crm.enums.ItemType;
import com.ironhack.crm.utilities.Storage;
import com.ironhack.crm.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Account {
    //Properties
    private String id;
    private String companyName;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList = new ArrayList<>();
    private List<Opportunity> opportunityList = new ArrayList<>();

    //Constructor for the database
    public Account(String id, String companyName, Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setId(id);
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        addContactToList(contact);
        addOpportunityToList(opportunity);
    }

    //Constructor for a new Account
    public Account(String companyName, Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setId(Storage.getNewId(ItemType.ACCOUNT));
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        addContactToList(contact);
        addOpportunityToList(opportunity);
    }

    //Methods
    private void addOpportunityToList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    private void addContactToList(Contact contact) {
        contactList.add(contact);
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    //Employee must be at least 1
    public void setEmployeeCount(int employeeCount) {
        if (employeeCount <= 0) {
            throw new IllegalArgumentException("The employee count must be at least 1.");
        }
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    //The List can't be empty
    public void setContactList(List<Contact> contactList) {
        if (contactList.size() == 0) {
            throw new IllegalArgumentException("The contact list is empty!");
        }
        this.contactList = contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    //The List can't be empty
    public void setOpportunityList(List<Opportunity> opportunityList) {
        if (opportunityList.size() == 0) {
            throw new IllegalArgumentException("The opportunity list is empty!");
        }
        this.opportunityList = opportunityList;
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
        return "Account{" +
                "id=" + id.substring(charCount) +
                ", companyName='" + companyName + '\'' +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }
}
