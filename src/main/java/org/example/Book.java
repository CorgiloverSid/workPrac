package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Book {
    private int bookNum;
    private String bookTitle;
    boolean bookAvailable;

    public Book() {

    }

    public Book(int bookNum, String bookTitle, boolean bookAvailable) {
        this.bookNum = bookNum;
        this.bookTitle = bookTitle;
        this.bookAvailable = bookAvailable;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isBookAvailable() {
        return bookAvailable;
    }

    public void setBookAvailable(boolean bookAvailable) {
        this.bookAvailable = bookAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNum=" + bookNum +
                ", bookTitle='" + bookTitle + '\'' +
                ", booksAvailable=" + bookAvailable +
                '}';
    }
}

