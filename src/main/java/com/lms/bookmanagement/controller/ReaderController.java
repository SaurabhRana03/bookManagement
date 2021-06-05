package com.lms.bookmanagement.controller;

import com.lms.bookmanagement.exceptions.ReaderNotFoundException;
import com.lms.bookmanagement.model.Readers;
import com.lms.bookmanagement.repository.ReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReaderController {

    @Autowired
    ReaderRepository readerRepository;

    @GetMapping("/readers")
    public List<Readers> getAllReaders() {
        Logger logger = LoggerFactory.getLogger(ReaderController.class);
        logger.info("All the available Readers Shown");

        return readerRepository.findAll();
    }

    @PostMapping("/readers")
    public Readers createReaders(@Valid @RequestBody Readers readers) {

        Logger logger = LoggerFactory.getLogger(ReaderController.class);
        logger.info("Readers details created");
        return readerRepository.save(readers);
    }

    @PutMapping("/readers/{id}")
    public Readers updateReaders(@PathVariable(value = "id") Long readersId,
                           @Valid @RequestBody Readers readersDetails) {
        Logger logger = LoggerFactory.getLogger(ReaderController.class);
        logger.info("Readers details UPDATED");

        if (readerRepository.findById(readersId).isPresent() == false) {
            logger.error("Readers by given Id Not Found");

            throw new ReaderNotFoundException("Readers", "id", readersId);
        }
        readersDetails.setId(readersId);
        Readers updateReaders = readerRepository.save(readersDetails);
        return updateReaders;
    }


}
