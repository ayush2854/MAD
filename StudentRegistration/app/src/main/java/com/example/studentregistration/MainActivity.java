package com.example.studentregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etRoll, etCourse, etMobile;
    Button btnRegister;
    ListView listViewStudents;

    ArrayList<String> studentList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etRoll = findViewById(R.id.etRoll);
        etCourse = findViewById(R.id.etCourse);
        etMobile = findViewById(R.id.etMobile);
        btnRegister = findViewById(R.id.btnRegister);
        listViewStudents = findViewById(R.id.listViewStudents);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                studentList);

        listViewStudents.setAdapter(adapter);

        btnRegister.setOnClickListener(v -> registerStudent());
    }

    private void registerStudent() {
        String name = etName.getText().toString().trim();
        String roll = etRoll.getText().toString().trim();
        String course = etCourse.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();

        if (name.isEmpty() || roll.isEmpty() || course.isEmpty() || mobile.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }

        String studentData = "Name: " + name +
                "\nRoll: " + roll +
                "\nCourse: " + course +
                "\nMobile: " + mobile;

        studentList.add(studentData);
        adapter.notifyDataSetChanged();

        clearFields();

        Toast.makeText(this, "Student Registered", Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        etName.setText("");
        etRoll.setText("");
        etCourse.setText("");
        etMobile.setText("");
        etName.requestFocus();
    }
}