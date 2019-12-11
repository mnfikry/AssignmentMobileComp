package com.example.assignmentmobilecomp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    private ArrayList<Question> mQuestionList;

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public QuestionAdapter(ArrayList<Question> questionsList) {
        mQuestionList = questionsList;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question, parent, false);
        QuestionViewHolder evh = new QuestionViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        Question  currentItem = mQuestionList.get(position);

        holder.mTextView1.setText(currentItem.getQuestion());
        holder.mTextView2.setText(currentItem.getAnswer());
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }


}
