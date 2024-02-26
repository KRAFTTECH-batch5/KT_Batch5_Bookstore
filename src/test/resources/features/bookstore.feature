Feature: BookStore Flow

  @wip
  Scenario: BookStore Test
    When Get All Books
    Then Validate that all books are listed
    When Create user
    Then Validate that the user is created
    When Generate token
    Then Validate that the token is generated
    When Authorize User
    Then Validate that user is authorized
    When Add Book
    Then Validate that the book is added
    When Get User Details
    Then Validate that user details are correct
    When Update book
    Then Validate that book is updated
    When Delete book
    Then Validate that the book is removed