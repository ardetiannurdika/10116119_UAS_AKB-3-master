/**
 Ardetian Nurdika
 10116119
 AKB-3

 Tanggal Pengumpulan : 14 - 8 - 2019
 **/


package com.example.cek;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFriends extends Fragment {
    FloatingActionButton btnOpenDialog;
    RecyclerView recyclerView;
    TextView textInfo;
    String nama,snim,kelas,telp,email,socmed;
    Integer nim;
    Realm realm;
    RealmHelper realmHelper;
    FriendModel friendModel;
    List<FriendModel> friendModels;
    private FriendsAdapter friendsAdapter;

    View myView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_menu_friends, container, false);
        textInfo = myView.findViewById(R.id.tes);
        recyclerView = myView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        Realm.init(getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        realmHelper = new RealmHelper(realm);
        friendModels = new ArrayList<>();

        friendModels = realmHelper.getAllMahasiswa();

        show();






        btnOpenDialog = myView.findViewById(R.id.btn_tambah);


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        return myView;
    }

    private void openDialog() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View subView = inflater.inflate(R.layout.alert_dialog, null);
        final EditText nama_dialog = subView.findViewById(R.id.txt_nama_dialog);
        final EditText nim_dialog = subView.findViewById(R.id.txt_nim_dialog);
        final EditText kelas_dialog = subView.findViewById(R.id.txt_kelas_dialog);
        final EditText telp_dialog = subView.findViewById(R.id.txt_telp_dialog);
        final EditText email_dialog = subView.findViewById(R.id.txt_email_dialog);
        final EditText socmed_dialog = subView.findViewById(R.id.txt_socmed_dialog);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Tambah Teman");
        builder.setMessage("Masukan Data Teman");
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nama=nama_dialog.getText().toString();
                snim=nim_dialog.getText().toString();
                nim = Integer.parseInt(snim);
                kelas=kelas_dialog.getText().toString();
                telp=telp_dialog.getText().toString();
                email=email_dialog.getText().toString();
                socmed=socmed_dialog.getText().toString();


                friendModel = new FriendModel();
                friendModel.setNim(nim);
                friendModel.setNama(nama);
                friendModel.setKelas(kelas);
                friendModel.setTelp(telp);
                friendModel.setEmail(email);
                friendModel.setSocmed(socmed);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(friendModel);

                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Menambah Kontak Teman...");
                progressDialog.show();

                // TODO: Implement your own authentication logic here.

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed

                Toast.makeText(getActivity(), "Berhasil Menambah Kontak Teman!", Toast.LENGTH_SHORT).show();
                onResume();
                                // onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 1800);



            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();

    }

    @Override
    public void onResume() {
        super.onResume();
        friendsAdapter.notifyDataSetChanged();
        show();
    }

    public void show(){
        friendsAdapter = new FriendsAdapter(getActivity(), friendModels);
        recyclerView.setAdapter(friendsAdapter);
    }







}
