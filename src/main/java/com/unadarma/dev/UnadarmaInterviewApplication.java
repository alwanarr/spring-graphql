package com.unadarma.dev;

import com.unadarma.dev.entity.Author;
import com.unadarma.dev.entity.Book;
import com.unadarma.dev.repository.AuthorRepository;
import com.unadarma.dev.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnadarmaInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnadarmaInterviewApplication.class, args);
	}


	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository,
										BookRepository bookRepository)
	{
		return args -> {
			Author jhos = authorRepository.save(new Author("jhos"));
			Author dale = authorRepository.save(new Author("dale carnegie"));

			bookRepository.save(new Book("bintang kejora", 1, jhos));
			bookRepository.save(new Book("how to win friends and influence people", 1, dale));
		};
	}
}
