package com.example.release.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ScrollView scro=(ScrollView)(findViewById(R.id.dd));
        final TextView view = (TextView)(findViewById(R.id.ee));
        final EditText edit = (EditText)(findViewById(R.id.cc));
        Button but = (Button)(findViewById(R.id.ff));
        Intent newIntent = new Intent(this.getIntent());
        view.append("USER::");
        view.append(newIntent.getStringExtra("ID"));
        Toast.makeText(this, newIntent.getStringExtra("ID"), Toast.LENGTH_LONG).show();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.append("\n");
                view.append(edit.getText().toString());
                edit.setText("");
                scro.post(new Runnable() {
                    @Override
                    public void run() {
                        scro.scrollTo(0,scro.getHeight());
                    }
                });
            }
        });
    }


}
