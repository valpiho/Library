package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BasicView {

    //authorTab//
    @FXML
    private TextField auBookNameForCreate, auBookDescForCreate, auBookNameForEdit, auBookDescForEdit,
                        auBookIdForDeleteOrGet, auNameForGetAllBooksAndReviews, auBookIdForEdit;

    @FXML
    private Button auCreateBook, auEditBook, auDeleteBook, auGetBook, auGetAllBooks, auGetAllReviews;

    @FXML
    private TextArea auTextAreaForAll;
    //authorTab//
    //customerTab//
    @FXML
    private TextField cuBookNameForBorrowAndReturnAndEdit, cuReviewForCreateAndEdit, cuBookNameForGetReviewAndReviews,
                        cuBookNameForDelete;

    @FXML
    private Button cuBorrowBook, cuReturnBook, cuCreateReview, cuEditReview, cuGetBookReview, cuGetBooksReview,
                    cuDeleteBookReview;

    @FXML
    private TextArea cuTextAreaForAll;


}
