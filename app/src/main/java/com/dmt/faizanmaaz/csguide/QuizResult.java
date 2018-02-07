package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class QuizResult extends AppCompatActivity {
    TextView t;
    AdView madview1,madview2;
    InterstitialAd interstitialAd;
    Button retry, moveon;
    Bundle bouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        madview1=(AdView)findViewById(R.id.qrbanner1);
        AdRequest adRequest = new AdRequest.Builder().build();
        madview1.loadAd(adRequest);

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
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        t=(TextView)findViewById(R.id.textResult);
        retry = (Button)findViewById(R.id.retry);
        moveon = (Button)findViewById(R.id.moveon);
        //get score
        bouter = getIntent().getExtras();
        int score= bouter.getInt("score");
        t.setText(""+score);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizResult.this,QuizReader.class);
                Bundle b = new Bundle();
                b.putString("quizid",bouter.getString("quizid"));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });

        moveon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizResult.super.onBackPressed();
            }
        });

    }
}
