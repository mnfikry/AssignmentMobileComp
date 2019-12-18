package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class showtimeActivity extends AppCompatActivity {
    TextView textViewTitle;
    TextView time;
    FirebaseFirestore firebaseFirestore;
    CollectionReference databaseReference;
    DocumentReference docReferenceMovie;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference dr;
    private String TAG;
    int point;
    Boolean compareTest = Boolean.FALSE;
    String documentPath = "";
    String seatPlace = "";
    String seatUser = "";
    String userSeat;
    Spinner spinner;
    Date uncovertedTimeStamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtime);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String movieTitle = extras.getString("TITLE");

        Button bBook = findViewById(R.id.bBook);
        textViewTitle = findViewById(R.id.tvTitle);
        time = findViewById(R.id.tvTime);
        spinner = (Spinner)findViewById(R.id.spinnerTime);

        textViewTitle.setText(movieTitle);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(showtimeActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.seat));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        final android.icu.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd yyyy, hh:mm a");

        firebaseFirestore = FirebaseFirestore.getInstance();
        if(movieTitle.equals("Ejen Ali")){
            databaseReference = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Ejen Ali").collection("showTime");
            docReferenceMovie = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Ejen Ali").collection("showTime").document("eaST");
            docReferenceMovie.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    uncovertedTimeStamp = documentSnapshot.getDate("timeScreening");
                    String ConvertedTimeStamp = simpleDateFormat.format((uncovertedTimeStamp));
                    time.setText(ConvertedTimeStamp);
                }
            });
        }
        else if(movieTitle.equals("Frozen 2")){
            databaseReference = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Frozen 2").collection("showTime");
            docReferenceMovie = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Frozen 2").collection("showTime").document("f2ST");
            docReferenceMovie.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    uncovertedTimeStamp = documentSnapshot.getDate("timeScreening");
                    String ConvertedTimeStamp = simpleDateFormat.format((uncovertedTimeStamp));
                    time.setText(ConvertedTimeStamp);
                }
            });
        }
        else if(movieTitle.equals("Joker")){
            databaseReference = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Joker").collection("showTime");
            docReferenceMovie = firebaseFirestore.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie").document("Joker").collection("showTime").document("jkST");
            docReferenceMovie.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    uncovertedTimeStamp = documentSnapshot.getDate("timeScreening");
                    String ConvertedTimeStamp = simpleDateFormat.format((uncovertedTimeStamp));
                    time.setText(ConvertedTimeStamp);
                }
            });
        }

        bBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSeat = spinner.getSelectedItem().toString();
                bookSeat(userSeat,movieTitle);
            }
        });
    }

    public void bookSeat(String placeSeat, String movieTitle){
        if(movieTitle.equals("Ejen Ali")){
            documentPath = "eaST";
        }
        else if (movieTitle.equals("Frozen 2")){
            documentPath = "f2ST";
        }
        else if (movieTitle.equals("Joker")){
            documentPath = "jkST";
        }
        if(placeSeat.equals("Seat 1")) {
            seatPlace = "seat1";
            seatUser = "userSeat1";
        }
        else if(placeSeat.equals("Seat 2")){
            seatPlace = "seat2";
            seatUser = "userSeat2";
        }
        else if(placeSeat.equals("Seat 3")){
            seatPlace = "seat3";
            seatUser = "userSeat3";
        }
        else if(placeSeat.equals("Seat 4")){
            seatPlace = "seat4";
            seatUser = "userSeat4";
        }
        else if(placeSeat.equals("Seat 5")){
            seatPlace = "seat5";
            seatUser = "userSeat5";
        }
        final Map<String, Object> data = new HashMap<>();
        data.put(seatPlace, true);
        data.put(seatUser,user.getUid());
        databaseReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot documentSnapshot : task.getResult()) {
                        compareTest = documentSnapshot.getBoolean(seatPlace);
                        if (Boolean.FALSE.equals(compareTest)) {
                            databaseReference.document(documentPath).update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(showtimeActivity.this, "You have booked "+ seatPlace+". Thanks and enjoy your movie!", Toast.LENGTH_SHORT).show();
                                    dr = firebaseDatabase.getReference("users/" + user.getUid());
                                    dr.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            point = dataSnapshot.child("point").getValue(int.class);
                                            point += 50;
                                            dr.child("point").setValue(point);
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                }
                            });
                        }
                        else{
                            Toast.makeText(showtimeActivity.this, "This seating have been booked by someone else", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
