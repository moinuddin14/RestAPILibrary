package com.restapi.dropbox;


import com.restapi.dropbox.config.BasePath;
import com.restapi.dropbox.utils.RestUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFolderTest {

    RestUtil restUtil;

    @BeforeClass
    public void setUp(){
        RestAssured.basePath= BasePath.DELETE;
        restUtil=new RestUtil("restapi.demo");
    }

    @Test
    public void deleteFolder(){
        System.out.println("Starting Delete Folder!");
        Response response=restUtil.Post("{\"path\": \"/Homework/science\"}");
        System.out.println(response.getBody().asString());
    }
}