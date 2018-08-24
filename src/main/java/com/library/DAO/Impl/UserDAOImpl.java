package com.library.DAO.Impl;

import com.library.DAO.UserDAO;
import com.library.DAO.mappers.UserMapper;
import com.library.model.Person;
import com.library.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstractPersonDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(new UserMapper(), "user");
    }

    @Override
    public User getByLogin(String login) {
        return getJdbcTemplate().queryForObject(getSelectFrom() + " WHERE login =?", new Object[]{login}, getRowMapper());
    }

    @Override
    public List<User> getLibrarians() {
        return getJdbcTemplate().query(getSelectFrom() + " WHERE isLibrarian = 1", getRowMapper());
    }

    @Override
    public List<User> getReaders() {
        return getJdbcTemplate().query(getSelectFrom() + " WHERE isLibrarian = 0", getRowMapper());
    }

    @Override
    public long add(User entity) {
        Person p = entity.getPerson();
        return getJdbcTemplate().update("INSERT INTO "
                        + getTable() + "(name, patronymic, surname, login, password, isLibrarian) VALUES"
                        + "(?,?,?,?,?,?)"
                , p.getFirstName()
                , p.getPatronymic()
                , p.getSurname()
                , entity.getLogin()
                , entity.getPassword()
                , entity.getIsLibrarian());
    }

    @Override
    public long set(long id, User entity) {
        Person p = entity.getPerson();
        String sql = "UPDATE "
                + getTable()
                + " SET name = ?, patronymic = ?, surname = ?, login = ?, password = ?, isLibrarian = ?  "
                + getWhereId();
        return getJdbcTemplate().update(
                sql
                , p.getFirstName()
                , p.getPatronymic()
                , p.getSurname()
                , entity.getLogin()
                , entity.getPassword()
                , entity.getIsLibrarian()
                , id);
    }
}
