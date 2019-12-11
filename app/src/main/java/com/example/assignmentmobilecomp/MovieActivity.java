package com.example.assignmentmobilecomp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MovieActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference movieRef = db.collection("moviesAvailable").document("DPNGn5E955qQCBkaATQA").collection("movie");
    RecyclerView.LayoutManager layoutManager;

    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setUpRecyclerView();
    }
    private void setUpRecyclerView(){
        Query query = movieRef.orderBy("releaseDate",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Movie> options = new FirestoreRecyclerOptions.Builder<Movie>()
                .setQuery(query,Movie.class)
                .build();

        recyclerView = findViewById(R.id.rvMovie);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MovieAdapter(options);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                Movie movie =documentSnapshot.toObject(Movie.class);
                String movieTitle = movie.getTitle();
                Intent intent = new Intent(MovieActivity.this,showtimeActivity.class);
                Bundle extras = new Bundle();
                extras.putString("TITLE",movieTitle);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
