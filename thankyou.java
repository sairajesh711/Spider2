package com.sairajesh.spider2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
       //getting data from parent activity
        Bundle namedata= getIntent().getExtras();

        //displaying name
        String namein = namedata.getString("nameinput");
        TextView resulttext = (TextView)findViewById(R.id.result);
        resulttext.setText(namein+" your response has been recorded");

        //Timestamp
        SimpleDateFormat Date= new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String date = Date.format(new Date());
        TextView time = (TextView)findViewById(R.id.timestamp);
        time.setText("Login time:"+date);

        //Back button
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        finish();
                    }
                }


        );

    }
}
