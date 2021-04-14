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

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        setTitle("You are in Activity2");

        Button go1=findViewById(R.id.bttn_2to1);
        Button go3=findViewById(R.id.bttn_2to3);

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this,Activity1.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this,Activity2.class));
            }
        });


        Button select_1=findViewById(R.id.bttn_FirstRow);
        Button delete_1=findViewById(R.id.bttn_Delete);
        TextView viewFirst=findViewById(R.id.txt_Search);
        EditText deleteID=findViewById(R.id.txt_idDelete);


        DBHelper dbHelper=new DBHelper(this);

        select_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbHelper.getFirstRow();
                if (c==null){
                    Toast.makeText(Activity3.this,"No data to read.",Toast.LENGTH_SHORT).show();
                    return;
                }
                viewFirst.setText(c.getInt(0)+" "+
                        c.getString(1)+" "+
                        c.getString(2)+" "+
                        c.getString(3)+" "+
                        c.getString(4)+" ");

            }
        });
        delete_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(deleteID.getText().toString());
                Toast.makeText(Activity3.this,"Successfully deleted entry",Toast.LENGTH_SHORT).show();
            }
        });




    }
}