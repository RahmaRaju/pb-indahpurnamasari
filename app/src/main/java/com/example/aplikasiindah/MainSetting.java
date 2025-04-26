package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiindah.R;

public class MainSetting extends AppCompatActivity {

    private ImageButton btnBack;
    private TextView tvNotifikasi, tvBahasa, tvTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_setting); // Pastikan ini sesuai nama file XML kamu

        // Inisialisasi view
        btnBack = findViewById(R.id.btn_back);
        tvNotifikasi = findViewById(R.id.notificasion);
        tvBahasa = findViewById(R.id.bahasa);
        tvTentang = findViewById(R.id.tentang);

        // Tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke activity sebelumnya
            }
        });

        // Klik Notifikasi
        tvNotifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainSetting.this, Mainnotification.class));
            }
        });

// Klik Bahasa
        tvBahasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainSetting.this, MainBahasa.class));
            }
        });

// Klik Tentang Aplikasi
        tvTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainSetting.this, MainTentang.class));
            }
        });
    }
}
