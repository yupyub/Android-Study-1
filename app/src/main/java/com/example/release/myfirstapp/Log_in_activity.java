package com.example.release.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by release on 2017. 5. 12..
 */

public class Log_in_activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);
        final EditText ID_edit = (EditText)(findViewById(R.id.ID_edit));
        Button Send_Button = (Button)(findViewById(R.id.Send_Button));
        Send_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(),MainActivity.class);
                newIntent.putExtra("ID",ID_edit.getText().toString());
                startActivity(newIntent);
            }
        });
    }
}
