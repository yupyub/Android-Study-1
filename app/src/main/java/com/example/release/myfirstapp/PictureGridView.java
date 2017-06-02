package com.tronze.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Tronze on 2017-06-02.
 */

public class PictureGridView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.widget.GridView gridView = new android.widget.GridView(this);

        gridView.setNumColumns(3);

        gridView.setAdapter(new PictureAdapter());

        setContentView(gridView);

    }

    public class PictureAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ImageView img = new ImageView(PictureGridView.this);
            img.setImageResource(R.mipmap.ic_launcher);
            new DownloadImage(String.valueOf((i+1)), img).execute();
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("pic_index", String.valueOf(i+1));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
            return img;
        }
    }

}
