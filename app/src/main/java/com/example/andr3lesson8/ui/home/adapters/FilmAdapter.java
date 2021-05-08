package com.example.andr3lesson8.ui.home.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andr3lesson8.R;
import com.example.andr3lesson8.data.model.Film;
import com.example.andr3lesson8.databinding.ItemFilmBinding;
import com.example.andr3lesson8.ui.home.FilmTitles;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    private final List<Film> films;
    private OnFilmListener listener;

    public void setListener(OnFilmListener listener) {
        this.listener = listener;
    }

    public FilmAdapter() {
        films = new ArrayList<>();

    }

    public void addFilms(List<Film> films) {
        this.films.addAll(films);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding ui = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
    holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }


    public class FilmHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding ui;

        public FilmHolder(@NonNull ItemFilmBinding ui) {
            super(ui.getRoot());
            this.ui = ui;

        }

        public void onBind(Film film) {
            setPosters(film);
            onCLick(film);

        }

        private void onCLick(Film film) {
            itemView.setOnClickListener(v-> {
                listener.openDialog(film.getId());
            });
        }

        private void setPosters(Film film) {
            switch (film.getTitle()) {
                case FilmTitles.CASTLE_IN_THE_SKY:
                    ui.ivFilm.setImageResource(R.drawable.castle_in_the_sky);
                    break;
                case FilmTitles.GRAVE_OF_THE_FIREFLIES:
                    ui.ivFilm.setImageResource(R.drawable.grave_of_the_fireflies);
                    break;
                case FilmTitles.MY_NEIGHBOR_TOTORO:
                    ui.ivFilm.setImageResource(R.drawable.my_neighbor_totoro);
                    break;
                case FilmTitles.KIKIS_DELIVERY_SERVICE:
                    ui.ivFilm.setImageResource(R.drawable.kikis_delivery_service);
                    break;
                case FilmTitles.ONLY_YESTERDAY:
                    ui.ivFilm.setImageResource(R.drawable.only_yesterday);
                    break;
                case FilmTitles.PORCO_ROSSO:
                    ui.ivFilm.setImageResource(R.drawable.porco_rosso);
                    break;
                case FilmTitles.POM_POKO:
                    ui.ivFilm.setImageResource(R.drawable.pom_poko);
                    break;
                case FilmTitles.WHISPER_OF_THE_HEART:
                    ui.ivFilm.setImageResource(R.drawable.whisper_of_the_heart);
                    break;
                case FilmTitles.PRINCESS_MONONOKE:
                    ui.ivFilm.setImageResource(R.drawable.princess_mononoke);
                    break;
                case FilmTitles.MY_NEIGHBORS_THE_YAMADAS:
                    ui.ivFilm.setImageResource(R.drawable.my_neighbors_the_yamadas);
                    break;
                case FilmTitles.SPIRITED_AWAY:
                    ui.ivFilm.setImageResource(R.drawable.spirited_away);
                    break;
                case FilmTitles.THE_CAT_RETURNS:
                    ui.ivFilm.setImageResource(R.drawable.the_cat_returns);
                    break;
                case FilmTitles.HOWLS_MOVING_CASTLE:
                    ui.ivFilm.setImageResource(R.drawable.howls_moving_castle);
                    break;
                case FilmTitles.TALES_FROM_EARTSEA:
                    ui.ivFilm.setImageResource(R.drawable.tales_from_earthsea);
                    break;
                case FilmTitles.PONYO:
                    ui.ivFilm.setImageResource(R.drawable.ponyo);
                    break;
                case FilmTitles.ANRIETTY:
                    ui.ivFilm.setImageResource(R.drawable.arrietty);
                    break;
                case FilmTitles.FROM_UP_ON_POPPY_HILL:
                    ui.ivFilm.setImageResource(R.drawable.from_up_on_poppy_hill);
                    break;
                case FilmTitles.THE_WIND_RISES:
                    ui.ivFilm.setImageResource(R.drawable.the_wind_rises);
                    break;
                case FilmTitles.THE_TALE_OF_PRINCESS_KAGUYA:
                    ui.ivFilm.setImageResource(R.drawable.the_tale_of_princess_kaguya);
                    break;
                case FilmTitles.WHEN_MARNIE_WAS_THERE:
                    ui.ivFilm.setImageResource(R.drawable.when_marnie_was_there);
                    break;
                case FilmTitles.THE_RED_TURTLE:
                    ui.ivFilm.setImageResource(R.drawable.the_red_turtle);
                    break;
            }
        }
    }
}
