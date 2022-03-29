package com.android.s19110317;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.s19110317.databinding.FragmentFirstBinding;

import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                double tienGui = Double.parseDouble(Objects.requireNonNull(binding.editTienGui.getText()).toString());
                double laiSuat = Double.parseDouble(Objects.requireNonNull(binding.editLaiSuat.getText()).toString());
                double kyHan = Double.parseDouble(Objects.requireNonNull(binding.editKyHan.getText()).toString());

                String result = String.valueOf(tinhTienLai(tienGui, laiSuat, kyHan));

                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(result, String.valueOf(tienGui));

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(action);
            }
        });
    }

    private double tinhTienLai(double tienGui, double laiSuat, double kyHan) {
        return tienGui * laiSuat / 100 * kyHan / 12;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}