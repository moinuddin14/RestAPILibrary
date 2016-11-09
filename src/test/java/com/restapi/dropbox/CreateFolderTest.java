package com.restapi.dropbox;


import com.restapi.dropbox.config.BasePath;
import com.restapi.dropbox.utils.RestUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateFolderTest {

    RestUtil restUtil;

    @BeforeClass
    public void setUp(){
        RestAssured.basePath= BasePath.CREATE_FOLDER;
        restUtil=new RestUtil("restapi.demo");
    }

    @Test
    public void createFolder(){
        Response response=restUtil.Post("{\"path\": \"/Homework/science\",\"autorename\": true}");
        System.out.println(response.getBody().asString());
        System.out.println("Has the folder really being created!");
        System.out.println(response.getBody().path("name").toString());
        System.out.println("Wow! it did!");
    }
}