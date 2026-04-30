package com.example.socialmedialauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnWhatsapp, btnInstagram, btnFacebook, btnTwitter, btnYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnInstagram = findViewById(R.id.btnInstagram);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnTwitter = findViewById(R.id.btnTwitter);
        btnYoutube = findViewById(R.id.btnYoutube);

        btnWhatsapp.setOnClickListener(v -> openApp("com.whatsapp"));
        btnInstagram.setOnClickListener(v -> openApp("com.instagram.android"));
        btnFacebook.setOnClickListener(v -> openApp("com.facebook.katana"));
        btnTwitter.setOnClickListener(v -> openApp("com.twitter.android"));
        btnYoutube.setOnClickListener(v -> openApp("com.google.android.youtube"));
    }

    private void openApp(String packageName) {
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);

        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "App not installed", Toast.LENGTH_SHORT).show();
        }
    }
}