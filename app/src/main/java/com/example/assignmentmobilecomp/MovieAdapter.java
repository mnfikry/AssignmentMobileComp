package com.example.assignmentmobilecomp;

import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Date;


public class MovieAdapter extends FirestoreRecyclerAdapter<Movie,MovieAdapter.MovieHolder> {
    private OnItemClickListener listener;


    public MovieAdapter(@NonNull FirestoreRecyclerOptions<Movie> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(MovieHolder holder, int position, Movie model) {
        holder.tvMovieTitle.setText(model.getTitle());
        holder.tvDescription.setText(model.getDescription());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String uncovertedTimeStamp = (model.getReleaseDate().toDate().toString());
        String ConvertedTimeStamp = simpleDateFormat.format(new Date(uncovertedTimeStamp));
        holder.tvReleaseDate.setText(ConvertedTimeStamp);
        Picasso.get().load(model.getImageLocation()).into(holder.moviePicture);
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movielist,parent,false);
        MovieHolder mh = new MovieHolder(v);
        return mh;
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        TextView tvMovieTitle;
        TextView tvDescription;
        TextView tvReleaseDate;
        ImageView moviePicture;

        public MovieHolder(View itemView) {
            super(itemView);

            tvMovieTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            moviePicture = itemView.findViewById(R.id.ivMovie);

            moviePicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && listener !=null){
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public Movie getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
