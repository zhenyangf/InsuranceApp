package com.example.insuranceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);
        mPhone = findViewById(R.id.Phone);
        mRegisterBtn = findViewById(R.id.Register);
        mLoginBtn = findViewById(R.id.createText);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),Insurance1.class));
            finish();
        }



        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mFullName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(name)) {
                   mFullName.setError("Full name is required");
                    return;
               }if(TextUtils.isEmpty(phone)) {
                    mPhone.setError("Phone number is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }
                if(password.length()<6){
                    mPassword.setError("Password must be longer than 6 characters");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"Account created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Insurance1.class));
                        } else{
                            Toast.makeText(Register.this, "Error! ", Toast.LENGTH_SHORT).show();

                        }
                    }
                });




            }
        });

    }
}