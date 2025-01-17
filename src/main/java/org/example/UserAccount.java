package org.example;

import java.util.AbstractMap;
import java.util.HashMap;

public class UserAccount {
    public void getUserInfo(User user) {
        HashMap<String, String> usersAccount = new HashMap<>();
        usersAccount.put(user.getUsername(), "Twilight");

        System.out.println(usersAccount.size());

        for (String i : usersAccount.keySet()) {
            System.out.println("user: " + i + " has the current books: " + usersAccount.get(user.getUsername()));

        }
    }
}
