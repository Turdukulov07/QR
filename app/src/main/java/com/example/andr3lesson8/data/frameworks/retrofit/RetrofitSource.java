package com.example.andr3lesson8.data.frameworks.retrofit;

import com.example.andr3lesson8.data.model.Film;
import com.example.andr3lesson8.data.source.RemoteSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitSource implements RemoteSource {


    @Override
    public void getFilmById(String id, OnResultFilmListener result) {
        RetrofitBuilder.getInstance().getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null)
                    result.onSuccessFilm(response.body());

            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });
    }

    @Override
    public void getFilms(OnResultFilmListener result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null)
                    result.onSuccessList(response.body());
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                t.getLocalizedMessage();
            }
        });

    }
}
