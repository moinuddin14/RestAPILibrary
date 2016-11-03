package com.spotqa.dropbox.utils;


import com.spotqa.dropbox.config.BaseURI;
import com.spotqa.dropbox.users.TestUsers;
import com.spotqa.dropbox.users.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;
public class RestUtil {

    RequestSpecBuilder requestSpecBuilder;
    RequestSpecification requestSpecification;

    public RestUtil(String username){
        String environment = System.getProperty("env").toLowerCase();
        TestUsers users=new TestUsers();
        User user=users.userMap.get(username+"-"+environment);

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI= BaseURI.getBaseURI();

        requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Content-Type", ContentType.JSON.toString());
        //Authentication
        requestSpecBuilder.addHeader("Authorization","Bearer "+user.getAccessToken());
        requestSpecification=requestSpecBuilder.build();
    }

    public Response Post(String requestBody){
        Response response=given().spec(requestSpecification).body(requestBody).post();
        return response;
    }

    public Response Post(String endPoint,String requestBody,Map<String,String> headers){
        Response response=given().spec(requestSpecification).headers(headers).body(requestBody).post(endPoint);
        return response;
    }

    public Response Post(String endPoint,String requestBody){
        Response response=given().spec(requestSpecification).body(requestBody).post(endPoint);
        return response;
    }
}
