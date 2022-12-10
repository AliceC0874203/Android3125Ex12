package com.example.android_3125_ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.android_3125_ex12.databinding.ActivityVoteBinding;

import java.util.ArrayList;

public class VoteActivity extends AppCompatActivity {

    private ActivityVoteBinding binding;
    Candidate candidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            candidate = (Candidate) extras.getSerializable("candidate");
            //The key argument here must match that used in the other activity
        }

        Object[] arrayList = VoteObj.getVoteObjArrayListByCandidate(candidate);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        binding.list.setAdapter(adapter);
    }
}