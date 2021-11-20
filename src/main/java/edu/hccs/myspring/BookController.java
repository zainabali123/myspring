package edu.hccs.myspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    /**
     *   URL :  http://localhost:8080/books
      * @return all books
     * @throws IOException
     */
    @GetMapping("/books")
    public List<Book>  books() throws IOException {
        return readData();
    }

    /***
     * http://localhost:8080/book/Algorithms Illuminated - Part 3
     * @param title
     * @return Book
     * @throws IOException
     */
    @GetMapping("/book/{title}")
    public Book  book(@PathVariable String title) throws IOException {
        System.out.println("search book by title : "+title);
        List<Book>  books = readData();
        for(Book book : books){
            if( book.getTitle().equalsIgnoreCase(title)){
                System.out.println("found book "+book);
                return book;
            }
        }
        System.out.println(" No book found for title "+title);
        return null;
    }

//  http://localhost:8080/book?title=Algorithms Illuminated - Part 3&author=Tim Roughgarden
    @GetMapping("/book")
    public Book  book(@RequestParam String title, @RequestParam String author) throws IOException {
        System.out.println("search book by title : "+title+" author : "+author);
        List<Book>  books = readData();
        for(Book book : books){
            if( book.getTitle().equalsIgnoreCase(title) & book.getAuthors().get(0).getName().equalsIgnoreCase(author)){
                System.out.println("found book "+book);
                return book;
            }
        }
        System.out.println(" No book found for title "+title);
        return null;
    }


    /***
     * Read the book.txt file
     * @return all the books
     * @throws IOException
     */
    public List<Book> readData() throws IOException {
        FileReader fileReader = new FileReader("/Users/dawitgebremichael/hcc/advance java/myspring/src/main/resources/book.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Book> bookList = new ArrayList();
        List<Author> authors = new ArrayList();

        String header = bufferedReader.readLine(); // read the header
        String line = bufferedReader.readLine(); // read the first line

        while ( line != null){
            String[] data = line.split(",");// split each read line by comma
            Author author = new Author(data[2]);
            authors.add(author);
            Book book = new Book(data[0],Integer.parseInt(data[1]),authors, null);
            bookList.add(book);
            line = bufferedReader.readLine();
            authors = new ArrayList();
        }
        return bookList;
    }
}
