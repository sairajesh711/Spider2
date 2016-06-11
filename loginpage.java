package com.sairajesh.spider2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
    Spinner dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        //layout setting
        RelativeLayout Lay = (RelativeLayout) findViewById(R.id.Lay);
        Lay.setBackgroundColor(Color.parseColor("#FFFF33"));

        //spinner setting
        dept=(Spinner)findViewById(R.id.depts);
        ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.departments,R.layout.support_simple_spinner_dropdown_item);
        dept.setAdapter(adapter);

        //checkbox details
        final CheckBox web=(CheckBox)findViewById(R.id.web);
        final  CheckBox app=(CheckBox)findViewById(R.id.app);
        final CheckBox algo=(CheckBox)findViewById(R.id.algo);
        final CheckBox tron=(CheckBox)findViewById(R.id.tron);
        //button details
        Button onsubmit=(Button)findViewById(R.id.submit);
        onsubmit.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent sub= new Intent(loginpage.this,thankyou.class);
                        final EditText nameinput=(EditText)findViewById(R.id.name);
                        final EditText roll=(EditText)findViewById(R.id.rollnumber);
                        String namestr=nameinput.getText().toString();
                        String rollstr=roll.getText().toString();
                        if (TextUtils.isEmpty(namestr)||TextUtils.isEmpty(rollstr)){
                            Toast.makeText(loginpage.this,"Name or Roll number fields cannot be left blank",Toast.LENGTH_LONG).show();
                            return;
                        }
                        if( web.isChecked()||app.isChecked()||algo.isChecked()||tron.isChecked()){
                            String userinput= nameinput.getText().toString();
                            sub.putExtra("nameinput",userinput);
                            startActivityForResult(sub,1);}
                        else
                            Toast.makeText(loginpage.this,"Atleast one profile to be selected",Toast.LENGTH_LONG).show();
                    }
                }


        );

    }




}
