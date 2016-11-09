package com.restapi.flickr.utils;

import com.restapi.flickr.config.BaseURI;
import com.restapi.flickr.helpers.ReadConfigFile;
import com.restapi.flickr.users.TestUsers;
import com.restapi.flickr.users.User;
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
    public Map<String, String> map;
    public User user;
    public TestUsers users;
    public RestUtil(){

    }

    /**
     * @param username This should be in a standard format (ex: restapi.demo)
     */
    public RestUtil(String username){
        String environment = System.getProperty("env").toLowerCase();
        users=new TestUsers();
        user=users.userMap.get(username+"-"+environment);

        RestAssured.useRelaxedHTTPSValidation();

        requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BaseURI.getBaseURI());

        map = new LinkedHashMap<String, String>();
        System.out.println("Creating the map");
        map.put("format", ReadConfigFile.readConfigFileImpl().getFormat());
        map.put("nojsoncallback", ReadConfigFile.readConfigFileImpl().getNoJsonCallback());
        System.out.println(user.getApi_key());
        map.put("api_key", user.getApi_key());
        //map.put("api_key", "2a687ef65c380e63590250c2556bf36f");
        System.out.println("Added the Map");
        //https://api.flickr.com/services/rest?format=json&nojsoncallback=1&api_key=2a687ef65c380e63590250c2556bf36f&comment_text=hoola_test&method=flickr.photos.comments.addComment&photo_id=29961687633

        requestSpecBuilder.addQueryParams(map);
        requestSpecification=requestSpecBuilder.build();

        authenticationSpecification = new AuthenticationSpecificationImpl(requestSpecification);
        authenticationSpecification.oauth(user.getAppKey(),
                user.getAppSecret(),
                user.getAccessToken(),
                user.getSecretToken());
    }

    public Response Post(Map<String, String> queryParams){
        Response response=given().spec(requestSpecification).queryParams(queryParams).post();
        return response;
    }

    public Response Post(String endPoint,String requestBody,Map<String,String> headers) {
        Response response = given().spec(requestSpecification).headers(headers).body(requestBody).post(endPoint);
        return response;
    }

    public Response Post(String endPoint,String requestBody) {
        Response response=given().spec(requestSpecification).body(requestBody).post(endPoint);
        return response;
    }
}
