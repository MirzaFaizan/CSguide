package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OOPMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopmain2);
    }
    public void oopintro(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopclasses(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopAssociation(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","oop");
        b.putString("quizI=id","oopQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopinheritance(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void ooppolymorphism(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","oop");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void oopoperator(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","oop");
        b.putString("quizid","oopQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
