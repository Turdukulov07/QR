package com.example.andr3lesson8.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.andr3lesson8.App;
import com.example.andr3lesson8.R;
import com.example.andr3lesson8.data.frameworks.retrofit.OnResultFilmListener;
import com.example.andr3lesson8.data.model.Film;
import com.example.andr3lesson8.databinding.FragmentDetailsBinding;
import com.example.andr3lesson8.ui.base.BaseFragment;

public class DetailsFragment extends BaseFragment<FragmentDetailsBinding> {

    private static final String ARG_ID_DETAILS = "film_details";
    private String filmId;

    @Override
    protected FragmentDetailsBinding bind() {
        return FragmentDetailsBinding.inflate(getLayoutInflater());
    }

    public static DetailsFragment newInstance(String filmId) {

        Bundle args = new Bundle();
        args.putString(ARG_ID_DETAILS, filmId);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null)
            filmId = getArguments().getString(ARG_ID_DETAILS);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFilmDetails(filmId);
    }

    private void getFilmDetails(String filmId) {

        App.getFilmRepository().getFilmByID(filmId, new OnResultFilmListener() {
            @Override
            public void onSuccessFilm(Film film) {
                ui.tvTitle.setText(film.getTitle());
                ui.tvDescription.setText(film.getDescription());
                ui.tvDirector.setText(String.format("%s %s", getString(R.string.director), film.getDirector()));
                ui.tvProducer.setText(String.format("%s %s", getString(R.string.producer), film.getProducer()));
                ui.tvReleaseDate.setText(film.getReleaseDate());
                ui.tvRate.setText(film.getRtScore());
            }
        });
    }


}
