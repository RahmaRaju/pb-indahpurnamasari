package com.example.aplikasiindah;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Mainnotification extends AppCompatActivity {

    private ImageButton btnBack;
    private TextView tvNotification1, tvNotification2, tvNotification3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnotification); // Pastikan ini sesuai dengan nama layout XML

        // Inisialisasi view
        btnBack = findViewById(R.id.btn_back);
        tvNotification1 = findViewById(R.id.notification1);
        tvNotification2 = findViewById(R.id.notification2); // Perbaikan di sini
        tvNotification3 = findViewById(R.id.notification3);

        // Tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke activity sebelumnya
            }
        });

        // Klik notifikasi pertama
        tvNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mainnotification.this, "Klik notifikasi 1", Toast.LENGTH_SHORT).show();
            }
        });

        // Klik notifikasi kedua
        tvNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mainnotification.this, "Klik notifikasi 2", Toast.LENGTH_SHORT).show();
            }
        });

        // Klik notifikasi ketiga
        tvNotification3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mainnotification.this, "Klik notifikasi 3", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
