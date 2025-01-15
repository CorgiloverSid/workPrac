package org.example;

import java.util.HashMap;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        HashMap<String, User> users = new HashMap<>();

        Scanner libUser = new Scanner(System.in);
        System.out.println("Welcome to YOUR-Library! " + "\n" + "Please make your username: ");

        String userName = libUser.nextLine();
        System.out.println("Your username is, " + userName);

        System.out.println("Enter your email: ");
        String userEmail = libUser.nextLine();

        System.out.println("Enter your age: ");
        int userAge = libUser.nextInt();
        System.out.println("Your age is " + userAge);

        User user1 = new User(userName, userEmail, userAge);
        users.put(userName, user1);

        for (String i : users.keySet()) {
            System.out.println("key: " + i + " value: " + users.get(i));

        }
        System.out.println(users);
    }
}