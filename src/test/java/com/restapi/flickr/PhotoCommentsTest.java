package com.restapi.flickr;

import com.restapi.flickr.config.BasePath;
import com.restapi.flickr.helpers.ReadConfigFile;
import com.restapi.flickr.utils.RestUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PhotoCommentsTest {

    RestUtil restUtil;
    Map<String, String> map;
    String expectedComment = Data.expectedComment;
    String wrongComment = Data.wrongComment;

    @BeforeClass
    public void setUp(){
        map=new HashMap<String, String>();
        map.put(FlickrData.method, BasePath.Photos.comments.ADD_COMMENT);
        //map.put("method", BasePath.Photos.comments.ADD_COMMENT);
        System.out.println("Setting up for the endpoint - "+BasePath.Photos.comments.ADD_COMMENT);
        restUtil=new RestUtil(FlickrData.userName);
    }

    @Test
    public void addingComment(){

        map.put(FlickrData.commentText, ReadConfigFile.readConfigFileImpl().getcomment_text());
        map.put(FlickrData.photoId,ReadConfigFile.readConfigFileImpl().getphoto_id());
        //map.put("method","flickr.photos.comments.addComment");

        Response response=restUtil.Post(map);
        System.out.println(response.getBody().asString());
        System.out.println("The comment is updated by --- " +response.getBody().path(Paths.commentAuthorname));
        Assert.assertEquals(Data.user, response.getBody().path(Paths.commentAuthorname));
        System.out.println("Yes! Expected vs Actual author is same!");

        System.out.println(response.getBody().path(FlickrData.commentContent));
        Assert.assertEquals(expectedComment, response.getBody().path(FlickrData.commentContent));
        System.out.println("Assert for the content has passed!");

        ReadConfigFile readConfigFile = new ReadConfigFile();
        System.out.println(readConfigFile.getAccessToken());
    }

    @Test
    public void addingWrongComment(){

        map.put(FlickrData.commentText, ReadConfigFile.readConfigFileImpl().getcomment_text());
        map.put(FlickrData.photoId,ReadConfigFile.readConfigFileImpl().getphoto_id());

        Response response=restUtil.Post(map);
        System.out.println(response.getBody().asString());
        System.out.println("The comment is updated by --- " +response.getBody().path(Paths.commentAuthorname));
        Assert.assertEquals(expectedComment, response.getBody().path(Paths.commentAuthorname));
        System.out.println("Yes! Expected vs Actual author is same!");

        System.out.println(response.getBody().path(FlickrData.commentContent));
        Assert.assertEquals(wrongComment, response.getBody().path(FlickrData.commentContent));
        System.out.println("Assert for the content has passed!");

        ReadConfigFile readConfigFile = new ReadConfigFile();
        System.out.println(readConfigFile.getAccessToken());
    }

    @Test(alwaysRun = false)
    public void addingSkipComment(){
        System.out.println("This Test Case Will Be Skipped!");

        if(2 == 2)
            throw new SkipException("Skipping this exception");

        map.put(FlickrData.commentText, ReadConfigFile.readConfigFileImpl().getcomment_text());
        map.put(FlickrData.photoId,ReadConfigFile.readConfigFileImpl().getphoto_id());

        Response response=restUtil.Post(map);
        System.out.println(response.getBody().asString());
        System.out.println("The comment is updated by --- " +response.getBody().path(Paths.commentAuthorname));
        Assert.assertEquals(expectedComment, response.getBody().path(Paths.commentAuthorname));
        System.out.println("Yes! Expected vs Actual author is same!");

        System.out.println(response.getBody().path(FlickrData.commentContent));
        Assert.assertEquals(expectedComment, response.getBody().path(FlickrData.commentContent));
        System.out.println("Assert for the content has passed!");

        ReadConfigFile readConfigFile = new ReadConfigFile();
        System.out.println(readConfigFile.getAccessToken());


        if(response.getBody().path(FlickrData.commentContent).toString().equalsIgnoreCase(expectedComment))
            throw new SkipException("Skipping this exception");
    }
}