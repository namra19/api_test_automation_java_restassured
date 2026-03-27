package com.surepay.qa.services;

import com.surepay.qa.models.Comment;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class CommentService {

    public List<Comment> getCommentsByPostId(int postId) {
        Response response = RestAssured.get("/comments?postId=" + postId);
        return Arrays.asList(response.getBody().as(Comment[].class));
    }
}