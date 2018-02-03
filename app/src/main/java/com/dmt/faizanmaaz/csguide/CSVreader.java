package com.dmt.faizanmaaz.csguide;

/**
 * Created by Faizan Ejaz on 1/31/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVreader {
    private InputStream inputStream;

    public CSVreader(InputStream is) {
        this.inputStream = is;
    }

    public ArrayList<question> read(String quizid) {
        ArrayList<question> resultList = new ArrayList<question>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            while((csvLine = reader.readLine()) != null) {
                String[] tokens = csvLine.split(",");
                question q = new question();
                q.setQUIZ_ID(tokens[0]);
                q.setQUESTION(tokens[1]);
                q.setOPTA(tokens[2]);
                q.setOPTB(tokens[3]);
                q.setOPTC(tokens[4]);
                q.setOPTD(tokens[5]);
                q.setANSWER(tokens[6]);
                resultList.add(q);


            }
        } catch(IOException ex) {
            throw new RuntimeException("Error in reading CSV file:" + ex);
        } finally {
            try{
                inputStream.close();
            } catch(IOException e) {
                throw new RuntimeException("Error while closing input stream: " + e);
            }
        }
        for (int i = 0; i<resultList.size();i++){
            if(resultList.get(i).getQUIZ_ID().equals(quizid))
            {}
            else{
                resultList.remove(i);
                i--;
            }
        }
        return resultList;
    }
}