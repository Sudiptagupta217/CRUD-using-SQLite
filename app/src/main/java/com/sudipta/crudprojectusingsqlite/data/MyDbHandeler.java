package com.sudipta.crudprojectusingsqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sudipta.crudprojectusingsqlite.model.Contact;
import com.sudipta.crudprojectusingsqlite.params.Params;


public class MyDbHandeler extends SQLiteOpenHelper {

    public MyDbHandeler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + "INTEGER PRIMARY KEY,"
                + Params.KEY_NAME + "TEXT,"
                + Params.KEY_PHONE + "TEXT" + ")";
        Log.d("DBRiju","Query being run is"+create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME, null,values);
        Log.d("DBRiju","successfull Inserted");
        db.close();
    }
}
