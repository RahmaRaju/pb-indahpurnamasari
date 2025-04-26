package com.example.aplikasiindah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainHome extends AppCompatActivity {

    private ImageButton btnProfile, btnSetting;
    private CardView cardTask, cardSchedule, cardNotes, cardReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Pastikan ini sesuai dengan nama file XML

        // Inisialisasi tombol
        btnProfile = findViewById(R.id.btn_profile);
        btnSetting = findViewById(R.id.btn_setting);

        // Inisialisasi CardView
        cardTask = findViewById(R.id.card_task);
        cardSchedule = findViewById(R.id.card_schedule);
        cardNotes = findViewById(R.id.card_notes);
        cardReminder = findViewById(R.id.card_reminder);

        // Navigasi ke halaman Profile
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainProfile.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Setting
        btnSetting.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainSetting.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Task List
        cardTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainTaskList.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Schedule
        cardSchedule.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainSchedule.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Notes
        cardNotes.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainNotes.class);
            startActivity(intent);
        });

        // Navigasi ke halaman Reminder
        cardReminder.setOnClickListener(v -> {
            Intent intent = new Intent(MainHome.this, MainReminder.class);
            startActivity(intent);
        });
    }
}
