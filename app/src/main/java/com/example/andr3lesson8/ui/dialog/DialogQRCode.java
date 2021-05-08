package com.example.andr3lesson8.ui.dialog;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.example.andr3lesson8.databinding.DialogWindowBinding;

import java.util.Objects;


public class DialogQRCode extends DialogFragment {

    private DialogWindowBinding ui;
    private static final String ARG_FILM_ID = "film_id";
    private String filmID;

    public DialogQRCode() {
    }

    public static DialogQRCode newInstance(String filmID) {
        Bundle args = new Bundle();
        args.putString(ARG_FILM_ID, filmID);
        DialogQRCode fragment = new DialogQRCode();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ui = DialogWindowBinding.inflate(getLayoutInflater(), container, false);
        return ui.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpListeners();
    }

    private void setUpListeners() {

        ui.tvClose.setOnClickListener(v -> {
            Objects.requireNonNull(getDialog()).dismiss();
        });

        ui.btnDone.setOnClickListener(v-> {
            Objects.requireNonNull(getDialog()).dismiss();
        });

        generateQRCode();

    }

    private void generateQRCode() {

        if (getArguments() != null)
            filmID = getArguments().getString(ARG_FILM_ID);

        BarcodeEncoder encoder = new BarcodeEncoder();
        try {
            Bitmap qrCode = encoder.encodeBitmap(filmID, BarcodeFormat.QR_CODE, 700, 700);
            ui.ivQRCode.setImageBitmap(qrCode);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

}
