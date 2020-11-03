package org.example.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToOne
//    @JoinColumn(name = "borrowed_by")
//    private Customer customerBor;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book bookBor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date borrowedAt;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date returnedAt;

    public Borrowed() {
    }

    public Borrowed(Book bookBor, Customer customer) {
        this.bookBor = bookBor;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Customer getCustomerBor() {
//        return customerBor;
//    }
//
//    public void setCustomerBor(Customer customerBor) {
//        this.customerBor = customerBor;
//    }

    public Book getBookBor() {
        return bookBor;
    }

    public void setBookBor(Book bookBor) {
        this.bookBor = bookBor;
    }

    public Date getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(Date borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }
}
