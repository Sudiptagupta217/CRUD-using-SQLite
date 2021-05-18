package com.sudipta.crudprojectusingsqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sudipta.crudprojectusingsqlite.model.Contact;
import com.sudipta.crudprojectusingsqlite.params.Params;

import java.util.ArrayList;
import java.util.List;


public class MyDbHandeler extends SQLiteOpenHelper {

    public MyDbHandeler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    //create a table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = " CREATE TABLE IF NOT EXISTS " + Params.TABLE_NAME + " ( "
                + Params.KEY_ID + " INTEGER PRIMARY KEY , "
                + Params.KEY_NAME + " TEXT ,"
                + Params.KEY_PHONE + " TEXT " + " )";
        Log.d("DBRiju", "Query being run is " + create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //insert data
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME, null, values);
        Log.d("DBRiju", "successfull Inserted");
        db.close();
    }

    //show all data
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Generet the query to read from the data base
        String select = " SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();

                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public int upateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getPhoneNumber());

        //Lets update now
       return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
    }
}
