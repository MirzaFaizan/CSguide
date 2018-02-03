package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;

public class MADMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madmain2);
    }
    public void intro(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void Variables(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void classes(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","mad");
        b.putString("quizI=id","madQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void structures(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void mobile_interface(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","mad");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void Images(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","mad");
        b.putString("quizid","madQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
