package com.example.cek;

/**
 Ardetian Nurdika
 10116119
 AKB-3

 Tanggal Pengumpulan : 14 - 8 - 2019
 **/

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cek.R;

public class MedsosFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Button btnphone = (Button) view.findViewById(R.id.button_tlp);
        Button btnig = (Button) view.findViewById(R.id.button_ig);
        Button btnemail = (Button) view.findViewById(R.id.button_email);
        Button btnfcbk = (Button) view.findViewById(R.id.button_fb);
        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.nomersaya);
                String dial = "tel:" + phone;
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(dial));
                startActivity(intent);
            }
        });
        btnig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlfb ="https://www.instagram.com/ibnumunzi_";
                Intent bukafb=new Intent(Intent.ACTION_VIEW);
                bukafb.setData(Uri.parse(urlfb));
                startActivity(bukafb);
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@ibnumunzi10.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        btnfcbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlfb ="https://www.facebook.com/munzi.pockers";
                Intent bukafb=new Intent(Intent.ACTION_VIEW);
                bukafb.setData(Uri.parse(urlfb));
                startActivity(bukafb);
            }
        });
        return view;
    }
}
