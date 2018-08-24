package com.library.model;

import com.library.model.Abstracts.AbstractEntity;

import java.io.Serializable;

public class BookRequest extends AbstractEntity implements Serializable {
    private long idReader;

    private long idBook;

    private long idStatus;

    private long idLibrarian;

    public BookRequest(long idReader, long idBook) {
        this.idReader = idReader;
        this.idBook = idBook;
        this.idStatus = 1;
        this.idLibrarian = -1;
    }

    public long getIdReader() {
        return idReader;
    }

    public void setIdReader(long idReader) {
        this.idReader = idReader;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public long getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(long idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getId()).append(". ид читателя:").append(getIdReader()).append(" ид книги:").append(getIdBook())
                .append(" ид статуса:").append(getIdStatus()).append(" ид библиотекаря:").append(getIdLibrarian());
        return stringBuilder.toString();
    }
}
