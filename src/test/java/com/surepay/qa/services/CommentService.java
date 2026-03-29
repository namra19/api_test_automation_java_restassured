package com.surepay.qa.services;

import com.surepay.qa.models.Comment;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

// Service class to handle API calls related to Comments
public class CommentService extends BaseService {

    public Response getCommentsResponseByPostId(int postId) {
        return get("/comments?postId=" + postId);
    }

    public List<Comment> getCommentsByPostId(int postId) {
        return Arrays.asList(getCommentsResponseByPostId(postId).as(Comment[].class));
    }
}