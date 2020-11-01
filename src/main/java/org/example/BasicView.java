package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BasicView {

    //FXMLs//
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
    //customerTab//

    //reviewsTab//
    @FXML
    private  TextField revBookNameForReviews;

    @FXML
    private Button revCheckForReviews;

    @FXML
    private TextArea revTextAreaForReviews;
    //reviewsTab//

    //registrationTab//
    @FXML
    private TextField regAuthorFirstName, regAuthorLastName, regCustomerFirstName, regCustomerLastName;

    @FXML
    private Button regCreateAuthor, regCreateCustomer;
    //registrationTab//
    //FXMLs//




}