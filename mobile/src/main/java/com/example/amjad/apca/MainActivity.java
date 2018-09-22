package com.example.amjad.apca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMessageBox;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);
        btnMessageBox=(Button)findViewById(R.id.btnMessageBox);
        btnMessageBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(getApplicationContext(),"Enter Both Name and Password");
            }
        });
    }
}
