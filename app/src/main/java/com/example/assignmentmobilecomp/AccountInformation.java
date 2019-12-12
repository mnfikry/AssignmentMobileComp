package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class AccountInformation extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    TextView uAddress;
    TextView uBirthday;
    TextView uName;
    TextView uPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);
        Button buttonHome = (Button)findViewById(R.id.bHome);
        Button buttonEdit = (Button)findViewById(R.id.bEdit);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tbUserInformation);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        TextView email = findViewById(R.id.uEmail);
        uAddress = findViewById(R.id.uAddress);
        uBirthday = findViewById(R.id.uBirthday);
        uName = findViewById(R.id.uName);
        uPoint = findViewById(R.id.uPoint);
        toolbar.setTitle("User Information");
        email.setText(user.getEmail());

        databaseReference = database.getReference("users/"+ user.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Address  = dataSnapshot.child("address").getValue(String.class);
                String Birthday = dataSnapshot.child("birthday").getValue(String.class);
                String Name = dataSnapshot.child("name").getValue(String.class);
                int Point = dataSnapshot.child("point").getValue(Integer.class);
                uAddress.setText(Address);
                uBirthday.setText(Birthday);
                uName.setText(Name);
                uPoint.setText(String.valueOf(Point));

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountInformation.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountInformation.this, EditPersonalInfo.class);
                startActivity(intent);
            }
        });

    }
}
