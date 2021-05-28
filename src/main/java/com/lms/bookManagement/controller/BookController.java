package com.lms.bookManagement.controller;

import com.lms.bookManagement.exceptions.BookNotFoundException;
import com.lms.bookManagement.exceptions.CategoryNotFoundException;
import com.lms.bookManagement.model.Book;
import com.lms.bookManagement.model.Categories;
import com.lms.bookManagement.repository.BookRepository;
import com.lms.bookManagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Categories> getAllcategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public  Categories createCategories(@Valid @RequestBody Categories category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/categories/{id}")
    public Categories getCategoriesById(@PathVariable(value = "id") Long categoriesId) {
        return categoryRepository.findById(categoriesId).orElseThrow(
                () -> new CategoryNotFoundException("Categories", "id", categoriesId));
    }
    @PutMapping("/categories/{id}")
    public Categories updateCategories(@PathVariable(value = "id") Long categoriesId,
                           @Valid @RequestBody Categories categoriesDetails) {

        categoryRepository.findById(categoriesId).orElseThrow(() -> new CategoryNotFoundException("Categories", "id", categoriesId));

        categoriesDetails.setId(categoriesId);
        Categories updateCategories = categoryRepository.save(categoriesDetails);
        return updateCategories;
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable(value = "id") Long categoriesId) {
        Categories categories = categoryRepository.findById(categoriesId).orElseThrow(() -> new CategoryNotFoundException("Category", "id", categoriesId));

        categoryRepository.delete(categories);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new BookNotFoundException("Book", "id", bookId));
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {

        bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

        bookDetails.setId(bookId);
        Book updateBook = bookRepository.save(bookDetails);
        return updateBook;
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }


}

