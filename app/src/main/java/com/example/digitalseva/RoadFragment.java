package com.example.digitalseva;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RoadFragment extends Fragment implements View.OnClickListener {


    public RoadFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_road, container, false);
        Button button = view.findViewById(R.id.button2);
        Button raisecomplaint = view.findViewById(R.id.raisecomplaint2);
        Button feedback = view.findViewById(R.id.feedback2);
        button.setOnClickListener(this);
        raisecomplaint.setOnClickListener(this);
        feedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2) {
            navigateToSubmit3Fragment();
        }
    }
    private void navigateToSubmit3Fragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Submit3Fragment submit3Fragment = new Submit3Fragment();
        fragmentTransaction.replace(R.id.container, submit3Fragment);
        fragmentTransaction.commit();
    }
}