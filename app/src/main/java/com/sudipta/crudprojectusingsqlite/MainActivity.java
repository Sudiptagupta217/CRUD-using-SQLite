package com.sudipta.crudprojectusingsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sudipta.crudprojectusingsqlite.data.MyDbHandeler;
import com.sudipta.crudprojectusingsqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

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


        //update rows
        leri.setId(2);
        leri.setName("Aankik");
        leri.setPhoneNumber("9809876541");
        int affecterRows = db.upateContact(leri);

        Log.d("DBRiju", "No of offected rows are " + affecterRows);


        //delete
        db.deleteContactById(1);
        db.deleteContactById(3);
        db.deleteContactById(11);

        listView = findViewById(R.id.listview);
        ArrayList<String> contacts = new ArrayList<>();

        //get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for (Contact contact : allContacts) {
            Log.d("DBRiju", "Id " + contact.getId() +
                    " Name " + contact.getName() +
                    " Phone Number " + contact.getPhoneNumber());

            contacts.add(contact.getName() + " (" + contact.getPhoneNumber() + ")");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text =  ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

        //show getcount
        Log.d("DBRiju", "you have " + db.getCount() + " contacts in your database");

    }

}