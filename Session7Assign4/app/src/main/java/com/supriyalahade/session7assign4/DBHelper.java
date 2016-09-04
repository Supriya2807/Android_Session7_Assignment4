package com.supriyalahade.session7assign4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by BIDWAI on 31-08-2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    private static final String DB_NAME = "CONTACT_NAME";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "NAME_TABLE";
    private static final String COL_ID = "ID";
    private static final String COL_FIRST = "FIRST";
    private static final String COL_LAST = "LAST";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = " CREATE TABLE " + TABLE_NAME + "( " + COL_ID + " INTEGER PRIMARY KEY, " + COL_FIRST  + " TEXT, " + COL_LAST + " TEXT);";
        sqLiteDatabase.execSQL(create_table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertName(String first,String last){
        sqLiteDatabase= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FIRST,first);
        values.put(COL_LAST,last);
        sqLiteDatabase.insert(TABLE_NAME,null,values);

        sqLiteDatabase.close();

    }


    public void getName(TextView textView){
        sqLiteDatabase= this.getReadableDatabase();
        String select_all = "Select * from "+TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(select_all,null);

        if(cursor.moveToFirst()){

            do{
                int id = cursor.getInt(0);
                String first= cursor.getString(1);
                String last= cursor.getString(2);

                System.out.println("==============>>>"+ id+"   "+first+"   "+last);
                textView.append("Id:"+ id +" First Name:"+ first +"  Last Name:"+last+"\n");

            }while (cursor.moveToNext());


        }



        }




}
