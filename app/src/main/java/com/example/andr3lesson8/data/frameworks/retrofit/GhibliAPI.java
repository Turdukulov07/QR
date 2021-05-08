package com.example.andr3lesson8.data.frameworks.retrofit;

import com.example.andr3lesson8.data.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliAPI {

    @GET(EndPoints.FILM_BY_ID)
    Call<Film> getFilmById(@Path(EndPoints.ID) String id);

    @GET (EndPoints.FILMS)
    Call <List<Film>> getFilms();

}
