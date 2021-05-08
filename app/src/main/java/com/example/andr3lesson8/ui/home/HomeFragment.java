package com.example.andr3lesson8.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.example.andr3lesson8.App;
import com.example.andr3lesson8.R;
import com.example.andr3lesson8.data.frameworks.retrofit.OnResultFilmListener;
import com.example.andr3lesson8.data.model.Film;
import com.example.andr3lesson8.databinding.FragmentHomeBinding;
import com.example.andr3lesson8.ui.base.BaseFragment;
import com.example.andr3lesson8.ui.details.DetailsFragment;
import com.example.andr3lesson8.ui.dialog.DialogQRCode;
import com.example.andr3lesson8.ui.home.adapters.FilmAdapter;
import com.example.andr3lesson8.ui.home.adapters.OnFilmListener;

import java.util.List;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements OnFilmListener {
    private FilmAdapter adapter;


    @Override
    protected FragmentHomeBinding bind() {
        return FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmAdapter();
        adapter.setListener(this);
        getFilms();
    }

    private void getFilms() {
        App.getFilmRepository().getFilms(new OnResultFilmListener() {
            @Override
            public void onSuccessList(List<Film> films) {
                adapter.addFilms(films);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpListeners();

    }

    private void setUpListeners() {
        ui.rvFilms.setAdapter(adapter);

        ui.btnScan.setOnClickListener(v -> {
            IntentIntegrator.forSupportFragment(this).initiateScan();
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result.getContents() != null) {
              navigateToDetails(DetailsFragment.newInstance(result.getContents()).getArguments());
        }
    }

    @Override
    public void openDialog(String id) {
        showQRCode(id);
    }

    private void showQRCode(String id) {
        DialogFragment dialog = DialogQRCode.newInstance(id);
        dialog.setCancelable(false);
        dialog.show(getParentFragmentManager(), getString(R.string.dialog_qr_code));
    }
}
