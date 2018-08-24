package com.library.DAO.Impl;

import com.library.DAO.BookRequestDAO;
import com.library.DAO.mappers.BookRequestMapper;
import com.library.model.BookRequest;
import org.springframework.stereotype.Repository;

@Repository
public class BookRequestDAOImpl extends AbstractBasicDAOImpl<BookRequest> implements BookRequestDAO {
    BookRequestDAOImpl() {
        super(new BookRequestMapper(), "bookrequest");
    }

    @Override
    public long updateStatus(long id, long idLibrarian, long idStatus) {
        return getJdbcTemplate().update(
                "UPDATE " + getTable() + " SET idStatus = ? , idLibrarian = ?"
                        + getWhereId()
                , idStatus
                , idLibrarian
                , id);
    }

    @Override
    public long add(BookRequest entity) {
        return getJdbcTemplate().update("INSERT INTO "
                        + getTable() + "(idReader, idBook, idStatus, idLibrarian) VALUES (?,?,?,?)"
                , entity.getIdReader()
                , entity.getIdBook()
                , entity.getIdStatus()
                , entity.getIdLibrarian());
    }

    @Override
    public long set(long id, BookRequest entity) {
        return getJdbcTemplate().update(
                "UPDATE " + getTable() + " SET idReader = ?, idBook = ?, idStatus = ? , idLibrarian = ? "
                        + getWhereId()
                , entity.getIdReader()
                , entity.getIdBook()
                , entity.getIdStatus()
                , entity.getIdLibrarian()
                , id);
    }
}
