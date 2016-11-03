package com.spotqa.flickr.config;

/**
 * Created by s0v0023 on 11/2/16.
 */
public class BaseURI {

    public final static String QA="https://qa-api.dropboxapi.com/2";
    public final static String PROD="https://api.dropboxapi.com/2";

    public static String getBaseURI(){
        String environment = System.getProperty("env").toUpperCase();
        String baseURI=null;
        if(environment.equalsIgnoreCase("QA")){
            baseURI=QA;
        }else if(environment.equalsIgnoreCase("PROD")){
            baseURI=PROD;
        }
        return baseURI;
    }

}
