package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);
    }

    public void computerProgramming_click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void MAD_click(View view) {
        Intent intent = new Intent(this, MADMain2Activity.class);
        startActivity(intent);
    }
    public void WEB_click(View view) {
        Intent intent = new Intent(this, WEBMain2Activity.class);
        startActivity(intent);
    }
    public void Networking_click(View view) {
        Intent intent = new Intent(this, NetworkingMain2Activity.class);
        startActivity(intent);
    }
    public void DSA_click(View view) {
        Intent intent = new Intent(this, DSAMain2Activity.class);
        startActivity(intent);
    }
    public void OOP_click(View view) {
        Intent intent = new Intent(this, OOPMain2Activity.class);
        startActivity(intent);
    }
}
