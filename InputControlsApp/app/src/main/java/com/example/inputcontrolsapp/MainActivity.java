package com.example.inputcontrolsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.widget.*;

public class MainActivity extends AppCompatActivity {

    String[] courses = {"Android", "Java", "Python", "Flutter"};
    int progressValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toastButton = findViewById(R.id.toastButton);

        toastButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "This is a Toast Message!",
                        Toast.LENGTH_LONG).show()
        );

        // ImageButton
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v ->
                Toast.makeText(this, "Image Button Clicked!", Toast.LENGTH_SHORT).show()
        );

        // CheckBox
        CheckBox checkBox = findViewById(R.id.checkBox1);

        // RadioGroup
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        // ToggleButton
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        // Spinner
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // RatingBar
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        // ProgressBar
        ProgressBar progressBar = findViewById(R.id.progressBar);

        // Submit Button
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {

            // Increase progress dynamically
            progressValue += 10;

            if (progressValue > 100) {
                progressValue = 0; // Reset after 100
            }

            progressBar.setProgress(progressValue);

            // Collect all values
            String checkStatus = checkBox.isChecked() ?
                    "Mobile Technology Selected" :
                    "Mobile Technology Not Selected";

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedId);
            String gender = (radioButton != null) ?
                    radioButton.getText().toString() :
                    "No Gender Selected";

            String toggleStatus = toggleButton.isChecked() ?
                    "Toggle ON" : "Toggle OFF";

            String selectedCourse = spinner.getSelectedItem().toString();

            float rating = ratingBar.getRating();

            Toast.makeText(this,
                    checkStatus + "\n" +
                            "Gender: " + gender + "\n" +
                            toggleStatus + "\n" +
                            "Course: " + selectedCourse + "\n" +
                            "Rating: " + rating + "\n" +
                            "Progress: " + progressValue + "%",
                    Toast.LENGTH_LONG).show();
        });

        // Alert Dialog
        Button alertButton = findViewById(R.id.alertButton);
        alertButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alert Dialog");
            builder.setMessage("This is Alert Dialog Example");
            builder.setPositiveButton("OK", null);
            builder.setNegativeButton("Cancel", null);
            builder.show();
        });
    }
}