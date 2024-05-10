package com.example.registrationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LogOutFragment extends Fragment {

    EditText first,last,gender,dob,address;
    Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_out, container, false);

        helper shared = new ViewModelProvider(requireActivity()).get(helper.class);

        first = view.findViewById(R.id.firstname2);
        last = view.findViewById(R.id.lastname2);
        gender = view.findViewById(R.id.gender2);
        dob = view.findViewById(R.id.dob2);
        address = view.findViewById(R.id.address2);
        logout = view.findViewById(R.id.logout);

        shared.getFname().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

                first.setText("First Name : " + s);
            }
        });

        shared.getLname().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                last.setText("Last Name : " + s);;
            }
        });

        shared.getGen().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                gender.setText("Gender : " + s);
            }
        });

        shared.getDob().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                dob.setText("Date of Birth : " + s);
            }
        });

        shared.getAddr().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                address.setText("Address : " + s);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).replacetopfrag(new BlankFragment());
                ((MainActivity) requireActivity()).replacebottomfrag(new ButtonFragment());
            }
        });


        return view;
    }
}