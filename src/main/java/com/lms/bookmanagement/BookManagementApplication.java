package com.lms.bookmanagement;

import com.lms.bookmanagement.repository.BookRepository;
import com.lms.bookmanagement.repository.BookRepositoryimpl;
import com.lms.bookmanagement.repository.CategoryRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
	}


}
