package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText editTextEmail;
    EditText editTextPassword;
    String email,pwd;
    Button buttonSignUp;
    FirebaseAuth firebaseAuth;
    TextView textViewLogin;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPassword);
        buttonSignUp = findViewById(R.id.bSighUp);
        textViewLogin = findViewById(R.id.tvLogin);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser != null){
                    Toast.makeText(MainActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    //Toast.makeText(LoginActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                pwd = editTextEmail.getText().toString();

                if(email.isEmpty()){
                    editTextEmail.setError("Please enter your email");
                    editTextEmail.requestFocus();
                }
                else if(pwd.isEmpty()){
                    editTextPassword.setError("Please enter your password");
                    editTextPassword.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    firebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Sign Up Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                String uid = firebaseAuth.getUid();
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                                databaseReference = firebaseDatabase.getReference("users").child(uid).child("email");
                                databaseReference.setValue(email);
                                databaseReference = firebaseDatabase.getReference("users").child(uid).child("name");
                                databaseReference.setValue("Null");
                                databaseReference = firebaseDatabase.getReference("users").child(uid).child("address");
                                databaseReference.setValue("Null");
                                databaseReference = firebaseDatabase.getReference("users").child(uid).child("birthday");
                                databaseReference.setValue("Null");
                                databaseReference = firebaseDatabase.getReference("users").child(uid).child("point");
                                databaseReference.setValue(0);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onBackPressed() {
    }
}
