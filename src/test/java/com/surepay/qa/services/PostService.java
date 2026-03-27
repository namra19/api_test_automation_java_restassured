package com.surepay.qa.services;

import com.surepay.qa.models.Post;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

public class PostService {

    public List<Post> getPostsByUserId(int userId) {
        Response response = RestAssured.get("/posts?userId=" + userId);
        return Arrays.asList(response.getBody().as(Post[].class));
    }
}