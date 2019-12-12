package com.example.assignmentmobilecomp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class showTimeAdapter extends FirestoreRecyclerAdapter<showTime,showTimeAdapter.showTimeHolder> {

    public showTimeAdapter(@NonNull FirestoreRecyclerOptions<showTime> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull showTimeAdapter.showTimeHolder holder, int position, @NonNull showTime model) {

    }

    @NonNull
    @Override
    public showTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    class showTimeHolder extends RecyclerView.ViewHolder{

        public showTimeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
