package com.library.DAO.Impl;

import com.library.DAO.BasicDAO;
import com.library.model.Abstracts.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;


public abstract class AbstractBasicDAOImpl<T extends AbstractEntity> implements BasicDAO<T> {

    private final String table;
    private final RowMapper<T> rowMapper;
    private final String selectFrom;
    private final String deleteFrom;
    private final String whereId;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    AbstractBasicDAOImpl(RowMapper<T> rowMapper, String table) {
        this.table = table;
        this.rowMapper = rowMapper;
        selectFrom = "SELECT * FROM " + table;
        deleteFrom = "DELETE FROM " + table;
        whereId = " WHERE id" + table + " = ?";
    }

    @Override
    public List<T> getAll() {
        return jdbcTemplate.query(selectFrom, rowMapper);
    }

    @Override
    public T getById(long id) {
        return jdbcTemplate.queryForObject(selectFrom + whereId, new Object[]{id}, rowMapper);
    }

    @Override
    public long delete(long id) {
        return jdbcTemplate.update(deleteFrom + whereId, id);
    }

    JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    RowMapper<T> getRowMapper() {
        return rowMapper;
    }

    String getSelectFrom() {
        return selectFrom;
    }

    String getDeleteFrom() {
        return deleteFrom;
    }

    String getWhereId() {
        return whereId;
    }

    String getTable() {
        return table;
    }
}
