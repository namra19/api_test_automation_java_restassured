package com.surepay.qa.utils;

import java.util.regex.Pattern;

// Utility class for email validation
public class EmailUtils {

    // Regex pattern for basic email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    // Returns true if email is valid, false otherwise
    public static boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && pattern.matcher(email).matches();
    }
}