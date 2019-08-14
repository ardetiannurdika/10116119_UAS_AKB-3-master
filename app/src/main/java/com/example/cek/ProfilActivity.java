package com.example.cek;

/**
 Ardetian Nurdika
 10116119
 AKB-3

 Tanggal Pengumpulan : 14 - 8 - 2019
 **/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.cek.R;

public class ProfilActivity extends AppCompatActivity {
    Button Btnsignout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profil);

        Btnsignout = findViewById(R.id.btn_signout);
        Btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }
}
