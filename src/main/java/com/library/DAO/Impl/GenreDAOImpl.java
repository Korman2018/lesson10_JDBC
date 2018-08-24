package com.library.DAO.Impl;

import com.library.DAO.GenreDAO;
import com.library.DAO.mappers.GenreMapper;
import com.library.model.Genre;
import org.springframework.stereotype.Repository;

@Repository
public class GenreDAOImpl extends AbstractEnumDAOImpl<Genre> implements GenreDAO {
    GenreDAOImpl() {
        super(new GenreMapper(), "genre");
    }
}
