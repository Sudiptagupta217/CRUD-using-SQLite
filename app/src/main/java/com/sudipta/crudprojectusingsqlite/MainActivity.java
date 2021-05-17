package com.sudipta.crudprojectusingsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sudipta.crudprojectusingsqlite.data.MyDbHandeler;
import com.sudipta.crudprojectusingsqlite.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandeler db = new MyDbHandeler(MainActivity.this);

        //Creating a contact object for the db
        Contact riju = new Contact();
        riju.setName("Riju");
        riju.setPhoneNumber("9090909090");

        //adding a contact to he db
        db.addContact(riju);

        //Creating a contact object for the db
        Contact leri = new Contact();
        leri.setName("Leri");
        leri.setPhoneNumber("6789709090");

        //adding a contact to the db
        db.addContact(leri);

        //Creating a contact object for the db
        Contact sudipta = new Contact();
        sudipta.setName("Sudipta");
        sudipta.setPhoneNumber("9087609090");

        //adding a contact to he db
        db.addContact(sudipta);

        Log.d("DBRiju","name are: "+ riju.getName()+","+leri.getName()+","+sudipta.getName());
    }
}