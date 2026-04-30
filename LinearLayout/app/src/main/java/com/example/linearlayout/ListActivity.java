package com.example.linearlayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    String[] mobileArray = {
            "Android",
            "iPhone",
            "Windows Mobile",
            "Blackberry",
            "WebOS",
            "Ubuntu",
            "Windows 7",
            "Mac OS X"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.mobile_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item,
                R.id.label,
                mobileArray
        );

        listView.setAdapter(adapter);
    }
}