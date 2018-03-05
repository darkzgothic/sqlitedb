package com.hob.zahidhasan.sqlitedb;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zahid on 10/4/2017.
 */

public class DBQuery {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private ArrayList<Categories> categories;

    public DBQuery(Context context) {
        dbHelper = new DBHelper(context);
        categories = new ArrayList<>();
    }

    public DBQuery createDatabase() throws SQLException {
        try {
            dbHelper.createDataBase();
        } catch (IOException ignored) {
        }
        return this;
    }

    public DBQuery open() throws SQLException {
        try {
            dbHelper.openDataBase();
            dbHelper.close();
            db = dbHelper.getReadableDatabase();
        } catch (SQLException ignored) {
        }
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    //______________________________________________________________________________________________
    //__________________________________      QUERIES      ________________________________________
    //______________________________________________________________________________________________
    public ArrayList<String> getCategories(int id) {
        String sql = "SELECT * FROM categories WHERE parent_id='" + id + "';";
        Cursor cursor = db.rawQuery(sql, null);
        try {
            ArrayList<String> categoriesName = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    //ArrayList<Categories> categories = new ArrayList<>();
                    //categories.add(new Categories(cursor.getInt(0), cursor.getInt(1), cursor.getString(2)));
                    categoriesName.add(cursor.getString(2));
                } while (cursor.moveToNext());
            }
            return categoriesName;
        } catch (Exception ignored) {
        } finally {
            cursor.close();
        }
        return null;
    }

    public ArrayList<Categories> getAllCategories(){
        categories.clear();

        String query = "SELECT * FROM categories";

        Cursor cursor = db.rawQuery(query, null);
        try{
            if (cursor.moveToFirst()){
                do {
                    Categories ct = new Categories();

                    ct.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    ct.setParentId(cursor.getInt(cursor.getColumnIndex("parent_id")));
                    ct.setCategoryName(cursor.getString(cursor.getColumnIndex("category_name")));

                    categories.add(ct);
                }while (cursor.moveToNext());
            }
        }catch (Exception ignored){

        }finally {
            cursor.close();
        }

        return categories;
    }
}
