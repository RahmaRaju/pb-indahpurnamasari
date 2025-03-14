package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainProfile extends AppCompatActivity {

    private ImageView profileImage;
    private TextView profileName, profileEmail;
    private Button btnEditProfile, btnLogout;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Firebase Authentication
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // Inisialisasi UI
        profileImage = findViewById(R.id.profile_image);
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
        btnEditProfile = findViewById(R.id.btn_edit_profile);
        btnLogout = findViewById(R.id.btn_logout);

        // Menampilkan data user dari Firebase Authentication
        if (user != null) {
            profileName.setText(user.getDisplayName() != null ? user.getDisplayName() : "User");
            profileEmail.setText(user.getEmail() != null ? user.getEmail() : "Email tidak tersedia");

            // Set default gambar profil
            profileImage.setImageResource(R.drawable.profil);
        }

        // Tombol Edit Profile
        btnEditProfile.setOnClickListener(view -> {
            Intent intent = new Intent(MainProfile.this, MainEditProfile.class);
            startActivity(intent);
        });

        // Tombol Logout
        btnLogout.setOnClickListener(view -> showLogoutDialog());
    }

    // Konfirmasi Logout
    private void showLogoutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya", (dialog, i) -> {
                    auth.signOut();
                    startActivity(new Intent(MainProfile.this, LoginActivity.class));
                    finish();
                })
                .setNegativeButton("Batal", null)
                .show();
    }
}
