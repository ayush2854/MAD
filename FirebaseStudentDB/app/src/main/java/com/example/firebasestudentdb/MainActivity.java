package com.example.firebasestudentdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference db;
    Button b1, b2;
    EditText eid, ename;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Database reference
        db = FirebaseDatabase.getInstance().getReference("Students");

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        eid = findViewById(R.id.editText1);
        ename = findViewById(R.id.editText2);
        t1 = findViewById(R.id.textView3);

        // Insert Record
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = eid.getText().toString().trim();
                String name = ename.getText().toString().trim();

                if (id.isEmpty() || name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Using Roll No as key
                db.child(id).child("name").setValue(name)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(MainActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                            eid.setText("");
                            ename.setText("");
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            }
        });

        // Display Data
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1.setText("Loading...");

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            StringBuilder str = new StringBuilder();
                            for (DataSnapshot child : snapshot.getChildren()) {
                                String rollNo = child.getKey();
                                String studentName = child.child("name").getValue(String.class);
                                str.append("ID: ").append(rollNo)
                                        .append(" Name: ").append(studentName)
                                        .append("\n");
                            }
                            t1.setText(str.toString());
                        } else {
                            t1.setText("No Records Found");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        t1.setText("Error: " + error.getMessage());
                    }
                });
            }
        });
    }
}