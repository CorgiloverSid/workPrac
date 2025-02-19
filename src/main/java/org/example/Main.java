package org.example;

import javax.print.DocFlavor;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws JAXBException {
//        HashMap<String, User> users = new HashMap<>();
//
//        Scanner libUser = new Scanner(System.in);
//        System.out.println("Welcome to YOUR-Library! " + "\n" + "Please make your username: ");
//        String userName = libUser.nextLine();
////        System.out.println("Your username is, " + userName);
//
//        System.out.println("Enter your email: ");
//        String userEmail = libUser.nextLine();
//
//        System.out.println("Enter your age: ");
//        int userAge = libUser.nextInt();
////        System.out.println("Your age is " + userAge);
//
//        User user1 = new User(userName, userEmail, userAge);
//        users.put(userName, user1);
//
//        UserAccount userAcc = new UserAccount();
//        userAcc.getUserInfo(user1);

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

//        for (String i : users.keySet()) {
//            System.out.println("key: " + i + " value: " + users.get(i));
//
//        }
        HashMap<Integer, Book> books = new HashMap<>();

        Book book1 = new Book();
        book1.setBookNum(1);
        book1.setBookTitle("Harry");
        book1.setBookAvailable(false);

        Book book2 = new Book();
        book2.setBookNum(2);
        book2.setBookTitle("Barry");
        book2.setBookAvailable(true);

        books.put(book1.getBookNum(), book1);
        books.put(book2.getBookNum(), book2);

        Library library = new Library();
        library.setBookInfo(books);

        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(library, new File("books.xml"));

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Library serialisedBooks = (Library) jaxbUnmarshaller.unmarshal( new File("books.xml") );
        System.out.println(serialisedBooks);
        System.out.println("GOT FROM SENT BACK OBJ " + serialisedBooks.getBookInfo());

        for(Integer bookNo : serialisedBooks.getBookInfo().keySet())
        {
            System.out.println(serialisedBooks.getBookInfo().get(bookNo).getBookTitle());
            System.out.println(serialisedBooks.getBookInfo().get(bookNo).getBookTitle());
        }

        for (Integer i : books.keySet()) {
            System.out.println("key: " + i + " value: " + books.get(i));

            }

        }














//        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
//        Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
//        Library serialisedBooks = (Library) jaxUnmarshaller.unmarshal(new File("books.xml"));
//
//        for(Integer x : serialisedBooks.getBookInfo().keySet())
//        {
//            System.out.println(serialisedBooks.getBookInfo().get(x).getBookNum());
//        }


    }