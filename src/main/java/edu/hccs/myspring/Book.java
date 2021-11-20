package edu.hccs.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Book {
    private String title;
    private int noOfPages;
//    @Autowired
    List<Author> authors;
    private Publisher publisher;

    public Book() {
        System.out.println("I am in constructor");
    }

    public Book(String title, int noOfPages, List<Author> authors, Publisher publisher) {
        this.title = title;
        this.noOfPages = noOfPages;
        this.authors = authors;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", noOfPages=" + noOfPages +
                ", authors=" + authors +
                '}';
    }
}
