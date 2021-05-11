package com.example.Roomly;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

public class RoommatesDialog extends DialogFragment {
    private static final String TAG = "CustomDialog";


    public RoommatesDialog()
    {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_roommates_dialog, new ConstraintLayout(getActivity()), false);

        // Retrieve layout elements
        TextView title = (TextView) view.findViewById(R.id.heading);
        EditText email = (EditText) view.findViewById(R.id.input);
        Button sendButton = (Button) view.findViewById(R.id.send_invite);
        Button cancelButton = (Button) view.findViewById(R.id.cancel_invite);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };


        handler.postDelayed(runnable, 5000);

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getActivity(), "Invitation sent successfully!" , Toast.LENGTH_LONG ).show();
                handler.postDelayed(runnable, 5000);

                dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                dismiss();
            }
        });


        // Build dialog
        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        builder.setContentView(view);
        return builder;
    }
}
