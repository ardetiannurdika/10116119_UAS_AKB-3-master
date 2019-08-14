
/**
 Ardetian Nurdika
 10116119
 AKB-3

 Tanggal Pengumpulan : 14 - 8 - 2019
 **/

package com.example.cek;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Integer nim,id;
    String snim,nama,kelas,telp,email,socmed;
    EditText Nim,Nama,Kelas,Telp,Email,Socmed;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        Intent i = getIntent();
        Nim = findViewById(R.id.etNim);
        Nama = findViewById(R.id.etNama);
        Kelas = findViewById(R.id.etKelas);
        Telp = findViewById(R.id.etTelp);
        Email = findViewById(R.id.etEmail);
        Socmed = findViewById(R.id.etSocmed);
        btn_hapus = findViewById(R.id.btnHapus);
        btn_ubah = findViewById(R.id.btnUpdate);


        snim = i.getStringExtra("nim");
        nama = i.getStringExtra("nama");
        kelas = i.getStringExtra("kelas");
        telp = i.getStringExtra("telp");
        email = i.getStringExtra("email");
        socmed = i.getStringExtra("socmed");

        nim=Integer.parseInt(snim);
        id = Integer.parseInt(getIntent().getStringExtra("id"));


        Nim.setText(snim);
        Nama.setText(nama);
        Kelas.setText(kelas);
        Telp.setText(telp);
        Email.setText(email);
        Socmed.setText(socmed);


        btn_hapus.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_ubah){
            realmHelper.update(id,Integer.parseInt(Nim.getText().toString()),Nama.getText().toString(),Kelas.getText().toString(),
                    Telp.getText().toString(),Email.getText().toString(),Socmed.getText().toString());
            final ProgressDialog progressDialog = new ProgressDialog(DetailActivity.this);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Edit Kontak...");
            progressDialog.show();

            // TODO: Implement your own authentication logic here.

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
            Toast.makeText(DetailActivity.this, "Berhasil Menyunting Kontak Teman !", Toast.LENGTH_SHORT).show();
            Nim.setText("");
            Nama.setText("");
            finish();
                            progressDialog.dismiss();
                        }
                    }, 1800);

        }else if (v == btn_hapus) {
            realmHelper.delete(nim);
            final ProgressDialog progressDialog = new ProgressDialog(DetailActivity.this);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Menghapus Kontak...");
            progressDialog.show();

            // TODO: Implement your own authentication logic here.

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
            Toast.makeText(DetailActivity.this, "Berhasil Menghapus Kontak Teman!", Toast.LENGTH_SHORT).show();
            finish();
                            progressDialog.dismiss();
                        }
                    }, 1800);

        }
    }



}
