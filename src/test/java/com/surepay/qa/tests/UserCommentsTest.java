package com.surepay.qa.tests;

import com.surepay.qa.base.BasePage;
import com.surepay.qa.models.Comment;
import com.surepay.qa.models.Post;
import com.surepay.qa.models.User;
import com.surepay.qa.services.CommentService;
import com.surepay.qa.services.PostService;
import com.surepay.qa.services.UserService;
import com.surepay.qa.utils.EmailUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Test class for validating comments workflow for a valid user
public class UserCommentsTest extends BasePage {

    UserService userService = new UserService();
    PostService postService = new PostService();
    CommentService commentService = new CommentService();

    @Test
    public void validateCommentsEmailsForDelphine() {
        // Step 1: Get user by username
        User user = userService.getUserByUsername("Delphine");
        Assert.assertNotNull(user, "User 'Delphine' should exist");

        // Step 2: Get posts by user
        List<Post> posts = postService.getPostsByUserId(user.getId());
        Assert.assertFalse(posts.isEmpty(), "User 'Delphine' should have posts");

        // Step 3: Validate emails in comments for each post
        for (Post post : posts) {
            List<Comment> comments = commentService.getCommentsByPostId(post.getId());
            for (Comment comment : comments) {
                Assert.assertTrue(
                        EmailUtils.isValidEmail(comment.getEmail()),
                        "Invalid email: " + comment.getEmail() + " in post ID " + post.getId()
                );
            }
        }
    }
}