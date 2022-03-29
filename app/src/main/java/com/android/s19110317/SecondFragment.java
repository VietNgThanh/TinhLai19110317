package com.android.s19110317;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
//import androidx.navigation.fragment.navArgs;

import com.android.s19110317.databinding.FragmentSecondBinding;

import java.text.DecimalFormat;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        double tienLai = Double.parseDouble(SecondFragmentArgs.fromBundle(getArguments()).getResult());
        double tienGui = Double.parseDouble(SecondFragmentArgs.fromBundle(getArguments()).getTienGui());
        double tienNhan = tienGui + tienLai;

        binding.textviewTienLai.setText(new DecimalFormat("###,### đ").format(tienLai));
        binding.textviewTotal.setText(new DecimalFormat("###,### đ").format(tienNhan));

        binding.buttonTakeAPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(openCamera);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}