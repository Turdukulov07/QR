package com.example.andr3lesson8.data.source;

import com.example.andr3lesson8.data.frameworks.retrofit.OnResultFilmListener;

public interface RemoteSource {

    void getFilmById(String id, OnResultFilmListener result);
    void getFilms (OnResultFilmListener result);
}
