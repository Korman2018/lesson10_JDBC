package com.library.DAO.Impl;

import com.library.DAO.AuthorDAO;
import com.library.DAO.mappers.AuthorMapper;
import com.library.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl extends AbstractPersonDAOImpl<Author> implements AuthorDAO {

    public AuthorDAOImpl() {
        super(new AuthorMapper(),"author");
    }
}
