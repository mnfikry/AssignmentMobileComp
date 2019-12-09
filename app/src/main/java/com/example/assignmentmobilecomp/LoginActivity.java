package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignIn;
    FirebaseAuth firebaseAuth;
    TextView textViewSignUp;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.etSignInEmail);
        editTextPassword = findViewById(R.id.etSignInPassword);
        buttonSignIn = findViewById(R.id.bSignIn);
        textViewSignUp = findViewById(R.id.tvSignUp);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser != null){
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String pwd = editTextEmail.getText().toString();

                if(email.isEmpty()){
                    editTextEmail.setError("Please enter your email");
                    editTextEmail.requestFocus();
                }
                else if(pwd.isEmpty()){
                    editTextPassword.setError("Please enter your password");
                    editTextPassword.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    firebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intToHome = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(LoginActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intSignUp);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}
