package com.acse.fragmentdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acse.fragmentdemo.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    ActivityMainBinding binding;
    EditText firstName, lastName, passwrd, userName;
    Button logout, update;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String un=getIntent().getStringExtra("username");
        String ps=getIntent().getStringExtra("password");

        firstName=findViewById(R.id.firstName1);
        lastName=findViewById(R.id.lastName1);
        passwrd=findViewById(R.id.passwrd1);
        userName=findViewById(R.id.userName1);
        update=findViewById(R.id.update);
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        if(un!=null)
        {
            reference.orderByChild("userName").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        String name=snapshot1.child("userName").getValue().toString();
                        if(name.equals(un))
                        {
                            String passwordFromDB = snapshot.child(un).child("password").getValue(String.class);
                            String nameFromDB = snapshot.child(un).child("firstName").getValue(String.class);
                            String lastFromDB = snapshot.child(un).child("lastName").getValue(String.class);
                            String usernameFromDB = snapshot.child(un).child("userName").getValue(String.class);
                            firstName.setText(nameFromDB);
                            lastName.setText(lastFromDB);
                            passwrd.setText(passwordFromDB);
                            userName.setText(usernameFromDB);
                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateUserData(String.valueOf(firstName.getText()),String.valueOf(lastName.getText()),String.valueOf(userName.getText()),String.valueOf(passwrd.getText()));
                    Toast.makeText(getApplicationContext(),firstName.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void updateUserData(String firstName, String lastName, String userName, String passwrd) {
        HashMap User = new HashMap();
        User.put("firstName",firstName);
        User.put("lastName",lastName);
        User.put("userName",userName);
        User.put("password",passwrd);
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(userName).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    Toast.makeText(Home.this,"Successfully Updated",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Home.this,"Failed to Update",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}