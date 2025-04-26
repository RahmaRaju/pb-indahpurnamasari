package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainTaskList extends AppCompatActivity {

    private Button btnSelesai1, btnSelesai2, btnSelesai3, btnTambahTask;
    private ImageButton btnBack;  // Tombol kembali

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_task_list);

        // Inisialisasi tombol
        btnSelesai1 = findViewById(R.id.btn_selesai1);
        btnSelesai2 = findViewById(R.id.btn_selesai2);
        btnSelesai3 = findViewById(R.id.btn_selesai3);
        btnTambahTask = findViewById(R.id.btn_tambah_task);
        btnBack = findViewById(R.id.btn_back);  // Tombol kembali

        // Event klik tombol
        btnSelesai1.setOnClickListener(view -> showToast("Tugas 1 ditandai selesai"));
        btnSelesai2.setOnClickListener(view -> showToast("Tugas 2 ditandai selesai"));
        btnSelesai3.setOnClickListener(view -> showToast("Tugas 3 ditandai selesai"));
        btnTambahTask.setOnClickListener(view -> showToast("Form tambah tugas belum dibuat"));

        // Navigasi kembali ke home
        btnBack.setOnClickListener(view -> navigateToHome());
    }

    // Fungsi untuk menampilkan Toast
    private void showToast(String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    // Fungsi untuk kembali ke halaman home
    private void navigateToHome() {
        // Membuka MainHome activity
        Intent intent = new Intent(MainTaskList.this, MainHome.class);
        startActivity(intent);
        finish(); // Menutup halaman task list agar tidak bisa kembali dengan tombol back
    }
    // Menutup activity saat ini agar tidak muncul di back stack
    }

