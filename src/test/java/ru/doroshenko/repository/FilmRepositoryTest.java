package ru.doroshenko.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.doroshenko.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    private FilmRepository filmRepository = new FilmRepository();
    private final Film first = new Film(1, 11, "name1", "genre1", "url121");
    private final Film second = new Film(2, 22, "name2", "genre1", "url134");
    private final Film third = new Film(3, 33, "name3", "genre1", "url145");

    @BeforeEach
    public void setUp() {
        filmRepository.save(first);
        filmRepository.save(second);
        filmRepository.save(third);
    }

    @Test
    public void findAll() {
        Film[] actual = filmRepository.findAll();
        Film[] expected = new Film[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        int findId = 2;
        Film actual = filmRepository.findById(findId);
        assertEquals(second, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        Film actual = filmRepository.findById(findId);
        assertNull(actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        filmRepository.removeById(idToRemove);
        Film[] actual = filmRepository.findAll();
        Film[] expected = new Film[]{first, third};
        assertArrayEquals(expected, actual);
    }

           @Test
        public void shouldRemoveAll() {
            filmRepository.removeAll();
            Film[] actual = filmRepository.findAll();
            Film[] expected = new Film[0];
            assertArrayEquals(expected, actual);
        }
}