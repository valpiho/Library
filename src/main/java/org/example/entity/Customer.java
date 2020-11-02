package org.example.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date editedAt;

    @OneToOne(mappedBy = "customerBor")
    private Borrowed borrowed;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Borrowed> bookList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviewList;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Borrowed> getBookList() {
        return bookList;
    }

    public void setBookList(List<Borrowed> bookList) {
        this.bookList = bookList;
    }

    public Borrowed getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Borrowed borrowed) {
        this.borrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void addReview(Review review) {
        if (reviewList == null) {
            reviewList = new ArrayList<>();
        }
        reviewList.add(review);
    }

   /* public void addBook(Book book) {
        if (bookList == null) {
            bookList = new ArrayList<>();
        }
        bookList.add(book);
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                ", bookList=" + bookList +
                ", reviewList=" + reviewList +
                '}';
    }
}
