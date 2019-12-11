package com.example.assignmentmobilecomp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class EditPersonalInfo extends AppCompatActivity {
    FirebaseUser userDatabase = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd yyyy");
    EditText name,address;
    DatePicker datePicker;
    Button save,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_info);
        name = findViewById(R.id.et1);
        address = findViewById(R.id.et2);
        datePicker = findViewById(R.id.datePicker1);
        save = findViewById(R.id.bSave);
        back = findViewById(R.id.bBack);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day);

                String editedName = name.getText().toString();
                String editedAddress = address.getText().toString();
                String editedBirthday = simpleDateFormat.format(calendar.getTime());
                User user = new User(editedAddress,editedBirthday,editedName,userDatabase.getEmail());
                databaseReference.child("users").child(userDatabase.getUid()).setValue(user);
                Toast.makeText(EditPersonalInfo.this, "Successful Edited", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPersonalInfo.this,AccountInformation.class);
                startActivity(intent);
            }
        });

    }
}
