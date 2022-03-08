package com.epam.jwd.database;

import com.epam.jwd.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UsersDatabase {

    private final Map<String, User> usersMap = new HashMap<>();

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void addUser(User user) {
        usersMap.put(user.getEmail(), user);
    }

    public boolean isUserExist(String email){
        return usersMap.containsKey(email);
    }
}
