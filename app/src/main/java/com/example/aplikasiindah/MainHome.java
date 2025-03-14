package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainHome extends AppCompatActivity {

    private Button btnHome, btnProfile, btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inisialisasi tombol navigasi
        btnHome = findViewById(R.id.btn_home);
        btnProfile = findViewById(R.id.btn_profile);
        btnSetting = findViewById(R.id.btn_setting);


        // Event listener untuk tombol navigasi
        btnHome.setOnClickListener(v -> {
            // Tetap di halaman home
        });

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainProfile.class);
            startActivity(intent);
        });

        btnSetting.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainSetting.class);
            startActivity(intent);
        });
    }
}