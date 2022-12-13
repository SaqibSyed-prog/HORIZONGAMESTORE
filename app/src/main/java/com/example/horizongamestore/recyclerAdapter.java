package com.example.horizongamestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private ArrayList<UserReg> userlist;


    public recyclerAdapter(ArrayList<UserReg> userList){
        this.userlist = userList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nametxt;
        private TextView usernametxt;
        private TextView passwordtxt;



        public MyViewHolder(final View view){
            super(view);
            nametxt = view.findViewById(R.id.textView4);
            usernametxt = view.findViewById(R.id.textView5);
            passwordtxt = view.findViewById(R.id.textView6);


        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

    return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
    String name = userlist.get(position).getName();
    holder.nametxt.setText(name);
    String username = userlist.get(position).getUserName();
    holder.usernametxt.setText(username);
    String pass = userlist.get(position).getPassword();
    holder.passwordtxt.setText(pass);

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }
}
