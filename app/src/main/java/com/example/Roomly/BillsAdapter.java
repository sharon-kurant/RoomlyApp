package com.example.Roomly;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
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
import java.util.zip.Inflater;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.ViewHolder> {

    private ArrayList<Bill> bills = new ArrayList<>();

    private final Context context;

    public BillsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.billName.setText(bills.get(position).getBillName());
        holder.amount.setText(bills.get(position).getAmount());
        holder.billDueDate.setText(bills.get(position).getDueDate());
        holder.billParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, bills.get(position).getBillName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        holder.deleteBtn.setOnClickListener(v -> {
            bills.remove(position);
            notifyDataSetChanged();
        });

        holder.editBtn.setOnClickListener(v -> {
            View alertView = LayoutInflater.from(context).inflate(R.layout.edit_bills_dialog, null, true);
            AlertDialog.Builder ad = new AlertDialog.Builder(context);
            AlertDialog dialog = ad.create();
            ad.setTitle("Edit bill");
            ad.setMessage("Enter bill's new attributes");
            EditText billName = alertView.findViewById(R.id.edit_bill_name);
            EditText billAmount = alertView.findViewById(R.id.edit_bill_amount);
            billName.setHint(bills.get(position).getBillName());
            billAmount.setHint(bills.get(position).getAmount());
            ad.setView(alertView);
            ad.setCancelable(true);
            ad.setNegativeButton("Cancel", null);
            ad.setPositiveButton("Save", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    String billNameStr = billName.getText().toString();
                    String amountStr = billAmount.getText().toString();
                    if(!billNameStr.equals("") && !amountStr.equals("")){
                        editBill(billNameStr,amountStr, position);
                        notifyDataSetChanged();
;                    }
                    else {
                        Toast.makeText(context, bills.get(position).getBillName() + " Did not change", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            ad.show();
        });
    }

    private void editBill(String billNameStr, String amountStr, int position) {
        bills.get(position).setBillName(billNameStr);
        bills.get(position).setAmount(amountStr);
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    public void setBills(ArrayList<Bill> bills){
        this.bills = bills;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView billName, amount, billDueDate;
        private RelativeLayout billParent;
        private Button editBtn, deleteBtn;

        public ViewHolder(View itemView){
            super(itemView);
            billName = itemView.findViewById(R.id.billName);
            amount = itemView.findViewById(R.id.amount);
            billDueDate = itemView.findViewById(R.id.billDueDate);
            billParent = itemView.findViewById(R.id.billParent);

            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            editBtn = itemView.findViewById(R.id.editBtn);

        }
    }
}
