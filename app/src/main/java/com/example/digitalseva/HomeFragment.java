package com.example.digitalseva;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class HomeFragment extends Fragment implements View.OnClickListener{
    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CardView water = view.findViewById(R.id.water);
        CardView electricity = view.findViewById(R.id.electricity);
        CardView road = view.findViewById(R.id.road);
        CardView traffic = view.findViewById(R.id.traffic);
        CardView education = view.findViewById(R.id.education);
        CardView security = view.findViewById(R.id.security);
        water.setOnClickListener(this);
        electricity.setOnClickListener(this);
        road.setOnClickListener(this);
        traffic.setOnClickListener(this);
        education.setOnClickListener(this);
        security.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.water){
            navigateToWaterFragment();
        }
        else if (view.getId()==R.id.electricity){
            navigateToElectricityFragment();
        }
        else if (view.getId()==R.id.road){
            navigateToRoadFragment();
        }
        else if (view.getId()==R.id.traffic){
            navigateToTrafficFragment();
        }
        else if (view.getId()==R.id.education){
            navigateToEducationFragment();
        }
        else if (view.getId()==R.id.security){
            navigateToSecurityFragment();
        }
    }

    private void navigateToWaterFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WaterFragment waterFragment = new WaterFragment();
        fragmentTransaction.replace(R.id.container,waterFragment);
        fragmentTransaction.commit();
    }
    private void navigateToElectricityFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ElectricityFragment electricityFragment = new ElectricityFragment();
        fragmentTransaction.replace(R.id.container,electricityFragment);
        fragmentTransaction.commit();
    }

    private void navigateToRoadFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RoadFragment roadFragment = new RoadFragment();
        fragmentTransaction.replace(R.id.container,roadFragment);
        fragmentTransaction.commit();
    }


    private void navigateToTrafficFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TrafficFragment trafficFragment = new TrafficFragment();
        fragmentTransaction.replace(R.id.container,trafficFragment);
        fragmentTransaction.commit();
    }

    private void navigateToEducationFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EducationFragment educationFragment = new EducationFragment();
        fragmentTransaction.replace(R.id.container,educationFragment);
        fragmentTransaction.commit();
    }

    private void navigateToSecurityFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SecurityFragment securityFragment = new SecurityFragment();
        fragmentTransaction.replace(R.id.container,securityFragment);
        fragmentTransaction.commit();
    }
    private void navigateToUploadFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        UploadFragment uploadFragment = new UploadFragment();
        fragmentTransaction.replace(R.id.container,uploadFragment);
        fragmentTransaction.commit();
    }

}
