package com.bookstore.services;

import com.bookstore.utilities.Globals;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CreateUser extends Globals {

    public void createUser() {
        username = new Faker().name().username();
        password = "Test.!123" + new Faker().internet().password();

        Map<String,Object> map = new HashMap<>();
        map.put("userName", username);
        map.put("password", password);

        String jsonBody = "{\n" +
                "  \"userName\": \"" + username + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";

        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .when()
                .post("/Account/v1/User")
                .prettyPeek();
    }

    public void validateThatUserIsPosted() {
        //validate status code
        Assert.assertEquals(201, response.statusCode());

        //validate username
        Assert.assertEquals(username, response.path("username"));

        //get userId from response payload
        userId = response.path("userID");
    }
}
