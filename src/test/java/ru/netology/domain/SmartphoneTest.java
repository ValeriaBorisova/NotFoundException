package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Book book = new Book(1, "Anatomical Atlas", 987, "Trevor Weston");
    private Smartphone smartphone = new Smartphone(3, "11T", 35_990, "Xiaomi");

    @Test
    void shouldNotMatchesSearch() {
        boolean actual = smartphone.matches("");
        assertEquals(false, actual);
    }

    @Test
    void shouldMatchesBookByTitle() {
        boolean actual = smartphone.matches("11T");
        assertEquals(true, actual);
    }

    @Test
    void shouldMatchesBookByManufacturer() {
        boolean actual = smartphone.matches("Xiaomi");
        assertEquals(true, actual);
    }
}