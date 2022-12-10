package com.example.android_3125_ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android_3125_ex12.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add new vote
                String name = binding.edTxtName.getText().toString();
                String id = binding.edTxtID.getText().toString();
                int selectCandidate = binding.spinner.getSelectedItemPosition() - 1;
                boolean isAccept = binding.btnToggleAccept.isChecked();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input your name", Toast.LENGTH_SHORT).show();
                    return;
                } else if (id.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input your ID", Toast.LENGTH_SHORT).show();
                    return;
                } else if (selectCandidate < 0) {
                    Toast.makeText(MainActivity.this, "Plese select candidate", Toast.LENGTH_SHORT).show();
                    return;
                }

                VoteObj voteObj = new VoteObj(name, id, Candidate.values()[selectCandidate], isAccept);
                VoteObj.voteObjArrayList.add(voteObj);

                //open new act
                goToCandidatesActivity();
            }
        });
    }

    private void goToCandidatesActivity() {
        Intent intent = new Intent(this, CandidatesActivity.class);
        startActivity(intent);
    }
}