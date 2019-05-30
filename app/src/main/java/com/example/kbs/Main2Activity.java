package com.example.kbs;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    EditText _txtfname,_txtpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        _btnreg =(Button)findViewById(R.id.REGISTER);
        _txtfname =(EditText)findViewById(R.id.USERNAME);
        _txtpass =(EditText)findViewById(R.id.PASSWORD);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=_txtfname.getText().toString();
                String pass=_txtpass.getText().toString();
            }
        });
    }
    public void insertdata(String fname, String pass){
        ContentValues contentValues=new ContentValues();
    }
}
