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

public class DSAMain2Activity extends AppCompatActivity {
    AdView maddsaview1,maddsaview2;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsamain2);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        maddsaview1=(AdView)findViewById(R.id.dsabanner1);
        AdRequest adRequest = new AdRequest.Builder().build();
        maddsaview1.loadAd(adRequest);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        maddsaview2=(AdView)findViewById(R.id.dsabanner2);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        maddsaview2.loadAd(adRequest1);

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
    public void dsaintro(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","dsa");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsastack(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","dsa");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsalink(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","dsa");
        b.putString("quizI=id","dsaQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsacircular(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","dsa");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsatree(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","dsa");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsaheap(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","dsa");
        b.putString("quizid","dsaQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
