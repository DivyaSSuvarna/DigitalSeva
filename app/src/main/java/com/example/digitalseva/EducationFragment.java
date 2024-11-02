package com.example.digitalseva;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EducationFragment extends Fragment implements View.OnClickListener {
    public EducationFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);
        Button button = view.findViewById(R.id.button4);
        Button raisecomplaint = view.findViewById(R.id.raisecomplaint4);
        Button feedback = view.findViewById(R.id.feedback4);
        button.setOnClickListener(this);
        raisecomplaint.setOnClickListener(this);
        feedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button4) {
            navigateToSubmit5Fragment();
        }
    }
    private void navigateToSubmit5Fragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Submit5Fragment submit5Fragment = new Submit5Fragment();
        fragmentTransaction.replace(R.id.container, submit5Fragment);
        fragmentTransaction.commit();
    }
}