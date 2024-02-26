package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class AddBook extends Globals {

    public void addBook() {

        String jsonBody = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbnNumbers.get(0) + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(jsonBody).log().all()
                .when()
                .post("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatBookIsAssigned() {
        //validate status code
        Assert.assertEquals(201, response.statusCode());

        //validate isbn number
        Assert.assertEquals(isbnNumbers.get(0), response.path("books.isbn[0]"));
    }
}
