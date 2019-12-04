package com.service;

import java.util.HashMap;
import java.util.Map;

public class UserList {

    static private Map<String, String> userList = new HashMap<>();

        static {
        userList.put("admin","7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
    }

    public static Map<String, String> getUserList() {
        return userList;
    }

    public void setUserList(String login, String shaPass){
        userList.put(login,shaPass);
    }
}
