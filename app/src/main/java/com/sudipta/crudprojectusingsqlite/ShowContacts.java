package com.sudipta.crudprojectusingsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowContacts extends AppCompatActivity {
    TextView textViewName;
    TextView textViewPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);

        textViewName= findViewById(R.id.rName);
        textViewPhone= findViewById(R.id.rPhone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Rname");
        String phone = intent.getStringExtra("Rphone");

        textViewName.setText(name);
        textViewPhone.setText(phone);

    }
}