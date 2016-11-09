package com.restapi.flickr.helpers;

import java.io.*;
import java.util.Properties;

/**
 * Created by Khaja on 11/7/16.
 */
public class ReadConfigFile {

    public  Properties prop;
    public  InputStream inputStream;

    public ReadConfigFile(){
        prop = new Properties();

        //String in = ReadConfigFile.class.getClassLoader().getResource("./com/restapi/res/config.properties").getPath();
        //String str = in.replace("/out/test/test", "/src/test/java");

        try {
            inputStream = new FileInputStream(new File(System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"config.properties"));
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadConfigFile readConfigFileImpl(){
        return new ReadConfigFile();
    }

    public String getUserName(){
        if(prop.getProperty("userName")==null)
            return "";
        return prop.getProperty("userName");
    }

    public String getUserPwd(){
        if(prop.getProperty("userPwd")==null)
            return "";
        return prop.getProperty("userPwd");
    }

    public String getAppKey(){
        if(prop.getProperty("appKey")==null)
            return "";
        return prop.getProperty("appKey");
    }

    public String getAppSecret(){
        if(prop.getProperty("appSecret")==null)
            return "";
        return prop.getProperty("appSecret");
    }

    public String getAccessToken(){
        if(prop.getProperty("accessToken")==null)
            return "";
        return prop.getProperty("accessToken");
    }

    public String getSecretToken(){
        if(prop.getProperty("secretToken")==null)
            return "";
        return prop.getProperty("secretToken");
    }

    public String getApikey(){
        if(prop.getProperty("api_key")==null)
            return "";
        return prop.getProperty("api_key");
    }

    public String getFormat(){
        return prop.getProperty("format");
    }

    public String getNoJsonCallback(){
        return prop.getProperty("nojsoncallback");
    }

    public String getphoto_id(){
        if(prop.getProperty("photo_id")==null)
            return "";
        return prop.getProperty("photo_id");
    }

    public String getcomment_text(){
        if(prop.getProperty("comment_text")==null)
            return "";
        return prop.getProperty("comment_text");
    }
}