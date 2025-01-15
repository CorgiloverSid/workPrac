package org.example;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String toString() {
        return this.name + " " + this.email + " " + this.age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
