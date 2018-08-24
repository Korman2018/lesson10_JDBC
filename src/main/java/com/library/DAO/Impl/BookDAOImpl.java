package com.library.DAO.Impl;

import com.library.DAO.BookDAO;
import com.library.DAO.mappers.BookMapper;
import com.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends AbstractBasicDAOImpl<Book> implements BookDAO {

    public BookDAOImpl() {
        super(new BookMapper(), "book");
    }

    @Override
    public List<Book> getByTitle(String title) {
        return getJdbcTemplate().query(getSelectFrom() + " WHERE title LIKE %?%", new Object[]{title}, getRowMapper());
    }

    @Override
    public List<Book> getByGenreId(long id) {
        return getJdbcTemplate().query(getSelectFrom() + " WHERE idGenre = ?", new Object[]{id}, getRowMapper());
    }

    @Override
    public List<Book> getByAuthorId(long id) {
        return getJdbcTemplate().query(getSelectFrom() + " WHERE idAuthor = ?", new Object[]{id}, getRowMapper());

    }

    @Override
    public long add(Book entity) {
        return getJdbcTemplate().update("INSERT INTO "
                        + getTable() + "(title, idAuthor, idGenre) VALUES"
                        + "(?,?,?)"
                , entity.getTitle()
                , entity.getAuthorId()
                , entity.getGenreId());
    }

    @Override
    public long set(long id, Book entity) {
        return getJdbcTemplate().update(
                "UPDATE "
                        + getTable()
                        + " SET title = ?, idAuthor = ?, idGenre = ?"
                        + getWhereId()
                , entity.getTitle()
                , entity.getAuthorId()
                , entity.getGenreId()
                , id);
    }
}
