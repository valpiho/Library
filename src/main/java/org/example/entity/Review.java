package org.example.entity;

import java.util.Date;

public class Review {

    private int id;
    private String description;
    private Customer customer;
    private Date createdAt;
    private Date editedAt;

    public Review() {}

    public Review(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(Date editedAt) {
        this.editedAt = editedAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                '}';
    }
}
