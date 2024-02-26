package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class GetAllBooks extends Globals {

    public void getAllBooks() {
        response = RestAssured
                .given()
                .accept(ContentType.JSON).log().all()
                .when()
                .get("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatAllBooksAreListed() {
        //validate status code
        Assert.assertEquals(200, response.statusCode());

        //put all isbnNumbers in to a list
        isbnNumbers = response.path("books.isbn");

        //validate that none of isbnNumber is null
        isbnNumbers.forEach(n -> Assert.assertNotNull(n));
    }
}
