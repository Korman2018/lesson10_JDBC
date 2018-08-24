package com.library.service;

import com.library.model.*;

import java.util.List;

public interface LibraryService {

    // ADD block
    long addUser(User user);

    long addGenre(String desc);

    long addBook(Book book);

    long addStatus(Status status);

    long addBookRequest(BookRequest bookRequest);

    long addAuthor(Author author);


    // DELETE block
    long deleteBook(long id);

    long deleteGenre(long id);

    long deleteStatus(long id);

    long deleteBookRequest(long id);

    long deleteUser(long id);

    long deleteAuthor(long id);


    // GET block
    List<Book> getBooks();

    List<Author> getAuthors();

    List<User> getUsers();

    List<Status> getStatuses();

    List<Genre> getGenres();

    List<BookRequest> getBookRequests();

    List<User> getLibrarians();

    List<User> getReaders();

    // get by id subBlock
    Book getBookById(long id);

    Author getAuthorById(long id);

    User getUserById(long id);

    Status getStatusById(long id);

    Genre getGenreById(long id);

    BookRequest getBookRequestById(long id);

    //get by person subBlock
    List<User> getUserByShortName(String name, String surname);

    List<Author> getAuthorByShortName(String name, String surname);

    List<User> getUserByPerson(Person person);

    List<Author> getAuthorByPerson(Person person);

    //other subBlock
    List<Book> getByTitle(String title);

    List<Book> getByGenreId(long id);

    List<Book> getByAuthorId(long id);

    User getByLogin(String login);


    // UPDATE block
    long setBook(long id, Book book);

    long setGenre(long id, Genre genre);

    long setStatus(long id, Status status);

    long updateRequestStatus(long id, long idLibrarian, long idStatus);

    long setAuthor(long id, Author author);

    long setUser(long id, User user);
}
