package com.sudipta.crudprojectusingsqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sudipta.crudprojectusingsqlite.R;
import com.sudipta.crudprojectusingsqlite.ShowContacts;
import com.sudipta.crudprojectusingsqlite.model.Contact;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    //What to get the single card as viewHolder object
    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new viewHolder(view);
    }

    //what will happen after we create the viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder viewHolder, int position) {
        Contact contact = contactList.get(position);

        viewHolder.contactname.setText(contact.getName());
        viewHolder.phoneNumber.setText(contact.getPhoneNumber());
    }

    //How many items?
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView contactname;
        private TextView phoneNumber;
        private ImageView iconButton;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contactname = itemView.findViewById(R.id.contactName);
            phoneNumber = itemView.findViewById(R.id.contactNumber);
            iconButton = itemView.findViewById(R.id.imageView);

        }

        @Override
        public void onClick(View v) {
            Log.d("DBRiju", "clicked");
            int position = this.getAdapterPosition();
            Contact contact = contactList.get(position);
            String name = contact.getName();
            String phone = contact.getPhoneNumber();
            String msg = "The position :" +position +", Name: " +name+", phone: "+phone;
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, ShowContacts.class);
            intent.putExtra("Rname",name);
            intent.putExtra("Rphone",phone);
            context.startActivity(intent);
        }
    }
}
