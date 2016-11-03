package com.spotqa.flickr;

import com.spotqa.flickr.utils.RestUtil;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PhotoCommentsTest {

    RestUtil restUtil;

    @BeforeClass
    public void setUp(){
        System.out.println("Inside Before Class!");
        restUtil=new RestUtil("spotqa.demo");
    }

    @Test
    public void addingComment(){

        Response response=restUtil.Post("",
                "\"comment_text\": \"abc-hello\"", "\"photoset_id\": \"29961687633\"");
        System.out.println(response);
    }
}
