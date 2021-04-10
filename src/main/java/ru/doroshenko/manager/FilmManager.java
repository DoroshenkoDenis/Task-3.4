package ru.doroshenko.manager;

import ru.doroshenko.domain.Film;
import ru.doroshenko.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    private int postLength = 10;

    public FilmManager(int postLength, FilmRepository repository) {
        this.postLength = postLength;
        this.repository = repository;
    }

    public FilmManager(int postLength) {

    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] getPostWithLength() {
        int postLengthNow = Math.min(postLength, getAll().length);
        Film[] post = new Film[postLengthNow];
        for (int i = 0; i < postLengthNow; i++) {
            int index = getAll().length - i - 1;
            post[i] = getAll()[index];
        }
        return post;
    }
}

