package com.example.cek;
/**
 Ardetian Nurdika
 10116119
 AKB-3

 Tanggal Pengumpulan : 14 - 8 - 2019
 **/

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragent_container,
                new ProfilFragment()).commit();




    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment= null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new ProfilFragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new MedsosFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new MenuFriends();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragent_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
