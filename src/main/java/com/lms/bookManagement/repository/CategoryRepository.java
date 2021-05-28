package com.lms.bookManagement.repository;

import com.lms.bookManagement.model.Book;
import com.lms.bookManagement.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
