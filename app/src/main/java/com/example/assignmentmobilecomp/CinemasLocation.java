package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

public class CinemasLocation extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference movieRef = db.collection("cinemasLocation");
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private FirestoreRecyclerAdapter<Location, LocationViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemas_location);
        Query query = movieRef.orderBy("title",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Location> options = new FirestoreRecyclerOptions.Builder<Location>()
                .setQuery(query,Location.class)
                .build();

        recyclerView = findViewById(R.id.rvCinema);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FirestoreRecyclerAdapter<Location, CinemasLocation.LocationViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CinemasLocation.LocationViewHolder holder, int position, @NonNull Location model) {
                holder.setData(model.address,model.image,model.located,model.phone,model.title);
            }

            @NonNull
            @Override
            public CinemasLocation.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinemalist,parent,false);
                return new CinemasLocation.LocationViewHolder(view);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    private class LocationViewHolder extends RecyclerView.ViewHolder{
        private View view;
        LocationViewHolder(View itemView){
            super(itemView);
            view = itemView;
        }

        void setData(String address, String image, String located, String phone, String title){
            TextView tvTitleLocation;
            TextView tvLocation;
            TextView tvPhone;
            ImageView moviePicture;
            tvTitleLocation = itemView.findViewById(R.id.tvTitleLocation);
            tvLocation = itemView.findViewById(R.id.tvAddress);
            tvPhone = itemView.findViewById(R.id.tvContact);
            moviePicture = itemView.findViewById(R.id.ivLocation);
            // Set data to views
            tvTitleLocation.setText(title);
            tvLocation.setText(located);
            tvPhone.setText(phone);
            Picasso.get().load(image).into(moviePicture);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        Log.d("TAG","onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
        Log.d("TAG","onStop() called");
    }
}
