package com.library.DAO.mappers;

import com.library.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                PersonMapper.mapRow(rs, rowNum)
                , rs.getString("login")
                , rs.getString("password")
                , rs.getBoolean("isLibrarian"));
        user.setId(rs.getInt("idUser"));
        return user;
    }
}
