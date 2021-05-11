package com.example.Roomly.ui.roommates;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.Roomly.Gender;
import com.example.Roomly.R;
import com.example.Roomly.Roommate;
import com.example.Roomly.RoommatesDialog;

import java.util.ArrayList;

public class RoommatesFragment extends Fragment {

    private static final String TAG = "RoommatesFragment";


    private RoommatesViewModel roommatesViewModel;

    private ListView roommatesList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        roommatesViewModel =
                new ViewModelProvider(this).get(RoommatesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_roommates, container, false);
        final Button inviteBtn = root.findViewById(R.id.inviteBtn);

        roommatesList = root.findViewById(R.id.roommatesList);

        //creating "roommates" of type Roommate to fill in the Roommates screen.
        Roommate monica = new Roommate(111111111,"Monica", "Geller", "monica@geller.com",
                "0541234567", Gender.Female, "New York apartment 20");
        Roommate chandler = new Roommate(111111112, "Chandler", "Bing", "chanandler@bong.com",
                "0541234568", Gender.Male, "New York apartment 20");
        Roommate rachel = new Roommate(111111113, "Rachel", "Green", "princess@rachel.com",
                "0541234569", Gender.Female, "New York apartment 20");

        final ArrayList<String> roommates = new ArrayList<>();
        roommates.add(monica.getFirstName() + " " + monica.getLastName());
        roommates.add(chandler.getFirstName() + " " + chandler.getLastName());
        roommates.add(rachel.getFirstName() + " " + rachel.getLastName());

        final ArrayAdapter<String> roommatesAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                roommates
        );

        roommatesList.setAdapter(roommatesAdapter);

        roommatesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (isselected -> delete item)
            }
        });



        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog.");

                RoommatesDialog dialog = new RoommatesDialog();
                dialog.show(getParentFragmentManager(),"CustomDialog");

            }
        });
        return root;
    }
}