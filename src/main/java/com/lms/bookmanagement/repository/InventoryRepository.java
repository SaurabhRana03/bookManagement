package com.lms.bookmanagement.repository;

import com.lms.bookmanagement.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository <Inventory,Long> {
    Inventory findByBookId(Long bookId);
}
