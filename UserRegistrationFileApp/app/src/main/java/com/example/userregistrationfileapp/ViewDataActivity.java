package com.example.userregistrationfileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ViewDataActivity extends AppCompatActivity {

    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        tableLayout = findViewById(R.id.tableLayout);

        readData();
    }

    private void readData() {
        try {
            FileInputStream fis = openFileInput("user_data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                TableRow row = new TableRow(this);

                for (String part : parts) {
                    TextView tv = new TextView(this);
                    tv.setText(part);
                    tv.setPadding(10, 10, 10, 10);
                    row.addView(tv);
                }

                tableLayout.addView(row);
            }

            reader.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}