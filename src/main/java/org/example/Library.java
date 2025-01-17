package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Library {
    private int bookNum;
    private String bookTitle;
    boolean booksAvailable;

    public Library() {

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

    public boolean isBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(boolean booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public Library (int bookNum, String bookTitle, boolean booksAvailable) {
        this.bookNum = bookNum;
        this.bookTitle = bookTitle;
        this.booksAvailable = booksAvailable;

    }

    @Override
    public String toString() {
        return "Library{" +
                "bookNum=" + bookNum +
                ", bookTitle='" + bookTitle + '\'' +
                ", booksAvailable=" + booksAvailable +
                '}';
    }
}
