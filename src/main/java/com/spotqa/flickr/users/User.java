package com.spotqa.flickr.users;

public class User {

    private String userName;
    private String userPwd;
    private String appKey; //consumerkey in flickr
    private String appSecret; //consumerSecret in flickr
    private String accessToken; //accessToken in flickr
    private String secretToken;
    private String api_key; //api_key in flickr

    public User(String userName, String userPwd, String appKey,
                String appSecret, String accessToken, String secretToken, String api_key) {
        //super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
        this.secretToken = secretToken;
        this.api_key = api_key;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String authToken) {
        this.accessToken = authToken;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

}
