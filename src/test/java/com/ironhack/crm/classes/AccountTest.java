package com.ironhack.crm.classes;

import com.ironhack.crm.enums.Industry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {

    List<Contact> contactList;
    List<Opportunity> opportunityList;

    @BeforeEach
    void setUp() {
        contactList = new ArrayList<>();
        contactList.add(new Contact());
        opportunityList = new ArrayList<>();
        opportunityList.add(new Opportunity());
    }

    @Test
    void setEmployeeCount_positiveInteger_set() {
        Account account1 = new Account("Apple", Industry.OTHER, 2, "New York", "USA", contactList, opportunityList);
        assertEquals(2, account1.getEmployeeCount());
        Account account2 = new Account("Apple", Industry.OTHER, 3000, "New York", "USA", contactList, opportunityList);
        assertEquals(3000, account2.getEmployeeCount());
    }

    @Test
    void setEmployeeCount_negativeOrZeroInteger_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Account("Apple", Industry.OTHER, -100, "New York", "USA", contactList, opportunityList));
        assertThrows(IllegalArgumentException.class, () -> new Account("Apple", Industry.OTHER, 0, "New York", "USA", contactList, opportunityList));
    }

    @Test
    void setContactList_notEmptyList_set() {
        Account account = new Account("Apple", Industry.OTHER, 2, "New York", "USA", contactList, opportunityList);
        assertEquals(1, account.getContactList().size());
    }

    @Test
    void setContactList_EmptyList_IllegalArgumentException() {
        List<Contact> contacts = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Account("Apple", Industry.OTHER, -100, "New York", "USA", contacts, opportunityList));
    }

    @Test
    void setOpportunityList_notEmptyList_set() {
        Account account = new Account("Apple", Industry.OTHER, 2, "New York", "USA", contactList, opportunityList);
        assertEquals(1, account.getOpportunityList().size());
    }

    @Test
    void setOpportunityList_EmptyList_IllegalArgumentException() {
        List<Opportunity> opportunities = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Account("Apple", Industry.OTHER, -100, "New York", "USA", contactList, opportunities));
    }
}
