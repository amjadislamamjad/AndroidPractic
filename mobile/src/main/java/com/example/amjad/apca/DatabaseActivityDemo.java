package com.example.amjad.apca;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatabaseActivityDemo extends AppCompatActivity {
    DatabaseHelper db;
    Button btnInsert, btnView, btnUpdate;
    EditText editTextFName, editTextLName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        db = new DatabaseHelper(getApplicationContext());

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnView = (Button) findViewById(R.id.btnView);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        editTextFName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLName = (EditText) findViewById(R.id.editTextLastName);

        AddData();
        ViewData();
        getUpdateData();
    }

    public void getUpdateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                } catch (Exception ex) {
                    Message.AlertMessage(DatabaseActivityDemo.this,"Data Update",ex.getMessage());
                }
            }
        });
    }

    public void AddData() {
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    boolean result = db.insertData(editTextFName.getText().toString(), editTextLName.getText().toString());
                    if (result)
                        Message.AlertMessage(DatabaseActivityDemo.this, "Data Saving", "Record Save Successfully");
                    else
                        Message.AlertMessage(DatabaseActivityDemo.this, "Data Saving Error", "Record Not Saved");
                } catch (Exception ex) {
                    Message.AlertMessage(DatabaseActivityDemo.this, "Data Saving Error", ex.getMessage());
                }
            }
        });
    }

    public void ViewData() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.ViewData();
                if (cursor.getCount() == 0) {
                    Message.AlertMessage(DatabaseActivityDemo.this, "Data Base", "No Data Found");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (cursor.moveToNext()) {
                        buffer.append("ID :" + cursor.getString(0) + "\n");
                        buffer.append("Name :" + cursor.getString(1) + " " + cursor.getString(2) + "\n");
                        buffer.append("....................." + "\n");
                    }
                    Message.AlertMessage(DatabaseActivityDemo.this, "Record Show", buffer.toString());
                }
            }
        });
    }
}
