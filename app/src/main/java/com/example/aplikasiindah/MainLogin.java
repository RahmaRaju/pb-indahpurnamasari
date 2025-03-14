package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainLogin extends AppCompatActivity {

    private TextView daftar; // Tambahkan TextView daftar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi TextView "Daftar Sekarang"
        daftar = findViewById (R.id.daftar);

        // Event klik untuk pindah ke SignUpActivity
        daftar.setOnClickListener(view -> {
            Intent intent = new Intent(MainLogin.this, MainSignUp.class);
            startActivity(intent);
        });
    }
}
