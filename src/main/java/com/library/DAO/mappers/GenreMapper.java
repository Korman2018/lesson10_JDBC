package com.library.DAO.mappers;

import com.library.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int i) throws SQLException {
        Genre genre = new Genre(rs.getString("description"));
        genre.setId(rs.getInt("idGenre"));
        return genre;
    }
}
