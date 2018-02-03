package com.dmt.faizanmaaz.csguide;

/**
 * Created by DELL on 2/1/2018.
 */

public class content {

    private String contentID;
    private String actualContent;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    private String heading;

    public content(){
        contentID="";
        actualContent="";
    }

    public content(String id, String contentt){
        this.contentID=id;
        this.actualContent=contentt;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getActualContent() {
        return actualContent;
    }

    public void setActualContent(String actualContent) {
        this.actualContent = actualContent;
    }


}
