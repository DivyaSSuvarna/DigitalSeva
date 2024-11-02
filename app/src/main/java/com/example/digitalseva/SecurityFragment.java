package com.example.digitalseva;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
public class SecurityFragment extends Fragment implements View.OnClickListener{
    public SecurityFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_security, container, false);
        Button button = view.findViewById(R.id.button5);
        Button raisecomplaint = view.findViewById(R.id.raisecomplaint5);
        Button feedback = view.findViewById(R.id.feedback5);
        button.setOnClickListener(this);
        raisecomplaint.setOnClickListener(this);
        feedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button5) {
            navigateToSubmit6Fragment();
        }
    }
    private void navigateToSubmit6Fragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Submit6Fragment submit6Fragment = new Submit6Fragment();
        fragmentTransaction.replace(R.id.container, submit6Fragment);
        fragmentTransaction.commit();
    }
}