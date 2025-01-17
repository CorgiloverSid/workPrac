package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws JAXBException {
        HashMap<String, User> users = new HashMap<>();

        Scanner libUser = new Scanner(System.in);
        System.out.println("Welcome to YOUR-Library! " + "\n" + "Please make your username: ");
        String userName = libUser.nextLine();
//        System.out.println("Your username is, " + userName);

        System.out.println("Enter your email: ");
        String userEmail = libUser.nextLine();

        System.out.println("Enter your age: ");
        int userAge = libUser.nextInt();
//        System.out.println("Your age is " + userAge);

        User user1 = new User(userName, userEmail, userAge);
        users.put(userName, user1);

        UserAccount userAcc = new UserAccount();
        userAcc.getUserInfo(user1);

//
//        System.out.println("Welcome to YOUR-Library! " + "\n" + "Please make your username: ");
//
//        String nextLine = libUser.nextLine();
//        String userName2 = libUser.nextLine();
//
//        System.out.println("Enter your email: ");
//        String userEmail2 = libUser.nextLine();
//
//        System.out.println("Enter your age: ");
//        int userAge2 = libUser.nextInt();
//        System.out.println("Your age is " + userAge2);
//
//        User user2 = new User(userName2, userEmail2, userAge2);
//        users.put(userName2, user2);

        for (String i : users.keySet()) {
            System.out.println("key: " + i + " value: " + users.get(i));

        }
    }
}