package com.taha.DatabasePostgres.dao;

import com.taha.DatabasePostgres.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

}
