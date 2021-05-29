package com.lms.bookmanagement.controller;


import com.lms.bookmanagement.exceptions.CategoryNotFoundException;
import com.lms.bookmanagement.model.Categories;
import com.lms.bookmanagement.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Categories> getAllCategories() {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Showing all the categories");
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public Categories createCategory(@Valid @RequestBody Categories categories) {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Created the categories");
        return categoryRepository.save(categories);
    }

    @GetMapping("/categories/{id}")
    public Categories getCategoriesById(@PathVariable(value = "id") Long categoriesId) {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Showing all the categories with given id");
        return categoryRepository.findById(categoriesId).orElseThrow(() -> new CategoryNotFoundException("Categories", "id", categoriesId));
    }

    @PutMapping("/categories/{id}")
    public Categories updateCategories(@PathVariable(value = "id") Long categoriesId,
                           @Valid @RequestBody Categories categoriesDetails) {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Updated the categories");

        if(categoryRepository.existsById(categoriesId)==false){

         throw new CategoryNotFoundException("Categories", "id", categoriesId);
        }
        categoriesDetails.setId(categoriesId);
        Categories updateCategories = categoryRepository.save(categoriesDetails);
        return updateCategories;
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable(value = "id") Long categoriesId) {
        Logger logger = LoggerFactory.getLogger(BookController.class);
        logger.info("Updated the categories");
        Categories categories = categoryRepository.findById(categoriesId).orElseThrow(() -> new CategoryNotFoundException("Categories", "id", categoriesId));

        categoryRepository.delete(categories);
        return ResponseEntity.ok().build();
    }


}
