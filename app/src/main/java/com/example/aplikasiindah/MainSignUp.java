package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainSignUp extends AppCompatActivity {

    TextInputEditText username,email,password;
    Button loginbutton;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.pengguna);
        email=findViewById(R.id.Email);
        password=findViewById(R.id.katasandi);
        loginbutton=findViewById(R.id.buttonsignup);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://database-1d1d7-default-rtdb.firebaseio.com/");

        loginbutton.setOnClickListener(view ->{
            String nama,em,pw;

            nama = String.valueOf(username.getText());
            em = String.valueOf(email.getText());
            pw = String.valueOf(password.getText());


            if (nama.isEmpty() || em.isEmpty() || pw.isEmpty()){
                Toast.makeText(getApplicationContext(), "Lengkapi data terlebih dahulu", Toast.LENGTH_SHORT).show();
            }else{
                database = FirebaseDatabase.getInstance().getReference("users");
                database.child(nama).child("nama").setValue(nama);
                database.child(nama).child("em").setValue(em);
                database.child(nama).child("pw").setValue(pw);

                Toast.makeText(getApplicationContext(), "Register berhasil", Toast.LENGTH_SHORT).show();
                Intent register = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(register);
            }
        });

    }
}