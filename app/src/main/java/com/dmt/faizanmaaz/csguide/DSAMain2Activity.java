package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DSAMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsamain2);
    }
    public void dsaintro(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        b.putString("FileName","dsa");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsalink(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c2");
        b.putString("FileName","dsa");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void dsacircular(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c3");
        b.putString("FileName","dsa");
        b.putString("quizI=id","dsaQ1");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void csharpException(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c4");
        b.putString("FileName","csharp");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void csharpdelegates(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c5");
        b.putString("FileName","csharp");
        intent.putExtras(b);
        startActivity(intent);
    }
    public void csharpmultithreading(View view) {

        Intent intent = new Intent(this,ContentReader.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c6");
        b.putString("FileName","csharp");
        b.putString("quizid","csharpQ2");
        intent.putExtras(b);
        startActivity(intent);
    }
}
