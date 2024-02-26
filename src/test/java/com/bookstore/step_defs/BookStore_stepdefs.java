package com.bookstore.step_defs;

import com.bookstore.services.*;
import io.cucumber.java.en.*;

public class BookStore_stepdefs {

    GetAllBooks getAllBooks = new GetAllBooks();
    CreateUser createUser = new CreateUser();
    GenerateToken generateToken = new GenerateToken();
    AuthorizeUser authorizeUser = new AuthorizeUser();
    AddBook addBook = new AddBook();
    GetUserDetails getUserDetails = new GetUserDetails();
    UpdateBook updateBook = new UpdateBook();
    DeleteBook deleteBook = new DeleteBook();

    @When("Get All Books")
    public void get_all_books() {
        getAllBooks.getAllBooks();
    }

    @Then("Validate that all books are listed")
    public void validate_that_all_books_are_listed() {
        getAllBooks.validateThatAllBooksAreListed();
    }

    @When("Create user")
    public void create_user() {
        createUser.createUser();
    }

    @Then("Validate that the user is created")
    public void validate_that_the_user_is_created() {
        createUser.validateThatUserIsPosted();
    }

    @When("Generate token")
    public void generate_token() {
        generateToken.generateToken();
    }

    @Then("Validate that the token is generated")
    public void validate_that_the_token_is_generated() {
        generateToken.validateThatTokenIsGenerated();
    }

    @When("Authorize User")
    public void authorize_user() {
        authorizeUser.authorizeUser();
    }

    @Then("Validate that user is authorized")
    public void validate_that_user_is_authorized() {
        authorizeUser.validateThatUserIsAuthorized();
    }

    @When("Add Book")
    public void add_book() {
        addBook.addBook();
    }

    @Then("Validate that the book is added")
    public void validate_that_the_book_is_added() {
        addBook.validateThatBookIsAssigned();
    }

    @When("Get User Details")
    public void get_user_details() {
        getUserDetails.getUserDetails();
    }

    @Then("Validate that user details are correct")
    public void validate_that_user_details_are_correct() {
        getUserDetails.validateThatUserDetailsAreCorrect();
    }

    @When("Update book")
    public void update_book() {
        updateBook.updateBook();
    }

    @Then("Validate that book is updated")
    public void validate_that_book_is_updated() {
        updateBook.validateThatIsbnNumberIsChanged();
    }

    @When("Delete book")
    public void delete_book() {
        deleteBook.deleteBook();
    }

    @Then("Validate that the book is removed")
    public void validate_that_the_book_is_removed() {
        deleteBook.validateThatBookIsRemoved();
    }
}
