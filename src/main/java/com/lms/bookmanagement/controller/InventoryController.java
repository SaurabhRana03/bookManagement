package com.lms.bookmanagement.controller;


import com.lms.bookmanagement.exceptions.CategoryNotFoundException;
import com.lms.bookmanagement.model.Book;
import com.lms.bookmanagement.model.Categories;
import com.lms.bookmanagement.model.Inventory;
import com.lms.bookmanagement.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;


    @PostMapping("/inventory")
    public Inventory createInventory(@Valid @RequestBody Inventory inventory) {
        Logger logger = LoggerFactory.getLogger(InventoryController.class);
        logger.info("Created the Inventory");
        return inventoryRepository.save(inventory);
    }

    @PutMapping("/inventory")
    public Inventory updateInventory(@Valid @RequestBody Inventory inventory) {
        Logger logger = LoggerFactory.getLogger(InventoryController.class);
        logger.info("Updated the Inventory");

        Inventory updateInventory = inventoryRepository.save(inventory);
        return updateInventory;
    }

    @DeleteMapping("/inventory")
    public ResponseEntity<?> deleteInventory(@Valid @RequestBody Inventory inventory) {
        Logger logger = LoggerFactory.getLogger(InventoryController.class);
        logger.info("deleted the Inventory");

        inventoryRepository.delete(inventory);
        return ResponseEntity.ok().build();
    }

    @GetMapping("books/{id}/inventoryCount")
    public Inventory getInventoryCountById(@PathVariable(value = "id") Long bookId) throws Throwable {
        Logger logger = LoggerFactory.getLogger(InventoryController.class);
        logger.info("Showing InventoryCount with given id");

        return inventoryRepository.findById(bookId).orElseThrow(() -> new CategoryNotFoundException("Categories", "id", bookId));


    }
}

