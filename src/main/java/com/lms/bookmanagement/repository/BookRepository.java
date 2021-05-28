package com.lms.bookmanagement.repository;


import com.lms.bookmanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {


}

