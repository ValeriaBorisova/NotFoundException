package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Anatomical Atlas", 987, "Trevor Weston");
    private Smartphone smartphone = new Smartphone(3, "11T", 35_990, "Xiaomi");

    @Test
    void shouldNotMatchesSearch() {
        boolean actual = book.matches("");
        assertEquals(false, actual);
    }

    @Test
    void shouldMatchesBookByTitle() {
        boolean actual = book.matches("Anatomical Atlas");
        assertEquals(true, actual);
    }

    @Test
    void shouldMatchesBookByAuthor() {
        boolean actual = book.matches("Trevor Weston");
        assertEquals(true, actual);
    }
}