package com.surepay.qa.services;

import com.surepay.qa.models.Post;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class PostService extends BaseService {

    public Response getPostsResponseByUserId(int userId) {
        return get("/posts?userId=" + userId);
    }

    public List<Post> getPostsByUserId(int userId) {
        return Arrays.asList(getPostsResponseByUserId(userId).as(Post[].class));
    }
}