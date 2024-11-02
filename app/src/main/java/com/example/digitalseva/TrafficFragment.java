package com.example.digitalseva;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TrafficFragment extends Fragment implements View.OnClickListener{
    public TrafficFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_traffic, container, false);
        Button button = view.findViewById(R.id.button3);
        Button raisecomplaint = view.findViewById(R.id.raisecomplaint3);
        Button feedback = view.findViewById(R.id.feedback3);
        button.setOnClickListener(this);
        raisecomplaint.setOnClickListener(this);
        feedback.setOnClickListener(this);
       return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            navigateToSubmit4Fragment();
        }
    }
    private void navigateToSubmit4Fragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Submit4Fragment submit4Fragment = new Submit4Fragment();
        fragmentTransaction.replace(R.id.container, submit4Fragment);
        fragmentTransaction.commit();
    }
}