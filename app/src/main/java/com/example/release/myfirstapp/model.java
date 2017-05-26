package com.example.release.myfirstapp;

import android.media.Image;

/**
 * Created by release on 2017. 5. 26..
 */

public class model {
    int mtype;

    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtext() {
        return mtext;
    }

    public void setMtext(String mtext) {
        this.mtext = mtext;
    }

    public Image getMimg() {
        return mimg;
    }

    public void setMimg(Image mimg) {
        this.mimg = mimg;
    }

    String mname;
    String mtext;
    Image mimg;
    public model(int type, String User_name, String User_text, Image User_img){
        mtype = type;
        mname = User_name;
        mtext = User_text;
        mimg = User_img;
    }

}
