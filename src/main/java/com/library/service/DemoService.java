package com.library.service;


public interface DemoService {
    void startDemo();

    //ADD block
    void addBooks();

    void addUsers();

    void addGenres();


    // UPDATE block
    void setBookStatus();

    void setGenres();


    // DELETE block
    void deleteBooks();

    void deleteGenres();

    void deleteUsers();


    // PRINT block
    void printAuthors();

    void printBooks();

    void printUsers();

    void printGenres();

    void printStatuses();

    void printBookRequests();

    void printLibrarians();

    void printReaders();
}
