package com.restapi.flickr;

import com.restapi.flickr.helpers.ReadConfigFile;
import java.io.IOException;

/**
 * Created by Khaja on 11/4/16.
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
        System.out.println(ReadConfigFile.readConfigFileImpl().getFormat());
        System.out.println(ReadConfigFile.readConfigFileImpl().getcomment_text());
        System.out.println(ReadConfigFile.readConfigFileImpl().getUserName());
        System.out.println(ReadConfigFile.readConfigFileImpl().getAppKey());
        System.out.println(ReadConfigFile.readConfigFileImpl().getAppSecret());
    }
}