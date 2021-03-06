package com.example.amjad.apca;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DBStudent.db";
    public static final String TABLE_NAME = "tblStudent";
    public static final String COL_1 = "std_ID";
    public static final String COL_2 = "std_FirstName";
    public static final String COL_3 = "std_LastName";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("create table %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s,%s);", TABLE_NAME, COL_1, COL_2, COL_3));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_NAME));
        onCreate(db);
    }

    public boolean insertData(String FName, String LName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, FName);
        contentValues.put(COL_3, LName);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor ViewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    public boolean updateData(String id,String FName,String LName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,FName);
        contentValues.put(COL_3,LName);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }
}
