package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start, pause, reset;
    TextView stopwatch;
    Handler handler = new Handler();
    int count = 0;
    boolean isPaused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btn_start);
        pause = findViewById(R.id.btn_pause);
        reset = findViewById(R.id.btn_reset);
        stopwatch = findViewById(R.id.watch);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setText("Start");
                isPaused = false;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!isPaused) {
                            count++;
                            stopwatch.setText(String.valueOf(count));
                            handler.postDelayed(this, 500); // Update every second
                        }
                    }}, 500);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPaused = true;
                start.setText("Resume");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopwatch.setText("");
                stopwatch.setHint("Counter");
                start.setText("Start");
                isPaused = true;
                count = 0;
            }
        });
    }
}