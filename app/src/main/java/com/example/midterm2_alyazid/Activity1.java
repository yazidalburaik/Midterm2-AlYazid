package com.example.midterm2_alyazid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper=new DBHelper(this);
        setContentView(R.layout.activity_1);
        setTitle("You are in Activity3");

        Button go1=findViewById(R.id.btn_go_3act1);
        Button go2=findViewById(R.id.btn_go_3act2);


        Button add = findViewById(R.id.btn_add);

        EditText inp_ID=findViewById(R.id.inp_ID);
        EditText inp_name=findViewById(R.id.inp_name);
        EditText inp_Email=findViewById(R.id.inp_email);
        EditText inp_Phone=findViewById(R.id.inp_phone);
        EditText inp_PID=findViewById(R.id.inp_pid);



        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity1.this,Activity2.class));
            }
        });
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity1.this,Activity3.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if (inp_ID==null&&inp_name==null&&inp_Email==null){
    Toast.makeText(Activity1.this,"Please fill in information",Toast.LENGTH_LONG).show();
}
else {
    dbHelper.insert(inp_ID.getText().toString(), inp_name.getText().toString(), inp_Email.getText().toString(), inp_Phone.getText().toString(), inp_PID.getText().toString());

}

        }

        });




    }
}