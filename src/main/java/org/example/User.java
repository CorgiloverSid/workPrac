package org.example;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class User {
    private String userName;
    private String email;
    private int age;

    public User(String userName, String email, int age) {
        this.userName = userName;
        this.email = email;
        this.age = age;
    }

    public String toString() {
        return this.userName + " " + this.email + " " + this.age;
    }

    public void createUser() {

        Scanner libUser = new Scanner(System.in);
        System.out.println("Welcome to YOUR-Library! " + "\n" + "Please make your username: ");

        String userName = libUser.nextLine();
        System.out.println("Your username is, " + userName);

        System.out.println("Enter your age: ");
        int userAge = libUser.nextInt();

        System.out.println("Your age is " + userAge);

    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return age;
    }

    public void setPhone(int phone) {
        this.age = phone;
    }
}
