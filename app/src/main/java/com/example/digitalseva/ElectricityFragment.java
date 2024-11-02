package com.example.digitalseva;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ElectricityFragment extends Fragment implements View.OnClickListener{
    public ElectricityFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_electricity, container, false);
        Button button = view.findViewById(R.id.button1);
        Button raisecomplaint = view.findViewById(R.id.raisecomplaint1);
        Button feedback = view.findViewById(R.id.feedback1);
        button.setOnClickListener(this);
        raisecomplaint.setOnClickListener(this);
        feedback.setOnClickListener(this);
       return view;
    }

    @Override

    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            navigateToSubmit2Fragment();
        }
    }

    private void navigateToSubmit2Fragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Submit2Fragment submit2Fragment = new Submit2Fragment();
        fragmentTransaction.replace(R.id.container, submit2Fragment);
        fragmentTransaction.commit();
    }
}