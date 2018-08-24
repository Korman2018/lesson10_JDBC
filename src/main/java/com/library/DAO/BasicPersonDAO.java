package com.library.DAO;

import com.library.model.Abstracts.AbstractPersonContainer;
import com.library.model.Person;

import java.util.List;

public interface BasicPersonDAO<T extends AbstractPersonContainer> extends BasicDAO<T> {

    List<T> getByShortName(String name, String surname);

    List<T> getByPerson(Person person);
}
