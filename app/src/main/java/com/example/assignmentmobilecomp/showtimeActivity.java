package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class showtimeActivity extends AppCompatActivity {
    TextView textViewTitle;
    FirebaseFirestore firebaseFirestore;
    CollectionReference databaseReference;
    String seatCloud;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtime);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String movieTitle = extras.getString("TITLE");

        Button bBook = findViewById(R.id.bBook);
        textViewTitle = findViewById(R.id.tvTitle);
        Spinner spinner = (Spinner)findViewById(R.id.spinnerTime);

        textViewTitle.setText(movieTitle);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(showtimeActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.seat));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        if(movieTitle.equals("Ejen Ali")){
            databaseReference = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Ejen Ali").collection("showTime");
        }
        if(movieTitle.equals("Frozen 2")){
            databaseReference = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Frozen 2").collection("showTime");
        }
        if(movieTitle.equals("Joker")){
            databaseReference = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Joker").collection("showTime");
        }

        final String userSeat = spinner.getSelectedItem().toString();

        bBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userSeat.equals("Seat 1")){
                     databaseReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                         @Override
                         public void onComplete(@NonNull Task<QuerySnapshot> task) {
                             if(task.isSuccessful()){
                                 for(DocumentSnapshot documentSnapshot : task.getResult()){
                                     boolean compareTest = documentSnapshot.getBoolean("seat1");
                                     if(Boolean.FALSE.equals(compareTest)){
                                        //databaseReference.document("eaST").update({"seat1": Boolean.TRUE});
                                         //return databaseReference.document("eaST").update({"seat1": true});
                                         firebaseFirestore.batch().update(databaseReference,"seat1",true);
                                     }
                                 }
                             }
                         }
                     });
                }
                else if (userSeat.equals("Seat 2")){

                }
                else if (userSeat.equals("Seat 3")){

                }
                else if (userSeat.equals("Seat 4")){

                }
                else{

                }
            }
        });


    }
}
