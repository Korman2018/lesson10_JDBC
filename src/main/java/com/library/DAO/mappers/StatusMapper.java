package com.library.DAO.mappers;

import com.library.model.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusMapper implements RowMapper<Status> {
    @Override
    public Status mapRow(ResultSet rs, int i) throws SQLException {
        Status status = new Status(rs.getString("description"));
        status.setId(rs.getInt("idStatus"));
        return status;
    }
}
