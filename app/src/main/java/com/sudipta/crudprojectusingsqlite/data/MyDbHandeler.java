package com.sudipta.crudprojectusingsqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sudipta.crudprojectusingsqlite.params.Params;

import androidx.annotation.Nullable;

public class MyDbHandeler extends SQLiteOpenHelper {

    public MyDbHandeler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
