package com.library.DAO;

import com.library.model.Book;

import java.util.List;

public interface BookDAO extends BasicDAO<Book> {
    List<Book> getByTitle(String title);

    List<Book> getByGenreId(long id);

    List<Book> getByAuthorId(long id);
}
