package com.taha.DatabasePostgres.dao.impl;

import com.taha.DatabasePostgres.dao.impl.BookDaoImpl;
import com.taha.DatabasePostgres.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplClassTests {

    @Mock
    public JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesTheCorrectSql(){
        Book book = Book.builder()
                .isbn("965-954-569-456")
                .title("Taha Book")
                .authorId(1L)
                .build();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("965-954-569-456"), eq("Taha Book"), eq(1L)
        );


    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql(){
        underTest.find("965-954-569-456");
                verify(jdbcTemplate.query(
                        eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                        ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                        eq("965-954-569-456")
                    )
                );
    }
}
