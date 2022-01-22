package com.example.tsaei;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home2 extends AppCompatActivity {

    private Button lessons;
    private Button quiz;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment2_layout);

        lessons = findViewById(R.id.m1);
        quiz = findViewById(R.id.m2);

        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2.this, macroeconLessons.class);
                startActivity(intent);
            }
        });
    }


}
