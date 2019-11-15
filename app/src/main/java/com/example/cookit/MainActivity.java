package com.example.cookit;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        BottomNavigationView bottomNavigationView= findViewById( R.id.navigation );
      bottomNavigationView.setOnNavigationItemSelectedListener( navListener );

      //Ads code
        AdView adView=(AdView) findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
             new BottomNavigationView.OnNavigationItemSelectedListener() {
                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                     Fragment selectFragent = null;


                     switch (item.getItemId())
                     {
                         case R.id.nav_homee:
                             selectFragent = new Home();
                             break;

                         case R.id.nav_favourite:
                             selectFragent = new Favourite();
                             break;
                         case R.id.nav_tips:
                             selectFragent = new Tips();
                             break;
                         case R.id.nav_feedback:
                             selectFragent = new Feedback();
                             break;
                     }

                     getSupportFragmentManager().beginTransaction().replace( R.id.frame_layout, selectFragent ).commit();
                     return true;

                 }
             };
}
