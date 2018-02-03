package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WEBMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webmain2);
    }
    public void html(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","web");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void Css(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","web");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void javascript(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","web");
        b.putString("quizI=id","webQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void interactivity(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","web");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void Jqeury(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","web");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void php(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","web");
        b.putString("quizid","webQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
