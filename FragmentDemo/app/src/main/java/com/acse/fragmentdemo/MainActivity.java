package com.acse.fragmentdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.acse.fragmentdemo.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String firstName1, lastName1, password1, userName1;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName1 = binding.firstName.getText().toString();
                lastName1 = binding.lastName.getText().toString();
                password1 = binding.password.getText().toString();
                userName1 = binding.userName.getText().toString();

                if (!firstName1.isEmpty() && !lastName1.isEmpty() && !password1.isEmpty() && !userName1.isEmpty()){

                    Users users = new Users(firstName1,lastName1,password1,userName1);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(userName1).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.firstName.setText("");
                            binding.lastName.setText("");
                            binding.password.setText("");
                            binding.userName.setText("");
                            Toast.makeText(MainActivity.this,"Successfuly Updated",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Login.class);
                            startActivity(intent);
                        }
                    });

                }
            }
        });
    }
}