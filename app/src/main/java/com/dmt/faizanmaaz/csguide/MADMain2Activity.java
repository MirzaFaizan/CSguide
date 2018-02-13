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

import java.io.InputStream;

public class MADMain2Activity extends AppCompatActivity {
    AdView madview1,madview2;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madmain2);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview1=(AdView)findViewById(R.id.madbanner1);
        AdRequest adRequest = new AdRequest.Builder().build();
        madview1.loadAd(adRequest);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview2=(AdView)findViewById(R.id.madbanner2);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        madview2.loadAd(adRequest1);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-8807216744783920/5837974601");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                interstitialAd.loadAd( new AdRequest.Builder().build());
            }
        });
    }
    public void intro(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void Variables(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void classes(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","mad");
        b.putString("quizI=id","madQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void structures(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void mobile_interface(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void Images(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","mad");
        b.putString("quizid","madQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
