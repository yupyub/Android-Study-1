package com.example.release.myfirstapp;

import android.app.Activity;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ScrollView dd=(ScrollView)(findViewById(R.id.dd));
        final TextView ee = (TextView)(findViewById(R.id.ee));
        final EditText cc = (EditText)(findViewById(R.id.cc));
        Button ff = (Button)(findViewById(R.id.ff));
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ee.append("\n");
                ee.append(cc.getText().toString());
                cc.setText("");
                dd.post(new Runnable() {
                    @Override
                    public void run() {
                        dd.scrollTo(0,dd.getHeight());
                    }
                });
            }
        });
    }


}
