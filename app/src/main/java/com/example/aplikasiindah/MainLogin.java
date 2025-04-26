package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainLogin extends AppCompatActivity {

    private TextInputEditText inputUsername, inputPassword;
    private Button btnLogin;
    private TextView daftar;

    DatabaseReference databaseRef;

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

        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        daftar = findViewById(R.id.daftar);

        databaseRef = FirebaseDatabase.getInstance().getReference("users");

        btnLogin.setOnClickListener(view -> {
            String username = inputUsername.getText().toString().trim();
            String password = inputPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(MainLogin.this, "Harap isi username dan password", Toast.LENGTH_SHORT).show();
            } else {
                // Cek apakah username ada di Firebase
                databaseRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            String storedPassword = snapshot.child("pw").getValue(String.class);
                            if (storedPassword != null && storedPassword.equals(password)) {
                                Toast.makeText(MainLogin.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainLogin.this, MainHome.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(MainLogin.this, "Password salah", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainLogin.this, "Username tidak ditemukan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Toast.makeText(MainLogin.this, "Database Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        daftar.setOnClickListener(view -> {
            Intent intent = new Intent(MainLogin.this, MainSignUp.class);
            startActivity(intent);
        });
    }
}
