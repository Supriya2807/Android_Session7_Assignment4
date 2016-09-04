package com.supriyalahade.session7assign4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.display_textview);

        dbHelper = new DBHelper(this);

        dbHelper.insertName("Supriya","Lahade");

        dbHelper.insertName("Kasturi","Bidwai");

        dbHelper.insertName("Judy","Simons");

        dbHelper.insertName("Sachin","Tendulkar");
       dbHelper.getName(textView);



    }
}
