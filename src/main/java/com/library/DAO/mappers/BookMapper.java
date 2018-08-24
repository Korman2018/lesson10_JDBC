package com.library.DAO.mappers;

import com.library.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book(
                rs.getString("title")
                , rs.getInt("idAuthor")
                , rs.getInt("idGenre"));
        book.setId(rs.getInt("idBook"));
        return book;
    }
}
