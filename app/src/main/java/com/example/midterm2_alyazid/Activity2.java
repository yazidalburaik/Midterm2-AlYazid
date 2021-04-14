package com.example.midterm2_alyazid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button go1=findViewById(R.id.bttn_2to1);
        Button go3=findViewById(R.id.bttn_2to3);

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,Activity1.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,Activity3.class));
            }
        });

        EditText name = findViewById(R.id.Edit_Name);
        Button search =findViewById(R.id.bttn_FirstRow);
        TextView result =findViewById(R.id.txt_Search);


        DBHelper dbHelper=new DBHelper(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbHelper.getResult(name.getText().toString());
                if(c==null){
                    Toast.makeText(Activity2.this,"No Data Found",Toast.LENGTH_LONG).show();
                    return;
                }
                result.setText(c.getInt(0)+" "+
                        c.getString(1)+" "+
                        c.getString(2)+" "+
                        c.getString(3)+" "+
                        c.getString(4)+" ");









            }
        });


    }
}