package com.surepay.qa.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseService {

    public Response get(String endpoint) {
        return RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}