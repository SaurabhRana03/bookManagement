package com.lms.bookmanagement.repository;

import com.lms.bookmanagement.model.Categories;

import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public <S extends Categories> S save(S s) {
        return null;
    }

    @Override
    public <S extends Categories> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Categories> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Categories> findAll() {
        return null;
    }

    @Override
    public Iterable<Categories> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Categories categories) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Categories> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
