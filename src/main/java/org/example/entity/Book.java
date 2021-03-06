package org.example.entity;

import org.example.Dao.AuthorDao;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private String description;

    @OneToOne(mappedBy = "bookBor")
    private Borrowed borrowed;

    @OneToOne(mappedBy = "book")
    private Returned returned;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date editedAt;

    private boolean isBorrowed;

    @OneToMany(mappedBy = "bookRev", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Review> reviewList;

    public Book() {}

    public Book(String name, Author author, String description) {
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Returned getReturned() {
        return returned;
    }

    public void setReturned(Returned returned) {
        this.returned = returned;
    }

    public Borrowed getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Borrowed borrowed) {
        this.borrowed = borrowed;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
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


    @Override
    public String toString() {

        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author.getFirstName() +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                ", isBorrowed=" + isBorrowed +
                ", reviewList=" + reviewList;
    }
}
