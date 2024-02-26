package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken extends Globals {

    public void generateToken() {
        Map<String,Object> map = new HashMap<>();
        map.put("userName", username);
        map.put("password", password);

        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .when()
                .post("/Account/v1/GenerateToken")
                .prettyPeek();
    }

    public void validateThatTokenIsGenerated() {
        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //verify status and result
        Assert.assertEquals("Success", response.path("status"));
        Assert.assertEquals("User authorized successfully.", response.path("result"));

        //get token from response payload
        token = response.path("token");
    }

}
