package com.lms.bookmanagement.repository;

import com.lms.bookmanagement.model.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, Long> {
}
