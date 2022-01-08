package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    int nonexistentID = 5;
    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "Anatomical Atlas", 987, "Trevor Weston");
    private Book secondBook = new Book(2, "Human anatomy", 683, "Trevor Weston");

    @BeforeEach
    void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void shouldFindAll() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByID() {
        Product expected = secondBook;
        Product actual = repository.findByID(2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByNonexistentID() {
        assertNull(repository.findByID(nonexistentID));
    }

    @Test
    public void shouldRemoveByID() {
        repository.removeByID(2);
        Product[] expected = new Product[]{firstBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByNonexistentID() {
        assertThrows(NotFoundException.class, () -> repository.removeByID(nonexistentID));
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}