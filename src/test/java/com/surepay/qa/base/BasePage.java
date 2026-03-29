package com.surepay.qa.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BasePage {

  @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    
}
