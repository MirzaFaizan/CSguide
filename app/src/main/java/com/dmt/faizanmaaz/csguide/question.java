package com.dmt.faizanmaaz.csguide;

/**
 * Created by Faizan Ejaz on 1/22/2018.
 */

public class question {
    private String QUIZ_ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String OPTD) {
        this.OPTD = OPTD;
    }

    private String OPTD;

    private String ANSWER;
    public question()
    {

        QUESTION="";
        OPTA="";
        OPTB="";
        OPTC="";
        OPTD="";
        ANSWER="";
        QUIZ_ID="";
    }
    public question(String qUIZ_ID, String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD, String aNSWER) {

        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        OPTD=oPTD;
        ANSWER = aNSWER;
        QUIZ_ID=qUIZ_ID;
    }
    public String getQUIZ_ID(){return QUIZ_ID;}
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getOPTC() {
        return OPTC;
    }

    public String getANSWER() {
        return ANSWER;
    }
    public void setQUIZ_ID(String qUIZ_ID){QUIZ_ID=qUIZ_ID;}
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }

    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }
}
