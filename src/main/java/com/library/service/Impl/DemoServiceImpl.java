package com.library.service.Impl;

import com.library.model.*;
import com.library.service.DemoService;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private LibraryService libraryService;

    public void startDemo() {
        printBooks();
        printUsers();
        printAuthors();
        printGenres();
        printStatuses();
        printLibrarians();
        printReaders();
        printBookRequests();

        addBooks();
        printBooks();

        addUsers();
        printUsers();

        addGenres();
        printGenres();

        setBookStatus();
        printBookRequests();

        setGenres();
        printGenres();

        deleteBooks();
        printBooks();

        deleteGenres();
        printGenres();

        deleteUsers();
        printUsers();

    }

    @Override
    public void addBooks() {
        System.out.println("\nAdding book \"The Lord of the Rings\"");
        libraryService.addBook(new Book("The Lord of the Rings", 9, 5));
    }

    @Override
    public void addUsers() {
        System.out.println("\nAdding user Vasiliy Ivanovich Chapaev(librarian)");
        libraryService.addUser(new User(
                new Person("Vasiliy", "Ivanovich", "Chapaev")
                , "chapaev"
                , "vasiliy"
                , true));
    }

    @Override
    public void addGenres() {
        System.out.println("\nAdding genre Tro-lo-lo");
        libraryService.addGenre("Tro-lo-lo");
    }

    @Override
    public void setBookStatus() {
        System.out.println("\nSet book status with id=1 to 'return'");
        BookRequest bookRequest = libraryService.getBookRequestById(1);
        libraryService.updateRequestStatus(1, bookRequest.getIdLibrarian(), 3);
    }

    @Override
    public void setGenres() {
        System.out.println("\nSet book genre with id =9 to COOK_BOOK");
        libraryService.setGenre(9, new Genre("COOK_BOOK"));
    }

    @Override
    public void deleteBooks() {
        System.out.println("\ndeleting book with id=3");
        libraryService.deleteBook(3);
    }

    @Override
    public void deleteGenres() {
        System.out.println("\ndeleting genre with id=13");
        libraryService.deleteGenre(13);
    }

    @Override
    public void deleteUsers() {
        System.out.println("\ndeleting user with id=6");
        libraryService.deleteUser(6);
    }

    @Override
    public void printAuthors() {
        System.out.println("\nPrint all authors");
        libraryService.getAuthors().forEach(System.out::println);
    }

    @Override
    public void printBooks() {
        System.out.println("\nPrint all books");
        libraryService.getBooks().forEach(System.out::println);
    }

    @Override
    public void printUsers() {
        System.out.println("\nPrint all users");
        libraryService.getUsers().forEach(System.out::println);
    }

    @Override
    public void printGenres() {
        System.out.println("\nPrint all genres");
        libraryService.getGenres().forEach(System.out::println);
    }

    @Override
    public void printStatuses() {
        System.out.println("\nPrint all statuses");
        libraryService.getStatuses().forEach(System.out::println);
    }

    @Override
    public void printBookRequests() {
        System.out.println("\nPrint all bookRequests");
        libraryService.getBookRequests().forEach(System.out::println);
    }

    @Override
    public void printLibrarians() {
        System.out.println("\nPrint all librarians");
        libraryService.getLibrarians().forEach(System.out::println);
    }

    @Override
    public void printReaders() {
        System.out.println("\nPrint all readers");
        libraryService.getReaders().forEach(System.out::println);
    }
}
