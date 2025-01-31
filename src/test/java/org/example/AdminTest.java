package org.example;

import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AdminTest {
    private JAXBContext adminContext;
    private JAXBContext booksContext;

    @Before
    public void init() throws JAXBException {
        this.adminContext = JAXBContext.newInstance(Admin.class);
        this.booksContext = JAXBContext.newInstance(Book.class);
    }

    @Test
    public void adminSerialisation() throws JAXBException{
        Marshaller marshaller = this.adminContext.createMarshaller();
        marshaller.marshal((new Admin("ADMIN ROLE", 2)), new File("userData.xml"));

        Unmarshaller unmarshaller = this.adminContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(new File("userData.xml"));
        System.out.println("unmarshalled = " + unmarshalled);
    }

//    @Test
//    public void booksSerialisation() throws JAXBException {
//        HashMap<Integer, Library> books = new HashMap<>();
//
//        Unmarshaller unmarshaller = this.booksContext.createUnmarshaller();
//
//        Library libraryList = (Library) unmarshaller.unmarshal(new File("books.xml"));
//
//        Library book = new Library(libraryList.getBookNum(), libraryList.getBookTitle(), libraryList.isBooksAvailable());
//        books.put(libraryList.getBookNum(),book);
//
//        for (Integer i : books.keySet()) {
//            System.out.println("key: " + i + " value: " + books.get(i));
//
//        }
    }
