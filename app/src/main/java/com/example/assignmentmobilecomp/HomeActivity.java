package com.example.assignmentmobilecomp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference movieRef = db.collection("cinemasLocation");
    RecyclerView.LayoutManager layoutManager;
    private FirestoreRecyclerAdapter<Location, LocationViewHolder> adapter;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("TAG","onCreate() called");

        Button buttonPI = (Button)findViewById(R.id.bPI);
        Button buttonMA = (Button)findViewById(R.id.bMovie);
        Button buttonFAQ = (Button)findViewById(R.id.bFAQ);
        Button buttonShowtime = (Button)findViewById(R.id.bShowtime);
        Toolbar toolbar = (Toolbar)findViewById(R.id.TB);
        setSupportActionBar(toolbar);


        buttonPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HomeActivity.this,AccountInformation.class);
                startActivity(intent);
            }
        });

        buttonMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MovieActivity.class);
                startActivity(intent);
            }
        });

        buttonFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,FAQActivity.class);
                startActivity(intent);
            }
        });

        buttonShowtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,showtimeActivity.class);
                startActivity(intent);
            }
        });

        Query query = movieRef.orderBy("title",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Location> options = new FirestoreRecyclerOptions.Builder<Location>()
                .setQuery(query,Location.class)
                .build();

        recyclerView = findViewById(R.id.rvCinema);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FirestoreRecyclerAdapter<Location, LocationViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull LocationViewHolder holder, int position, @NonNull Location model) {
                holder.setData(model.address,model.image,model.located,model.phone,model.title);
            }

            @NonNull
            @Override
            public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinemalist,parent,false);
                return new LocationViewHolder(view);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logOut:
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent ( HomeActivity.this,MainActivity.class);
                startActivity(intToMain);
                finish();
                return true;
            default:
                onResume();
                return super.onOptionsItemSelected(item);
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
