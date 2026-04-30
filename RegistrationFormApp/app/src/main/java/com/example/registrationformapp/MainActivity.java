package com.example.registrationformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnSelectDOB, btnSubmit;
    TextView tvDOB, tvResult;

    int day, month, year;
    String selectedDOB = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.etName);
        btnSelectDOB = findViewById(R.id.btnSelectDOB);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvDOB = findViewById(R.id.tvDOB);
        tvResult = findViewById(R.id.tvResult);

        // Get current date
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        // DOB Button Click
        btnSelectDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {

                                selectedDOB = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                                tvDOB.setText("Selected DOB: " + selectedDOB);
                            }
                        },
                        year, month, day
                );

                datePickerDialog.show();
            }
        });

        // Submit Button Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();

                // Validation
                if (name.isEmpty()) {
                    etName.setError("Enter name");
                    return;
                }

                if (selectedDOB.isEmpty()) {
                    tvDOB.setText("Please select DOB");
                    return;
                }

                // Get current time
                long currentTime = System.currentTimeMillis();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedTime = sdf.format(currentTime);

                // Display result
                String result = "Name: " + name +
                        "\nDOB: " + selectedDOB +
                        "\nSubmitted at: " + formattedTime;

                tvResult.setText(result);
            }
        });
    }
}