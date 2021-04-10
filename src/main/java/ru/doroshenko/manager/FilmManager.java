package ru.doroshenko.manager;

import ru.doroshenko.domain.Film;
import ru.doroshenko.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    public int postLength = 10;

    public FilmManager() {
    }

    public FilmManager(FilmRepository repository, int postLength) {
        this.repository = repository;

    }

    public void add(Film film) {
        repository.save(film);
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();
        int resultLength = Math.min(postLength, films.length);
        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] showAll() {
        return repository.findAll();
    }

}

