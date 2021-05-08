package com.example.andr3lesson8.data.repository;

import com.example.andr3lesson8.data.frameworks.retrofit.OnResultFilmListener;
import com.example.andr3lesson8.data.source.RemoteSource;

public class FilmRepository {

    private final RemoteSource remoteSource;

    public FilmRepository(RemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    public void getFilmByID(String id, OnResultFilmListener listener) {
        remoteSource.getFilmById(id,listener);
    }

    public void  getFilms (OnResultFilmListener result) {
        remoteSource.getFilms(result);
    }

}
