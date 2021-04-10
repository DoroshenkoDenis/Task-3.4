package ru.doroshenko.manager;

import ru.doroshenko.domain.Film;

public class FilmManager {
    public Film[] films = new Film[0];
    private int postLength = 10;


    public FilmManager() {
    }

    public FilmManager(int postLength) {
        this.postLength = postLength;
    }

    public void add(Film item) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        // копируем поэлементно
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }

    public Film[] getAll() {
        Film[] result = new Film[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] getPostWithLength() {
        int postLengthNow = Math.min(postLength, films.length);
        Film[] post = new Film[postLengthNow];
        for (int i = 0; i < postLengthNow; i++) {
            int index = films.length - i - 1;
            post[i] = films[index];
        }
        return post;
    }
}

