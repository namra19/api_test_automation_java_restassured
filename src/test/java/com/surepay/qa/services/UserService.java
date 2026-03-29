package com.surepay.qa.services;

import com.surepay.qa.models.User;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

// Service class to handle API calls related to Users
public class UserService extends BaseService {

    public User getUserByUsername(String username) {
        return getAllUsers().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    // Fetch all users from API
    public Response getUsersResponse() {
        return get("/users");
    }

    public List<User> getAllUsers() {
        return Arrays.asList(getUsersResponse().as(User[].class));
    }
}