package com.example.logactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.logactivity.databinding.ActivitySign2Binding;

public class signActivity2 extends AppCompatActivity {

    ActivitySign2Binding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySign2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String email = binding.signupEmail.getText().toString();
                    String password = binding.signupPassword.getText().toString();
                    String confirmPassword = binding.signupConfirm.getText().toString();

                    if (email.equals("") || password.equals("") || confirmPassword.equals(""))
                        Toast.makeText(signActivity2.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                    else {
                        if(password.equals(confirmPassword)){
                            Boolean checkUserEmail = databaseHelper.checkEmail(email);

                            if(checkUserEmail == false){
                                Boolean insert = databaseHelper.insertData(email, password);

                                if(insert == true){
                                    Toast.makeText(signActivity2.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), logActivity2.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(signActivity2.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(signActivity2.this, "User already exists, please login", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(signActivity2.this, "Invalid password", Toast.LENGTH_SHORT).show();
                        }
                    }

            }
        });

        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), logActivity2.class);
                startActivity(intent);
            }
        });


        }
    }
