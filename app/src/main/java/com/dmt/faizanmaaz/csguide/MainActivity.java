package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cpintro(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","computerprogramming");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void cpvariables(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","computerprogramming");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void cpfunctions(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","computerprogramming");
        b.putString("quizI=id","computerprogrammingQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void cpstrings(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","computerprogramming");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void cpgraphics(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","computerprogramming");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void cpfile(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","computerprogramming");
        b.putString("quizid","computerprogrammingQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
