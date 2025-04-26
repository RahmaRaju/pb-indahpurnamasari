package com.example.aplikasiindah;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainBahasa extends AppCompatActivity {

    private ImageButton btnBack;
    private RadioGroup radioGroupLanguage;
    private RadioButton radioIndonesia, radioEnglish;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bahasa);

        // Inisialisasi komponen UI
        btnBack = findViewById(R.id.btn_back);
        radioGroupLanguage = findViewById(R.id.radioGroupLanguage);
        radioIndonesia = findViewById(R.id.radio_bahasa_indonesia);
        radioEnglish = findViewById(R.id.radio_english);
        btnSimpan = findViewById(R.id.btn_simpan_bahasa);

        // Tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke halaman sebelumnya
            }
        });

        // Tombol simpan bahasa
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupLanguage.getCheckedRadioButtonId();

                if (selectedId == R.id.radio_bahasa_indonesia) {
                    Toast.makeText(MainBahasa.this, "Bahasa diubah ke Bahasa Indonesia", Toast.LENGTH_SHORT).show();
                    // Di sini bisa disimpan preferensi bahasa ke SharedPreferences misalnya
                } else if (selectedId == R.id.radio_english) {
                    Toast.makeText(MainBahasa.this, "Language changed to English", Toast.LENGTH_SHORT).show();
                    // Simpan ke preferensi bahasa jika perlu
                } else {
                    Toast.makeText(MainBahasa.this, "Silakan pilih bahasa terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
