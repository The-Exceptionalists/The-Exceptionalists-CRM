package com.ironhack.crm.classes;

import com.ironhack.crm.enums.ItemType;
import com.ironhack.crm.enums.Product;
import com.ironhack.crm.enums.Status;
import com.ironhack.crm.utilities.Storage;

public class Opportunity {
    //Properties
    private String id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    //Constructor for the database
    public Opportunity(String id, Product product, int quantity, Contact decisionMaker, Status status) {
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    //Constructor for a new Opportunity
    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        setId(Storage.getNewId(ItemType.OPPORTUNITY));
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("The number of trucks must be greater than zero.");
        }
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", decisionMaker=" + decisionMaker +
                ", status=" + status +
                '}';
    }
}
