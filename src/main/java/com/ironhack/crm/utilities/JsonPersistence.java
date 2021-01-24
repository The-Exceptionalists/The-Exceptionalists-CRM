package com.ironhack.crm.classes;

import com.ironhack.crm.enums.Product;

public class Database {

    public static <T> void addToDatabase(T object) {

        if (object instanceof Contact) {
            writeInDatabase(contactToCsvString((Contact) object));
        } else if (object instanceof Account) {
            writeInDatabase(accountToCsvString((Account) object));
        } else if (object instanceof Lead) {
            writeInDatabase(leadToCsvString((Lead) object));
        } else if (object instanceof Opportunity) {
            writeInDatabase(opportunityToCsvString((Opportunity) object));
        }

    }

    private static void writeInDatabase(String line) {

    }

    private static String  opportunityToCsvString(Opportunity opportunity) {

        return String.format("%s, %d, %d, %s\n",
                opportunity.getProduct(), opportunity.getQuantity(), opportunity.getDecisionMaker().getId(), opportunity.getStatus());

    }

    private static String leadToCsvString(Lead lead) {
    }

    private static String  accountToCsvString(Account newAccount) {
    }

    private static String  contactToCsvString(Contact newContact) {
        
    }
}
