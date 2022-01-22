package com.example.tsaei;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home3 extends AppCompatActivity {

    private Button lessons;
    private Button quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment3_layout);

        lessons = findViewById(R.id.i1);
        quiz = findViewById(R.id.i2);

        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home3.this, investingLessons.class);
                startActivity(intent);
            }
        });
    }
}
