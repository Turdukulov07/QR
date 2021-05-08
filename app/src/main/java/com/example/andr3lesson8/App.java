package com.example.andr3lesson8;

import android.app.Application;

import com.example.andr3lesson8.data.frameworks.retrofit.RetrofitSource;
import com.example.andr3lesson8.data.repository.FilmRepository;

public class App extends Application {

    private static FilmRepository filmRepository;

    public static FilmRepository getFilmRepository() {
        if (filmRepository == null)
            filmRepository = new FilmRepository(new RetrofitSource());
        return filmRepository;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
