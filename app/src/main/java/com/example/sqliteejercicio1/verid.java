package com.example.sqliteejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class verid extends AppCompatActivity {
EditText elid;
Button ver;
TextView res;

adminclase conn;

    private static final String DB_NAME = "usersdb";
    private static final String TABLE_Users = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOC = "location";
    private static final String KEY_DESG = "designation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verid);

    conn=new adminclase(getApplicationContext(),"usersdb",null,1);

        res=findViewById(R.id.resultado);
        elid=findViewById(R.id.id);
        ver=findViewById(R.id.ver);

       ver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               consultaporcodigo();

               InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
               inputMethodManager.hideSoftInputFromWindow(res.getWindowToken(), 0);
           }
       });

    }

 public void consultaporcodigo() {

     SQLiteDatabase db=conn.getReadableDatabase();
    String[] parametros={elid.getText().toString()};
     String para=elid.getText().toString();


     Cursor c = db.rawQuery("SELECT * FROM userdetails WHERE id = ?", parametros);
     if (c.moveToFirst()){
         do {
             // Passing values
             String column1 = c.getString(0);
             String column2 = c.getString(1);
             String column3 = c.getString(2);

             res.setText(column1+ "-" +column2+ "-" +column3);

             // Do something Here with values
         } while(c.moveToNext());
     }
     c.close();
     db.close();




















}



}
