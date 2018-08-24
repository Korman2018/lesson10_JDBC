package com.library.model.Abstracts;


import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
