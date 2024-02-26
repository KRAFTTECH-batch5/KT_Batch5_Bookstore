package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class DeleteBook extends Globals {

    public void deleteBook() {

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("isbn", isbnNumbers.get(1));

        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(map).log().all()
                .when()
                .delete("/BookStore/v1/Book")
                .prettyPeek();
    }

    public void validateThatBookIsRemoved() {
        Assert.assertEquals(204, response.statusCode());
    }

}
