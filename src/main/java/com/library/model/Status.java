package com.library.model;

import com.library.model.Abstracts.AbstractEnum;

import java.io.Serializable;

public class Status extends AbstractEnum implements Serializable {
    public Status(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return getId() + ". " + getDescription();
    }
}
