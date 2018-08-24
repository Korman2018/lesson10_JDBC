package com.library.model;

import com.library.model.Abstracts.AbstractEntity;

import java.io.Serializable;


public class Book extends AbstractEntity implements Serializable {

    private String title;

    private long authorId;

    private long genreId;

    public Book(String title, long authorId, long genreId) {
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public Book(String title, long authorId) {
        this(title, authorId, -1);
    }

    public Book(String title) {
        this(title, -1);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getId()).append(". ").append(title).append(" ид автора:").append(authorId)
                .append(" ид жанра:").append(genreId);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            if (book.getId() == getId()) {
                return true;
            }

            if (!(title != null && title.equals(book.title))) {
                return false;
            }
            return getAuthorId() == book.getAuthorId();
        }
        return false;
    }
}

