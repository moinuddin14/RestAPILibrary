package com.spotqa.flickr.utils;

import com.spotqa.flickr.config.BaseURI;
import com.spotqa.flickr.users.TestUsers;
import com.spotqa.flickr.users.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.AuthenticationSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtil {

    public RequestSpecBuilder requestSpecBuilder;
    public RequestSpecification requestSpecification;
    public AuthenticationSpecification authenticationSpecification;

    Map<String, String> map;

    /**
     * @param username This should be in a standard format (ex: spotqa.demo)
     */
    public RestUtil(String username){
        String environment = System.getProperty("env").toLowerCase();
        TestUsers users=new TestUsers();
        User user=users.userMap.get(username+"-"+environment);
        System.out.println(user.getAccessToken());

        RestAssured.useRelaxedHTTPSValidation();
        //RestAssured.baseURI= BaseURI.getBaseURI();

        requestSpecBuilder=new RequestSpecBuilder();
        System.out.println(BaseURI.getBaseURI());
        requestSpecBuilder.setBaseUri(BaseURI.getBaseURI());

        map = new LinkedHashMap<String, String>();
        map.put("format", "rest");
        map.put("nojsoncallback", "1");
        map.put("api_key", user.getApi_key());

        requestSpecBuilder.addQueryParams(map);
        requestSpecification=requestSpecBuilder.build();

        authenticationSpecification = new AuthenticationSpecificationImpl(requestSpecification);
        authenticationSpecification.oauth(user.getAppKey(),
                user.getAppSecret(),
                user.getAccessToken(),
                user.getSecretToken());
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

    public Response Post(String endPoint, String requestBody1, String requestBody2){
        requestSpecBuilder.addQueryParam("method","flickr.photos.comments.addComment");
        Response response = given().spec(requestSpecBuilder.build()).body(requestBody1).body(requestBody2).post();
        return response;
    }
}
