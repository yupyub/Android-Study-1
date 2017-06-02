package com.tronze.study;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Tronze on 2017-06-02.
 */

public class DownloadImage extends AsyncTask {

    String user_name;
    ImageView imgView;
    Bitmap bitmap = null;

    public DownloadImage(String user_name, ImageView imgView) {
        this.user_name = user_name;
        this.imgView = imgView;
    }

    @Override
    protected void onPostExecute(Object o) {
        if (bitmap != null) imgView.setImageBitmap(bitmap);
    }

    @Override
    protected void onPreExecute() {
        imgView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        String path = String.format("http://54.202.215.97/Study/%s.jpg", user_name);
        try {
            URL url = new URL(path);
            InputStream is = url.openStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
