package com.lms.bookmanagement.controller;

import com.lms.bookmanagement.exceptions.BookNotFoundException;
import com.lms.bookmanagement.exceptions.CategoryNotFoundException;
import com.lms.bookmanagement.model.Book;


import com.lms.bookmanagement.model.Categories;
import com.lms.bookmanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("All the available Books Shown");

        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book book) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Book details created");
        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("All the available Books with given Id Shown");

        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Book details UPDATED");

        if (bookRepository.findById(bookId).isPresent() == false) {
            logger.error("Book by given Id Not Found");

            throw new BookNotFoundException("Book", "id", bookId);
        }
        bookDetails.setId(bookId);
        Book updateBook = bookRepository.save(bookDetails);
        return updateBook;
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Book details Deleted");

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}