package com.taha.DatabasePostgres.dao;

import com.taha.DatabasePostgres.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
