package com.library.model;

import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;

    private String patronymic;

    private String surname;


    public Person(String firstName, String patronymic, String surname) {
        this.firstName = firstName == null ? "" : firstName;
        this.patronymic = patronymic == null ? "" : patronymic;
        this.surname = surname == null ? "" : surname;
    }

    public Person(String firstName, String surname) {
        this(firstName, null, surname);
    }

    public Person() {
        this(null, null, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return firstName + " " + patronymic + " " + surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;

            return person.getFirstName().equalsIgnoreCase(firstName)
                    && person.getPatronymic().equalsIgnoreCase(patronymic)
                    && person.getSurname().equalsIgnoreCase(surname);
        }
        return false;
    }
}
