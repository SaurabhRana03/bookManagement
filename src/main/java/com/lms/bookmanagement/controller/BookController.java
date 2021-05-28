package com.lms.bookmanagement.controller;

import com.lms.bookmanagement.exceptions.BookNotFoundException;
import com.lms.bookmanagement.exceptions.CategoryNotFoundException;
import com.lms.bookmanagement.model.Book;
import com.lms.bookmanagement.model.Categories;
import com.lms.bookmanagement.repository.BookRepository;
import com.lms.bookmanagement.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BookController {

    private final BookRepository bookRepository;

    private final CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Categories> getAllcategories() {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Categories Listed shown");

        return (List<Categories>) categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public  Categories createCategories(@Valid @RequestBody Categories category) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info :  The Categories has been Listed");

      // Categories createCategories = categoryRepository.saveAll();
        categoryRepository.save(category);

        return categoryRepository.save(category);
    }
    @GetMapping("/categories/{id}")
    public Categories getCategoriesById(@PathVariable(value = "id") Long categoriesId) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Categories Listed with given id");


            return categoryRepository.findById(categoriesId).orElseThrow(
                    () -> new CategoryNotFoundException("Categories", "id", categoriesId));
        }

    @PutMapping("/categories/{id}")
    public Categories updateCategories(@PathVariable(value = "id") Long categoriesId,
                           @Valid @RequestBody Categories categoriesDetails) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Categories Updated with given id");

        categoryRepository.findById(categoriesId).orElseThrow(() -> new CategoryNotFoundException("Categories", "id", categoriesId));

        categoriesDetails.setId(categoriesId);
        Categories updateCategories = categoryRepository.save(categoriesDetails);
        return updateCategories;
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable(value = "id") Long categoriesId) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Categories Listed with given id has been deleted");

        Categories categories = categoryRepository.findById(categoriesId).orElseThrow(() -> new CategoryNotFoundException("Category", "id", categoriesId));

        categoryRepository.delete(categories);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/book")
    public List<Book> getAllBooks() {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Books Listed shown");

        return (List<Book>) bookRepository.findAll();


    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book book) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Books created ");

        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Books Listed with given id");

        return bookRepository.findById(bookId).orElseThrow(
                () -> new BookNotFoundException("Book", "id", bookId));
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Books Updated with given id");

        bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

        bookDetails.setId(bookId);
        Book updateBook = bookRepository.save(bookDetails);
        return updateBook;
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("logging Info : All The Books Deleted with given id");
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }


}

