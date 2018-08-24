package com.library.model;

import com.library.model.Abstracts.AbstractEnum;

import java.io.Serializable;

public class Genre extends AbstractEnum implements Serializable {
    public Genre(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return getId() + ". " + getDescription();
    }
}
