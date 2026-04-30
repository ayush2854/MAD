package com.example.seekbarapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMessage = findViewById(R.id.t);
        seekbar = findViewById(R.id.seekbar);

        // Set initial text size based on SeekBar progress
        textMessage.setTextSize(seekbar.getProgress() + 1);

        // Listener for SeekBar changes
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Increase text size dynamically
                textMessage.setTextSize(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: You can show a Toast or log here
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: You can show a Toast or log here
            }
        });
    }
}