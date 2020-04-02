package com.example.sqllite_example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteContactFragment extends Fragment {
   private EditText Id;
   private Button Button_Delete;
    public DeleteContactFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete_contact, container, false);
        Id =view.findViewById(R.id.txt_delete_id);
        Button_Delete = view.findViewById(R.id.delete_contact_bn);
        Button_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact();
            }
        });


        return view;
    }
    public void deleteContact()
    {
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getWritableDatabase();

        int id = Integer.parseInt(Id.getText().toString());

        contactDbHelper.deleteContact(id,database);
        contactDbHelper.close();
        Id.setText("");
        Toast.makeText(getActivity(), "Contact Deleted", Toast.LENGTH_SHORT).show();
    }

}
