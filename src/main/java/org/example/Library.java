package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Library {
    private HashMap<Integer, Book> bookInfo = new HashMap<>();

    public HashMap<Integer, Book> getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(HashMap<Integer, Book> bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Library() {

    }

    @Override
    public String toString() {
        return "Library{" +
                "bookInfo=" + bookInfo +
                '}';
    }
}
