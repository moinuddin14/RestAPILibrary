package com.spotqa.dropbox;


import com.spotqa.dropbox.config.BasePath;
import com.spotqa.dropbox.utils.RestUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateFolderTest {

    RestUtil restUtil;

    @BeforeClass
    public void setUp(){
        RestAssured.basePath= BasePath.CREATE_FOLDER;
        restUtil=new RestUtil("spotqa.demo");
    }

    @Test
    public void createFolder(){
        Response response=restUtil.Post("{\"path\": \"/Homework/science\",\"autorename\": false}");
        System.out.println(response.getBody().asString());
    }

}
