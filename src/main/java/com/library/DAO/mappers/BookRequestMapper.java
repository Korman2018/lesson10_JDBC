package com.library.DAO.mappers;

import com.library.model.BookRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRequestMapper implements RowMapper<BookRequest> {

    @Override
    public BookRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookRequest bookRequest = new BookRequest(rs.getInt("idReader"), rs.getInt("idBook"));
        bookRequest.setId(rs.getInt("idBookRequest"));
        bookRequest.setIdLibrarian(rs.getInt("idLibrarian"));
        bookRequest.setIdStatus(rs.getInt("idStatus"));
        return bookRequest;
    }
}
