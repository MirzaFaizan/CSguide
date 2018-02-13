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

public class OOPMain2Activity extends AppCompatActivity {
    AdView madview1,madview2;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopmain2);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview1=(AdView)findViewById(R.id.oopbanner1);
        AdRequest adRequest = new AdRequest.Builder().build();
        madview1.loadAd(adRequest);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview2=(AdView)findViewById(R.id.oopbanner2);
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
    public void oopintro(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopclasses(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopAssociation(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","oop");
        b.putString("quizI=id","oopQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopinheritance(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void ooppolymorphism(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopoperator(View view) {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","oop");
        b.putString("quizid","oopQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
