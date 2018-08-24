package com.library.DAO.Impl;

import com.library.model.Abstracts.AbstractEnum;
import org.springframework.jdbc.core.RowMapper;

public abstract class AbstractEnumDAOImpl<T extends AbstractEnum> extends AbstractBasicDAOImpl<T> {
    AbstractEnumDAOImpl(RowMapper<T> rowMapper, String table) {
        super(rowMapper, table);
    }

    @Override
    public long add(T entity) {
        return getJdbcTemplate().update(
                "INSERT INTO " + getTable()
                        + " (description) VALUES"
                        + " (?)"
                , entity.getDescription());
    }

    @Override
    public long set(long id, T entity) {
        return getJdbcTemplate().update(
                "UPDATE "
                        + getTable()
                        + " SET description = ?"
                        + getWhereId()
                , entity.getDescription()
                , id
        );
    }
}
