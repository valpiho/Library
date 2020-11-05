package org.example.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Returned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "reBook_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reCustomer_id")
    private Customer reCustomer;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date returned;

    private Date borrowed;

    public Returned() {
    }

    public Returned(Book reBookBor, Customer reCustomer, Date borrowed) {
        this.book = reBookBor;
        this.reCustomer = reCustomer;
        this.borrowed = borrowed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getReBookBor() {
        return book;
    }

    public void setReBookBor(Book reBookBor) {
        this.book = reBookBor;
    }

    public Customer getReCustomer() {
        return reCustomer;
    }

    public void setReCustomer(Customer reCustomer) {
        this.reCustomer = reCustomer;
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        this.returned = returned;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Returned{" +
                "id=" + id +
                ", book=" + book.getName() +
                ", reCustomer=" + reCustomer.getFirstName() +
                ", returned=" + returned +
                ", borrowed=" + borrowed +
                '}';
    }
}
