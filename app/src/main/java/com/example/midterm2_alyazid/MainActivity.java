package com.example.midterm2_alyazid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    public int counter = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView counttime=findViewById(R.id.timer);
        new CountDownTimer(50000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                counttime.setText(String.valueOf(counter));
                counter--;
            }
            @Override
            public void onFinish() {
                counttime.setText("Finished");
            }
        }.start();






        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                finish();
                Intent intent = new Intent(MainActivity.this,Activity1.class);
                startActivity(intent);
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 6000);
    }
}
