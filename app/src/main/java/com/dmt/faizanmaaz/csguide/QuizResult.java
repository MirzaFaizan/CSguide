package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {
    TextView t;
    Button retry, moveon;
    Bundle bouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);


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
