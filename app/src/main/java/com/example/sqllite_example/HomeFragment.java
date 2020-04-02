package com.example.sqllite_example;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button BnSave, BnView, BnUpdate, BnDelete;

    OnDbOpListner dbOpListner;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListner {
        public void dBOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BnSave = view.findViewById(R.id.bn_add_contact);
        BnSave.setOnClickListener(this);
        BnView = view.findViewById(R.id.bn_view_contact);
        BnView.setOnClickListener(this);
        BnUpdate = view.findViewById(R.id.bn_update_contact);
        BnUpdate.setOnClickListener(this);
        BnDelete = view.findViewById(R.id.bn_delete_contact);
        BnDelete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case  R.id.bn_add_contact:
            dbOpListner.dBOpPerformed(0);
            break;

            case R.id.bn_view_contact:
                dbOpListner.dBOpPerformed(1);
                break;

            case R.id.bn_update_contact:
                dbOpListner.dBOpPerformed(2);
                break;

            case R.id.bn_delete_contact:
                dbOpListner.dBOpPerformed(3);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try
        {
            dbOpListner = (OnDbOpListner) activity;

        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"Must implement the interface method ");
        }
    }
}