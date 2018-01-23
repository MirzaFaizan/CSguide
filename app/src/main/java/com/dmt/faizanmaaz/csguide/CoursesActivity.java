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
}
