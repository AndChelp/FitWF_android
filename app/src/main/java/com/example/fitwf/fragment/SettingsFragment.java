package com.example.fitwf.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitwf.R;

import static com.example.fitwf.Utils.Resources.getStringByIdName;

public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        TextView textView = view.findViewById(R.id.textView6);
        textView.setText(getStringByIdName(getContext(), "liked"));
        return view;
    }
}
