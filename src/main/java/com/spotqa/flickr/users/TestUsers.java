package com.spotqa.flickr.users;

import java.util.HashMap;
import java.util.Map;

public class TestUsers {

    public Map<String, User> userMap = new HashMap<String, User>();{
        // String userName, userPwd, appKey,appSecret, accessToken
        userMap.put("spotqa.demo-prod",new User("", "", "f41aa1380da1daa91e6f99e9af68c6ca",
                "f3fce6ab42a69e5b", "72157675710850186-683b6d39d595c2fd",
                "8ff6eacee9637bc4", "2a687ef65c380e63590250c2556bf36f"));
    }
}