package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

public class ContentReader extends AppCompatActivity {
    List<content> quesList;
    int qid=0;
    content currentC;
    TextView txtContent;
    Button butNext, butPrev;
    String contentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_reader);
        Bundle b = getIntent().getExtras();
        contentid=b.getString("Contentid");
        //getting data from csv file
        InputStream inputStream=null;
        switch (b.getString("FileName")){
            case "mad":
               inputStream  = getResources().openRawResource(R.raw.mad);
               break;
            case "web":
                inputStream = getResources().openRawResource(R.raw.mad);
        }

        CSVcontentReader csv = new CSVcontentReader(inputStream);
        quesList = csv.read(contentid);
        currentC=quesList.get(qid);
        txtContent=(TextView)findViewById(R.id.textcontent);
        setReadContentView();

        butNext = (Button)findViewById(R.id.nextbtn);
        butPrev = (Button)findViewById(R.id.prevbtn);
        //buttons
        butPrev.setVisibility(View.INVISIBLE);


        //next button logic
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(qid<quesList.size()){
                    qid++;
                    try {
                        currentC=quesList.get(qid);
                    }
                    catch (Exception e){
                        String version = contentid;
                        String newVersion = "c" + (Integer.parseInt(version.substring(1,version.length()))+1);
                        // Pushing to new Activity
                        Intent intent = new Intent(ContentReader.this,ContentReader.class);
                        Bundle b = new Bundle();
                        b.putString("Contentid", newVersion);
                        b.putString("FileName","mad");
                        intent.putExtras(b);
                        startActivity(intent);
                        ContentReader.this.finish();
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

        String[] lines = currentC.getActualContent().split("%n");
        for (String line : lines) {
            str+=line+System.lineSeparator();
        }
        txtContent.setText(str);
    }

    public void intro(View view) {
    }
}

