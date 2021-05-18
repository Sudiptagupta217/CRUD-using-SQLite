package com.sudipta.crudprojectusingsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sudipta.crudprojectusingsqlite.data.MyDbHandeler;
import com.sudipta.crudprojectusingsqlite.model.Contact;

import java.util.List;

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

        Log.d("DBRiju", "name are: " + riju.getName() + "," + leri.getName() + "," + sudipta.getName());


        //update table
        leri.setId(2);
        leri.setName("Aankik");
        leri.setPhoneNumber("9809876541");
        int affecterRows = db.upateContact(leri);

        Log.d("DBRiju", "No of offected rows are " + affecterRows);


        //get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for (Contact contact : allContacts) {
            Log.d("DBRiju", "Id " + contact.getId() +
                    " Name " + contact.getName() +
                    " Phone Number " + contact.getPhoneNumber());
        }
    }
}