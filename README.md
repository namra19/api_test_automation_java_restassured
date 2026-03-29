# api_test_automation_java_restassured

QA Automation Framework - JSONPlaceholder API
Overview

This project is a Java REST-assured test automation framework designed to validate the comments workflow for posts created by the user “Delphine” in JSONPlaceholder.

## The framework demonstrates:

* API testing using RestAssured
* Modular service classes for User, Post, and Comment
* Email validation for comment emails
* Positive and negative test scenarios
* Clean code following SOLID, DRY, KISS principles

## Project Structure
```
src/test/java/com/surepay/qa
│
├── base       → BasePage setup
├── models     → POJOs: User, Post, Comment
├── services   → BaseService and entity services
├── utils      → Email validation helper
└── tests      → TestNG test classes (positive and negative scenarios)
```

## Test Workflow
* Positive Test
* Fetch user by username Delphine.
* Fetch all posts by the user.
* Fetch comments for each post.
* Validate that all comment emails are in proper format.

## Negative Tests
* User not found
* Posts not found for a user
* No comments on a post
* Invalid API endpoints
* Invalid email formats

## Pre-requisites

* Java JDK 17+ – Ensure JAVA_HOME is set - java -version

* Maven 3.8+ – Required to build and run tests - mvn -v

## How to Run
1. Clone the repository: https://github.com/namra19/api_test_automation_java_restassured.git
2. Run tests via Maven: mvn clean test
3. Test reports are available in - target/surefire-reports (emailable-report.html)

## Tools & Libraries
* Java 17
* Maven
* TestNG
* RestAssured
* CircleCI (CI/CD)

## CI/CD with CircleCI

This project is integrated with CircleCI for automated test execution on every commit.

* CircleCI Dashboard: [View Pipelines](https://app.circleci.com/pipelines/github/namra19)
* Tests are automatically triggered on push to GitHub.
* Reports are generated in target/surefire-reports (emailable-report.html).

## Future Improvements
* Integrate Allure/ExtentReports for visual test reporting
* JaCoCo to measire code coverage
* Parameterize username and endpoints via config files
* Extend BaseService with generic methods for easier reuse
* Add retry mechanism for flaky API calls