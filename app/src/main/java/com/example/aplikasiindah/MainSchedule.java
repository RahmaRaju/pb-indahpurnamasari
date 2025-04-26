package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainSchedule extends AppCompatActivity {

    private ImageButton btnBackSchedule;
    private Button btnTambahSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_schedule); // Ganti dengan nama XML kamu

        // Inisialisasi tombol
        btnBackSchedule = findViewById(R.id.btn_back_schedule);
        btnTambahSchedule = findViewById(R.id.btn_tambah_schedule);

        // Kembali ke Home
        btnBackSchedule.setOnClickListener(view -> {
            Intent intent = new Intent(MainSchedule.this, MainHome.class);
            startActivity(intent);
            finish(); // Agar tidak bisa kembali ke Schedule saat tekan tombol back
        });

        // Tambah Jadwal
        btnTambahSchedule.setOnClickListener(view -> {
            Toast.makeText(this, "Fitur Tambah Jadwal belum tersedia", Toast.LENGTH_SHORT).show();
        });
    }
}
