package com.library.model;

import com.library.model.Abstracts.AbstractPersonContainer;

import java.io.Serializable;

public class Author extends AbstractPersonContainer implements Serializable {

    private Author() {
        super();
        // id = -1 unknown Author
        setId(-1);
    }

    public Author(Person person) {
        super(person);
    }

    @Override
    public String toString() {
        return getId() + ". " + getPerson();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Author) {
            Author author = (Author) obj;
            return getPerson().equals(author.getPerson());
        }
        return false;
    }
}
