package com.hob.zahidhasan.sqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBQuery db = new DBQuery(this);
        db.createDatabase();
        db.open();
        String string = db.getCategories(1).toString();
        ArrayList<Categories> cat = new ArrayList<>();
        cat = db.getAllCategories();
//        Toast.makeText(this, cat.toString(), Toast.LENGTH_LONG).show();

        Log.e("ZahidApp", cat.toString());

        db.close();

    }
}
