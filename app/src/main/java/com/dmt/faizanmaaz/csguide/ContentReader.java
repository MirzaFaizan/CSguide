package com.dmt.faizanmaaz.csguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

public class ContentReader extends AppCompatActivity {
    List<content> quesList;
    int qid=0;
    content currentC;
    TextView txtContent,heading;
    Button butNext, butPrev;
    String contentid;
    String Filename;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_reader);
        final Bundle bouter = getIntent().getExtras();
        contentid=bouter.getString("Contentid");
        Filename=bouter.getString("FileName");
        heading = (TextView)findViewById(R.id.heading);

        //getting data from csv file
        InputStream inputStream=null;
        switch (Filename){
            case "mad":
               inputStream  = getResources().openRawResource(R.raw.mad);
               break;
            case "web":
                inputStream = getResources().openRawResource(R.raw.web);
                 break;
            case "computerprogramming":
                inputStream = getResources().openRawResource(R.raw.computerprogramming);
                break;
            case"csharp":
                inputStream = getResources().openRawResource(R.raw.csharp);
                break;
            case"dsa":
                inputStream = getResources().openRawResource(R.raw.dsa);
                break;
        }

        CSVcontentReader csv = new CSVcontentReader(inputStream);
        quesList = csv.read(contentid);
        currentC=quesList.get(qid);
        txtContent=(TextView)findViewById(R.id.textcontent);

        setReadContentView();

        butNext = (Button)findViewById(R.id.nextbtn);
        butPrev = (Button)findViewById(R.id.prevbtn);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        //buttons
        butPrev.setVisibility(View.INVISIBLE);


        //next button logic
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sum,ls;
                ls=quesList.size();
                sum = (qid/ls)*100;
                progressBar.setProgress((int)sum);
                if(qid<quesList.size()){
                    qid++;
                    try {
                        currentC=quesList.get(qid);
                    }
                    catch (Exception e){
                            //shows true or false for next
                            String version1 = contentid;
                            if(Integer.parseInt(version1.substring(1,version1.length()))==3||Integer.parseInt(version1.substring(1,version1.length()))==6){
                                if(Integer.parseInt(version1.substring(1,version1.length()))==3)TakeQuiz(bouter.getString("FileName")+"Q"+1);
                                else TakeQuiz(bouter.getString("FileName")+"Q"+2);
                            }else {
                                String version = contentid;
                                String newVersion = "c" + (Integer.parseInt(version.substring(1, version.length())) + 1);
                                // Pushing to new Activity
                                Intent intent = new Intent(ContentReader.this, ContentReader.class);
                                Bundle b = new Bundle();
                                b.putString("Contentid", newVersion);
                                b.putString("FileName", Filename);
                                intent.putExtras(b);
                                startActivity(intent);
                                ContentReader.this.finish();
                            }
                    }

                    setReadContentView();
                }
                else{
                    String version = contentid;
                    String newVersion = "c" + (Integer.parseInt(version.substring(1,version.length()))+1);
                    Toast toast= Toast.makeText(getApplicationContext(),newVersion,Toast.LENGTH_LONG);
                    toast.setMargin(50,50);
                    toast.show();
                }
                if(qid>=1){
                    butPrev.setVisibility(View.VISIBLE);
                }
            }
        });

        //previous btn logic
        butPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qid--;
                currentC=quesList.get(qid);
                setReadContentView();
                if(qid<=0){
                    butPrev.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    public void setReadContentView(){
        String str="";
        String strc="";
        String stri="";
        heading.setText(currentC.getHeading());
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        txtContent.startAnimation(animation1);
        String[] lines = currentC.getActualContent().split("%n");

        for (int i = 0;i<lines.length;i++){
            if(i<lines.length-1){
                str+=lines[i]+System.lineSeparator();
            }
            else
                str+=lines[i];
        }
        String[] linec = str.split("%c");
        for (int i = 0;i<linec.length;i++){
            if(i<linec.length-1){
                strc+=linec[i]+',';
            }
            else
                strc+=linec[i];
        }
        String[] linei = strc.split("%i");
        for (int i = 0;i<linei.length;i++){
            if(i<linei.length-1){
                stri+=linei[i]+'"';
            }
            else
                stri+=linei[i];
        }
        txtContent.setText(stri);

    }

    public void TakeQuiz(final String quizid){
        AlertDialog.Builder alertBox = new AlertDialog.Builder(ContentReader.this);
        alertBox.setTitle("Do you want to take the quiz?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openQuiz(quizid);
                    }
                })
                .setNegativeButton("No Take me back to main Screen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ContentReader.super.onBackPressed();
                    }
                });
        AlertDialog alert = alertBox.create();

        alert.show();
    }

    public void openQuiz(String quizid){
        Intent intent = new Intent(this,QuizReader.class);
        Bundle binner = new Bundle();
        binner.putString("quizid",quizid);
        intent.putExtras(binner);
        startActivity(intent);
        finish();

    }

}

