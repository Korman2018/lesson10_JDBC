package com.library.DAO.mappers;

import com.library.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper {
    public static Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getString("name")
                , rs.getString("patronymic")
                , rs.getString("surname"));
    }
}
