package com.surepay.qa.services;

import com.surepay.qa.models.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class UserService {

    public List<User> getAllUsers() {
        Response response = RestAssured.get("/users");
        return Arrays.asList(response.getBody().as(User[].class));
    }

    public User getUserByUsername(String username) {
        return getAllUsers().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }
}