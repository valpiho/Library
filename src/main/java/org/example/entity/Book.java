package org.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {

    private int id;
    private String name;
    private String authorName;
    private String description;
    private Date createdAt;
    private Date editedAt;
    private boolean isBorrowed;
    private List<Review> reviewList;

    public Book() {}

    public Book(String name, String authorName, String description) {
        this.name = name;
        this.authorName = authorName;
        this.description = description;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + authorName +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                ", isBorrowed=" + isBorrowed +
                ", reviewList=" + reviewList +
                '}';
    }
}
