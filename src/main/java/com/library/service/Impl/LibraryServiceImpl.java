package com.library.service.Impl;

import com.library.DAO.*;
import com.library.model.*;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 24.08.2018 прописать более подробную логику с обработкой конкретных ситуаций и исключений при подключении web части
@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StatusDAO statusDAO;

    @Autowired
    private GenreDAO genreDAO;

    @Autowired
    private BookRequestDAO bookRequestDAO;


    @Override
    public long addUser(User user) {
        return userDAO.add(user);
    }

    @Override
    public long addGenre(String desc) {
        return genreDAO.add(new Genre(desc));
    }

    @Override
    public long addBook(Book book) {
        return bookDAO.add(book);
    }

    @Override
    public long addStatus(Status status) {
        return statusDAO.add(status);
    }

    @Override
    public long addBookRequest(BookRequest bookRequest) {
        return bookRequestDAO.add(bookRequest);
    }

    @Override
    public long addAuthor(Author author) {
        return authorDAO.add(author);
    }

    @Override
    public long deleteBook(long id) {
        return bookDAO.delete(id);
    }

    @Override
    public long deleteGenre(long id) {
        return genreDAO.delete(id);
    }

    @Override
    public long deleteStatus(long id) {
        return statusDAO.delete(id);
    }

    @Override
    public long deleteBookRequest(long id) {
        return bookRequestDAO.delete(id);
    }

    @Override
    public long deleteUser(long id) {
        return userDAO.delete(id);
    }

    @Override
    public long deleteAuthor(long id) {
        return authorDAO.delete(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDAO.getAll();
    }

    @Override
    public List<Author> getAuthors() {
        return authorDAO.getAll();
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getAll();
    }

    @Override
    public List<Status> getStatuses() {
        return statusDAO.getAll();
    }

    @Override
    public List<Genre> getGenres() {
        return genreDAO.getAll();
    }

    @Override
    public List<BookRequest> getBookRequests() {
        return bookRequestDAO.getAll();
    }

    @Override
    public List<User> getLibrarians() {
        return userDAO.getLibrarians();
    }

    @Override
    public List<User> getReaders() {
        return userDAO.getReaders();
    }

    @Override
    public Book getBookById(long id) {
        return bookDAO.getById(id);
    }

    @Override
    public Author getAuthorById(long id) {
        return authorDAO.getById(id);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public Status getStatusById(long id) {
        return statusDAO.getById(id);
    }

    @Override
    public Genre getGenreById(long id) {
        return genreDAO.getById(id);
    }

    @Override
    public BookRequest getBookRequestById(long id) {
        return bookRequestDAO.getById(id);
    }

    @Override
    public List<User> getUserByShortName(String name, String surname) {
        return userDAO.getByShortName(name, surname);
    }

    @Override
    public List<Author> getAuthorByShortName(String name, String surname) {
        return authorDAO.getByShortName(name, surname);
    }

    @Override
    public List<User> getUserByPerson(Person person) {
        return userDAO.getByPerson(person);
    }

    @Override
    public List<Author> getAuthorByPerson(Person person) {
        return authorDAO.getByPerson(person);
    }

    @Override
    public List<Book> getByTitle(String title) {
        return bookDAO.getByTitle(title);
    }

    @Override
    public List<Book> getByGenreId(long id) {
        return bookDAO.getByGenreId(id);
    }

    @Override
    public List<Book> getByAuthorId(long id) {
        return bookDAO.getByAuthorId(id);
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public long setBook(long id, Book book) {
        return bookDAO.set(id, book);
    }

    @Override
    public long setGenre(long id, Genre genre) {
        return genreDAO.set(id, genre);
    }

    @Override
    public long setStatus(long id, Status status) {
        return statusDAO.set(id, status);
    }

    @Override
    public long updateRequestStatus(long id, long idLibrarian, long idStatus) {
        return bookRequestDAO.updateStatus(id, idLibrarian, idStatus);
    }

    @Override
    public long setAuthor(long id, Author author) {
        return authorDAO.set(id, author);
    }

    @Override
    public long setUser(long id, User user) {
        return userDAO.set(id, user);
    }
}
