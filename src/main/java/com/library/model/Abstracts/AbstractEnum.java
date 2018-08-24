package com.library.model.Abstracts;

import java.io.Serializable;

public abstract class AbstractEnum extends AbstractEntity implements Serializable {

    private String description;

    public AbstractEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
