package com.example.Roomly;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChoresAdapter extends RecyclerView.Adapter<ChoresAdapter.ViewHolder> {

    private ArrayList<Chore> chores = new ArrayList<>();

    private final Context context;

    public ChoresAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ChoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chore_list_item, parent, false);
        ChoresAdapter.ViewHolder holder = new ChoresAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChoresAdapter.ViewHolder holder, final int position) {
        holder.choreName.setText(chores.get(position).getChoreName());
        holder.choreDueDate.setText(chores.get(position).getDueDate());
        holder.choreParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, chores.get(position).getChoreName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        holder.deleteBtn.setOnClickListener(v -> {
            chores.remove(position);
            notifyDataSetChanged();
        });

        holder.editBtn.setOnClickListener(v -> {
            View alertView = LayoutInflater.from(context).inflate(R.layout.edit_chores_dialog, null, true);
            AlertDialog.Builder ad = new AlertDialog.Builder(context);
            AlertDialog dialog = ad.create();
            ad.setTitle("Edit chore");
            ad.setMessage("Enter chore's new attributes");
            EditText choreName = alertView.findViewById(R.id.edit_chore_name);
            choreName.setHint(chores.get(position).getChoreName());
            ad.setView(alertView);
            ad.setCancelable(true);
            ad.setNegativeButton("Cancel", null);
            ad.setPositiveButton("Save", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    String choreNameStr = choreName.getText().toString();
                    if(!choreNameStr.equals("")){
                        editChore(choreNameStr, position);
                        notifyDataSetChanged();
                        ;                    }
                    else {
                        Toast.makeText(context, chores.get(position).getChoreName() + " Did not change", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            ad.show();
        });
    }

    private void editChore(String choreNameStr, int position) {
        chores.get(position).setChoreName(choreNameStr);
    }

    @Override
    public int getItemCount() {
        return chores.size();
    }

    public void setChores(ArrayList<Chore> chores){
        this.chores = chores;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView choreName, choreDueDate;
        private RelativeLayout choreParent;
        private Button editBtn, deleteBtn;

        public ViewHolder(View itemView){
            super(itemView);
            choreName = itemView.findViewById(R.id.choreName);
            choreDueDate = itemView.findViewById(R.id.choreDueDate);
            choreParent = itemView.findViewById(R.id.choreParent);

            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            editBtn = itemView.findViewById(R.id.editBtn);

        }
    }
}
