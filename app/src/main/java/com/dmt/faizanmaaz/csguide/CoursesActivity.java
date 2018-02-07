package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class CoursesActivity extends AppCompatActivity {
AdView madview1,madview2;
InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview1=(AdView)findViewById(R.id.bannerMain);
        AdRequest adRequest = new AdRequest.Builder().build();
        madview1.loadAd(adRequest);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview2=(AdView)findViewById(R.id.bannerMain1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        madview2.loadAd(adRequest1);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                interstitialAd.loadAd( new AdRequest.Builder().build());
            }
        });
    }

    public void computerProgramming_click(View view) {
        if(interstitialAd.isLoaded()){
             interstitialAd.show();
        }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);


    }
    public void MAD_click(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this, MADMain2Activity.class);
        startActivity(intent);
    }
    public void WEB_click(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this, WEBMain2Activity.class);
        startActivity(intent);
    }
    public void Networking_click(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this, NetworkingMain2Activity.class);
        startActivity(intent);
    }
    public void DSA_click(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this, DSAMain2Activity.class);
        startActivity(intent);
    }
    public void OOP_click(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this, OOPMain2Activity.class);
        startActivity(intent);
    }

    public void madintro(View view) {
    }

    public void shareApplication(View view) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,"Hey! This app taught me many concepts about computer science");
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent,"Share this with friends"));
    }
}
