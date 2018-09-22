package com.example.amjad.apca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread td = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception ex) {
                    Toast toast=Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                }
                finally {
                    Intent it=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(it);
                }
            }
        };td.start();
    }
}
