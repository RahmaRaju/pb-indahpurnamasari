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

public class MainSignUp extends AppCompatActivity {

    TextInputEditText username,email,password,nim;
    Button loginbutton;


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
        nim=findViewById(R.id.NIM);
        loginbutton=findViewById(R.id.buttonsignup);

        loginbutton.setOnClickListener(view ->{
            String nama,em,pw,nm;

            nama = String.valueOf(username.getText());
            em = String.valueOf(email.getText());
            pw = String.valueOf(password.getText());
            nm = String.valueOf(nim.getText());

            if (TextUtils.isEmpty(nama)){
                Toast.makeText(MainSignUp.this, "Enter Username", Toast.LENGTH_LONG).show();
                username.requestFocus();
            } else if (TextUtils.isEmpty(em)) {
                Toast.makeText(MainSignUp.this, "Enter Email", Toast.LENGTH_LONG).show();
                email.requestFocus();
            } else if (TextUtils.isEmpty(pw)) {
                Toast.makeText(MainSignUp.this, "Enter Password", Toast.LENGTH_LONG).show();
                password.requestFocus();
            } else if (TextUtils.isEmpty(nm)) {
                Toast.makeText(MainSignUp.this, "Enter NIM", Toast.LENGTH_LONG).show();
                nim.requestFocus();
            } else {
                //methods public void
            }

            Intent intent = new Intent(getApplicationContext(), MainHome.class);
            startActivity(intent);
            finish();
        });

    }
}