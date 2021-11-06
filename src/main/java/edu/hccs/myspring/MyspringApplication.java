package edu.hccs.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyspringApplication {

	private static void extracted(ConfigurableApplicationContext context) {
		Book book = context.getBean(Book.class);
		book.setTitle("Managing Yourself");
		book.setNoOfPages(23);

		Author author = context.getBean(Author.class);
		author.setName("David");
		author.setEmail("davaid@gmail.com");
		author.setGender("Male");

		Author author2 = context.getBean(Author.class);
		author2.setName("Sam");
		author2.setEmail("sam@gmail.com");
		author2.setGender("Male");

		List<Author> authors = new ArrayList(0);
		authors.add(author);
		authors.add(author2);

		book.setAuthors(authors);

		System.out.printf(book.toString());
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyspringApplication.class, args);
		extracted(context);

	}



}
