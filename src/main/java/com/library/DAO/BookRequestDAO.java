package com.library.DAO;

import com.library.model.BookRequest;

public interface BookRequestDAO extends BasicDAO<BookRequest> {
    long updateStatus(long id, long idLibrarian, long idStatus);
}
