package com.example.digitalseva;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WaterFragment extends Fragment implements View.OnClickListener {
    public WaterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_water2, container, false);
        Button button = view.findViewById(R.id.button);
        Button raisecomplaint = view.findViewById(R.id.raisecomplaint);
        Button feedback = view.findViewById(R.id.feedback);
        button.setOnClickListener(this);
        raisecomplaint.setOnClickListener(this);
        feedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            navigateToSubmit1Fragment();
        }
    }

    private void navigateToSubmit1Fragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Submit1Fragment submit1Fragment = new Submit1Fragment();
        fragmentTransaction.replace(R.id.container, submit1Fragment);
        fragmentTransaction.commit();
    }
}