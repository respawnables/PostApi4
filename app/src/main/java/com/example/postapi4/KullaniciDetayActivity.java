package com.example.postapi4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class KullaniciDetayActivity extends AppCompatActivity {

    private TextView tvDetayKullaniciAdi, tvDetayEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_detay);

        tvDetayKullaniciAdi = findViewById(R.id.tvDetayKullaniciAdi);
        tvDetayEmail = findViewById(R.id.tvDetayEmail);

        String username = getIntent().getExtras().getString("username");
        String eposta = getIntent().getExtras().getString("eposta");

        tvDetayKullaniciAdi.setText(username);
        tvDetayEmail.setText(eposta);
    }
}