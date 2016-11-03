package com.spotqa.flickr.users;

public class User {

    private String userName;
    private String userPwd;
    private String appKey;
    private String appSecret;
    private String accessToken;

    public User(String userName, String userPwd, String appKey, String appSecret, String accessToken) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
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

    public void setAppSecret(String apiSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String authToken) {
        this.accessToken = authToken;
    }

}
