package com.example.Roomly.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.Roomly.Bill;
import com.example.Roomly.Chore;
import com.example.Roomly.R;
import com.example.Roomly.Utils;
import com.google.android.material.snackbar.Snackbar;

public class AddReminderDialog extends DialogFragment {

    private EditText editReminderName, editReminderDueDate, editReminderPrice;
    private TextView okBtn, cancelBtn, heading;
    boolean isBill;

    public AddReminderDialog(boolean isBill) {
        this.isBill = isBill;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.dialog_add_bill_chore, container, false);

        heading = view.findViewById(R.id.heading);
        editReminderName = view.findViewById(R.id.add_name);
        editReminderDueDate = view.findViewById(R.id.add_due_date);
        editReminderPrice = view.findViewById(R.id.add_amount);
        if (!isBill) {
            heading.setText("Add new chore reminder");
            editReminderPrice.setVisibility(View.GONE);
        }else{
            heading.setText("Add new bill reminder");
        }

        okBtn = view.findViewById(R.id.action_ok);
        cancelBtn = view.findViewById(R.id.action_cancel);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reminderName = editReminderName.getText().toString();
                String reminderDueDate = editReminderDueDate.getText().toString();
                String reminderPrice = editReminderPrice.getText().toString();
                if (!isBill) {
                    if (!reminderName.equals("") && !reminderDueDate.equals("")){
                        Utils.getInstance().getAllChores().add(new Chore(reminderName,reminderDueDate));
                    }else{
                        Toast.makeText(getActivity(), "Missing some information, Try again", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if (!reminderName.equals("") && !reminderDueDate.equals("") && !reminderPrice.equals("")) {
                        Utils.getInstance().getAllBills().add(new Bill(reminderName,reminderDueDate,reminderPrice));
                    }else{
                        Toast.makeText(getActivity(), "Missing some information, Try again", Toast.LENGTH_SHORT).show();
                    }
                }
                getDialog().dismiss();
            }
        });

        return view;
    }

}
