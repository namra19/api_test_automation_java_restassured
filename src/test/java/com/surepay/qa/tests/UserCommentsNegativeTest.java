package com.surepay.qa.tests;

import com.surepay.qa.base.BasePage;
import com.surepay.qa.models.Comment;
import com.surepay.qa.models.Post;
import com.surepay.qa.models.User;
import com.surepay.qa.services.CommentService;
import com.surepay.qa.services.PostService;
import com.surepay.qa.services.UserService;
import com.surepay.qa.utils.EmailUtils;

import io.restassured.response.Response;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Test class for negative scenarios
public class UserCommentsNegativeTest extends BasePage {

    // User Not Found
    @Test
    public void shouldReturnNullWhenUserNotFound() {
        User user = new UserService().getUserByUsername("UnknownUser");

        Assert.assertNull(user);
    }

    // No Post
    @Test
    public void shouldReturnEmptyPosts() {
        List<Post> posts = new PostService().getPostsByUserId(9999);

        Assert.assertTrue(posts.isEmpty());
    }

    // No Comments
    @Test
    public void shouldReturnEmptyComments() {
        List<Comment> comments = new CommentService().getCommentsByPostId(9999);

        Assert.assertTrue(comments.isEmpty());
    }

    // Invalid Endpoint (API Failure)
    @Test
    public void shouldHandleApiFailure() {
        Response response = new PostService().get("/invalid");

        Assert.assertTrue(response.statusCode() >= 400);
    }

    //Email Edge Cases
    @DataProvider(name = "invalidEmails")
public Object[][] invalidEmails() {
    return new Object[][]{
            {"test@"},
            {"@domain.com"},
            {"test.com"},
            {""},
            {null}
    };
}

@Test(dataProvider = "invalidEmails")
public void shouldRejectInvalidEmails(String email) {
    Assert.assertFalse(EmailUtils.isValidEmail(email));
}
}
