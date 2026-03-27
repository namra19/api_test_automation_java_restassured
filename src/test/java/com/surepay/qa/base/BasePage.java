package com.surepay.qa.base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BasePage {
      @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    
}
