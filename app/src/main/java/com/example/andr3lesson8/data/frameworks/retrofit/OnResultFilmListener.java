package com.example.andr3lesson8.data.frameworks.retrofit;

import com.example.andr3lesson8.data.model.Film;

import java.util.List;

public interface OnResultFilmListener {

    default void onSuccessFilm(Film film) { }

    default void onSuccessList(List<Film> films) { }

}
