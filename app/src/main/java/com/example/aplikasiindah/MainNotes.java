package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainNotes extends AppCompatActivity {

    private ImageButton btnBackNotes;
    private Button btnTambahNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes); // Pastikan ini sesuai dengan nama XML yang kamu buat

        // Inisialisasi tombol
        btnBackNotes = findViewById(R.id.btn_back_notes);
        btnTambahNote = findViewById(R.id.btn_tambah_note);

        // Event klik tombol kembali
        btnBackNotes.setOnClickListener(view -> navigateToHome());

        // Event klik tombol tambah catatan
        btnTambahNote.setOnClickListener(view -> {
            // Menampilkan toast untuk ilustrasi
            Toast.makeText(MainNotes.this, "Tambah catatan baru", Toast.LENGTH_SHORT).show();
            // Logika untuk menambah catatan bisa ditambahkan di sini
        });
    }

    // Fungsi untuk kembali ke halaman Home
    private void navigateToHome() {
        Intent intent = new Intent(MainNotes.this, MainHome.class); // Pastikan MainHome adalah nama Activity halaman Home
        startActivity(intent);
        finish(); // Menutup halaman Notes setelah berpindah ke Home
    }
}
