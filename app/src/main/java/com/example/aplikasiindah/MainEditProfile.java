package com.example.aplikasiindah;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainEditProfile extends AppCompatActivity {

    private ImageButton btnBack;
    private EditText etNama, etEmail, etTelepon;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_profile); // Pastikan nama file XML-nya benar

        // Inisialisasi View
        btnBack = findViewById(R.id.btn_back);
        etNama = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        etTelepon = findViewById(R.id.et_telepon);
        btnSimpan = findViewById(R.id.btn_simpan);

        // Tombol kembali
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Menutup activity dan kembali ke sebelumnya
            }
        });

        // Tombol Simpan
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String telepon = etTelepon.getText().toString().trim();

                if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
                    Toast.makeText(MainEditProfile.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    // Simpan data ke database atau shared preferences di sini jika perlu
                    Toast.makeText(MainEditProfile.this, "Profil disimpan", Toast.LENGTH_SHORT).show();
                    finish(); // Tutup activity setelah simpan
                }
            }
        });
    }
}
