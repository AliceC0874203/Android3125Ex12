package com.example.android_3125_ex12;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.android_3125_ex12.databinding.ActivityCandidatesBinding;

public class CandidatesActivity extends AppCompatActivity {

    private ActivityCandidatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCandidatesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvCandidate1.setText("Candidate 1 got vote : " + VoteObj.getVoteNumberByCandidate(Candidate.candidate1));
        binding.tvCandidate2.setText("Candidate 2 got vote : " + VoteObj.getVoteNumberByCandidate(Candidate.candidate2));
        binding.tvCandidate3.setText("Candidate 3 got vote : " + VoteObj.getVoteNumberByCandidate(Candidate.candidate3));

        binding.tvCandidate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVoteActivityDetailByCandidate(Candidate.candidate1);
            }
        });

        binding.tvCandidate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVoteActivityDetailByCandidate(Candidate.candidate2);
            }
        });

        binding.tvCandidate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVoteActivityDetailByCandidate(Candidate.candidate3);
            }
        });
    }

    void goToVoteActivityDetailByCandidate(Candidate candidate) {
        Intent intent = new Intent(this, VoteActivity.class);
        intent.putExtra("candidate", candidate);
        startActivity(intent);
    }
}