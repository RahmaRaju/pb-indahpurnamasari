package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainProfile extends AppCompatActivity {

    private ImageButton btnBack;
    private ImageView profileImage;
    private TextView btnUbahProfile, btnKeluar;
    private TextView profileName, profileEmail;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_profile);

        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // Inisialisasi view
        btnBack = findViewById(R.id.btn_back);
        profileImage = findViewById(R.id.profile_image);
        btnUbahProfile = findViewById(R.id.btnubahprofile);
        btnKeluar = findViewById(R.id.btnkeluar);

        // Nama dan Email diambil dari Firebase
        profileName = findViewById(R.id.nama);
        profileEmail = findViewById(R.id.email);

        // Coba isi data nama dan email dari user Firebase
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();


            profileName.setText(name != null ? name : "Nama tidak tersedia");
            profileEmail.setText(email != null ? email : "Email tidak tersedia");
        }

        // Tombol kembali
        btnBack.setOnClickListener(v -> onBackPressed());

        // Tombol ubah profil
        btnUbahProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainProfile.this, MainEditProfile.class);
            startActivity(intent);
        });

        // Tombol keluar
        btnKeluar.setOnClickListener(v -> showLogoutDialog());
    }

    private void showLogoutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya", (dialog, which) -> {
                    auth.signOut();
                    Intent intent = new Intent(MainProfile.this, MainEditProfile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Batal", null)
                .show();
    }
}
