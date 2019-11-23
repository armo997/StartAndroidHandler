package com.example.startandroidhandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startButton;
    TextView textView;
    Handler handler;
    private Handler mHandler;
    boolean gameOn;
    long startTime;
    boolean b = false;
    int i = 1;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        textView = findViewById(R.id.textView);
        handler = new Handler();
        startButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startButton:
                textView.setText("Turning ON");
                startButton.setEnabled(false);
                b = true;
                handler.postDelayed(runnable, 1000);
                textView.setText("OFF");
                startButton.setEnabled(true);
                break;
        }
    }

    @SuppressLint("HandlerLeak")
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (i > 10){
                handler.removeCallbacks(runnable);
                b = false;
            }

//            if (b){
                textView.setText("Downloading " + i);
                Log.i("aaaaa", Integer.toString(i));
//            }

            i++;

            handler.postDelayed(runnable, 1000);
        }
    };

    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
}