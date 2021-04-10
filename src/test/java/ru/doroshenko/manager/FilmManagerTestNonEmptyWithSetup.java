package ru.doroshenko.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.doroshenko.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmManagerTestNonEmptyWithSetup {
    FilmManager manager = new FilmManager(10);
    private final Film first = new Film(1, 11, "name1", "genre1", "url121");
    private final Film second = new Film(2, 22, "name2", "genre1", "url134");
    private final Film third = new Film(3, 33, "name3", "genre1", "url145");
    private final Film forth = new Film(4, 44, "name4", "genre2", "url156");
    private final Film fifth = new Film(5, 55, "name5", "genre1", "url167");
    private final Film sixth = new Film(6, 66, "name6", "genre3", "url178");
    private final Film seventh = new Film(7, 77, "name7", "genre1", "url189");
    private final Film eighth = new Film(8, 88, "name8", "genre4", "url190");
    private final Film ninth = new Film(9, 99, "name9", "genre1", "url154");
    private final Film tenth = new Film(10, 110, "name0", "genre3", "url143");
    private final Film eleventh = new Film(11, 211, "name11", "genre1", "url132");
    private final Film twelfth = new Film(12, 312, "name12", "genre6", "url129");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    @Test
    public void shouldGetAll() {
        FilmManager manager = new FilmManager();
        manager.add(first);
        manager.add(second);
        Film[] actual = manager.getAll();
        Film[] expected = new Film[]{second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTenFilms() {
        FilmManager manager = new FilmManager();
        manager.films = this.manager.films;
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};
        Film[] actual = manager.getPostWithLength();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnCurrentFilms() {
        FilmManager manager = new FilmManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        Film[] expected = new Film[]{seventh, sixth, fifth, forth, third, second, first};
        Film[] actual = manager.getPostWithLength();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSomeFilms() {
        FilmManager manager = new FilmManager(5);
        manager.films = this.manager.films;
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth};
        Film[] actual = manager.getPostWithLength();
        assertArrayEquals(expected, actual);
    }
}