package com.dmt.faizanmaaz.csguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.InputStream;
import java.util.List;

public class QuizReader extends AppCompatActivity {


    List<question> quesList;
    int score=0;
    int qid=0;
    question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;
    String quizid;
    boolean explained;
    ViewFlipper flipper;
    ProgressBar progressBarQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_reader);
        // getting the quiz ID from previous activity
        Bundle b = getIntent().getExtras();
        quizid=b.getString("quizid");
        //checking
//        getting data from csv file
        InputStream inputStream = getResources().openRawResource(R.raw.quest);
        CSVreader csv = new CSVreader(inputStream);
        quesList = csv.read(quizid);
        currentQ=quesList.get(qid);

        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        flipper= (ViewFlipper)findViewById(R.id.flipper);
        progressBarQuiz= (ProgressBar)findViewById(R.id.progressbarQuiz);
        setQuestionView();
        explained =false;
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sum,ls;
                ls=quesList.size();
                sum = (qid/ls)*100;
                progressBarQuiz.setProgress((int)sum);
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("your ans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText())) {
                        explainAnswer(true);

                }
                else if(!currentQ.getANSWER().equals(answer.getText())){

                        explainAnswer(false);

                }


            }
        });
    }

    private void setQuestionView()
    {
        txtQuestion.setText(extractText(currentQ.getQUESTION()));
        rda.setText(extractText(currentQ.getOPTA()));
        rdb.setText(extractText(currentQ.getOPTB()));
        rdc.setText(extractText(currentQ.getOPTC()));
        rdd.setText(extractText(currentQ.getOPTD()));
        qid++;
    }

    private void explainAnswer(boolean output){
        if(explained==false){
            if(output==false){
                TextView tv_wr = (TextView)findViewById(R.id.rightwrong);
                tv_wr.setText("Wrong Answer");
                TextView tv_explaination = (TextView)findViewById(R.id.explainpls);
                tv_explaination.setText(currentQ.getExplanation());
                ImageView IV_wr= (ImageView)findViewById(R.id.imageview);
                IV_wr.setImageResource(R.drawable.wrong);
                flipper.setInAnimation(inFromRightAnimation());
                flipper.setOutAnimation(outToLeftAnimation());
                flipper.showNext();

            }
            else {
                score++;
                Log.d("score", "Your score"+score);
                TextView tv_wr = (TextView)findViewById(R.id.rightwrong);
                tv_wr.setText("Correct Answer");
                TextView tv_explaination = (TextView)findViewById(R.id.explainpls);
                tv_explaination.setText(extractText(currentQ.getExplanation()));
                ImageView IV_wr= (ImageView)findViewById(R.id.imageview);
                IV_wr.setImageResource(R.drawable.right);
                flipper.setInAnimation(inFromRightAnimation());
                flipper.setOutAnimation(outToLeftAnimation());
                flipper.showNext();
            }
            explained=true;
        }

        else if(explained==true){
            // when all questions end
            if(qid<quesList.size()){
                currentQ=quesList.get(qid);
                setQuestionView();
                flipper.setInAnimation(inFromLeftAnimation());
                flipper.setOutAnimation(outToRightAnimation());
                flipper.showPrevious();
            }else{
                Intent intent = new Intent(QuizReader.this, QuizResult.class);
                Bundle b = new Bundle();
                b.putString("quizid",quizid);
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
                finish();
            }
            explained=false;
        }

    }

    //animations waly shashky

    private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }
    private Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        outtoLeft.setDuration(500);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    private Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }

    public String extractText(String oldText){
        String str="",strc="",stri="";
        String[] lines = oldText.split("%n");

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
        return stri;
    }


}
