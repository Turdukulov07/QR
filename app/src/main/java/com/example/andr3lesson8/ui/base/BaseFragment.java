package com.example.andr3lesson8.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.example.andr3lesson8.R;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB ui;
    protected abstract VB bind();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ui = bind();
        return ui.getRoot();
    }

    protected void navigateToDetails(Bundle bundle) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.detailsFragment, bundle);
    }

}
