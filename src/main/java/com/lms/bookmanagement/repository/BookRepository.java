package com.lms.bookmanagement.repository;


import com.lms.bookmanagement.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {


}
