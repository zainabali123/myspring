package edu.hccs.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyspringApplication {

	private static void extracted(ConfigurableApplicationContext context) throws IOException {

		BookController bookController = context.getBean(BookController.class);
		System.out.println(" books "+ bookController.readData());
	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(MyspringApplication.class, args);
		extracted(context);

	}
}
