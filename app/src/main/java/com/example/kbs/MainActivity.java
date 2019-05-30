package com.example.kbs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg,_btnlogin;
    EditText _txtfname,_txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new database(this);
        _btnlogin =(Button)findViewById(R.id.LOGIN);
        _btnreg =(Button)findViewById(R.id.REGISTRATION);
        _txtfname =(EditText)findViewById(R.id.FNAME);
        _txtpass =(EditText)findViewById(R.id.PASSWORD);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=_txtfname.getText().toString();
                String pass=_txtpass.getText().toString();
                insertdata(fname,pass);
                Toast.makeText(getApplicationContext(), "register successfuly", Toast .LENGTH_LONG) .show();
                Toast.makeText(getApplicationContext(), "login successfuly", Toast .LENGTH_LONG) .show();
                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);



            }
        });
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                Toast.makeText(getApplicationContext(), "login successfuly", Toast .LENGTH_LONG) .show();
                Intent intent= new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);


            }
        });

    }
    public void insertdata(String fname, String pass){
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.COL_2, fname);
        contentValues.put(database.COL_3, pass);
        long id = db.insert(database.TABLE_NAME, null, contentValues);

    }

    }

