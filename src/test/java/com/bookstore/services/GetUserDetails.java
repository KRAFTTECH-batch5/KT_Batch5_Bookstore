package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class GetUserDetails extends Globals {

    public void getUserDetails() {
        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token).log().all()
                .when()
                .get("/Account/v1/User/" + userId)
                .prettyPeek();
    }

    public void validateThatUserDetailsAreCorrect() {
        //validate status code
        Assert.assertEquals(200, response.statusCode());

        //validate userId
        Assert.assertEquals(userId, response.path("userId"));

        //validate username
        Assert.assertEquals(username, response.path("username"));

        //validate isbn number
        Assert.assertEquals(isbnNumbers.get(0), response.path("books.isbn[0]"));
    }

}
