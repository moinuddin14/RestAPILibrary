package com.restapi.dropbox.users;


import java.util.HashMap;
import java.util.Map;

public class TestUsers {

    public Map<String, User> userMap = new HashMap<String, User>();{
        // String userName, userPwd, appKey,appSecret, accessToken
        userMap.put("restapi.demo-prod",new User("", "", "restapi.demo", "spotqa123", "5hc0pjqf350q6wt", "mrwdrlvehlht6ad", "PgtYULV__ZAAAAAAAAAACdO1F2tIs33S1J-xRR7CNN_M74ZtRCi3PCLGoPNT4MtF"));
        userMap.put("restapi.demo-qa",new User("", "", "restapi.demo", "spotqa123", "5hc0pjqf350q6wt", "mrwdrlvehlht6ad", "PgtYULV__ZAAAAAAAAAACdO1F2tIs33S1J-xRR7CNN_M74ZtRCi3PCLGoPNT4MtF"));

    }
}