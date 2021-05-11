package com.example.Roomly.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.Roomly.Notification;
import com.example.Roomly.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private ListView notificationsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        notificationsList = root.findViewById(R.id.notificationsList);

        Notification notification_1 = new Notification("Water bill", "Pay your water bill");
        Notification notification_2 = new Notification("Wash Dishes", "It's your turn to wash the dishes");
        Notification notification_3 = new Notification("Electricity bill", "Pay your electricity bill");
        Notification notification_4 = new Notification("Cleaning", "It's your turn to mop the floor");
        Notification notification_5 = new Notification("Reminder", "Call the plumber");

        final ArrayList<Notification> notes = new ArrayList<>();
        notes.add(notification_1);
        notes.add(notification_2);
        notes.add(notification_3);
        notes.add(notification_4);
        notes.add(notification_5);


        ArrayAdapter<Notification> notesAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                notes
        );

        notificationsList.setAdapter(notesAdapter);

        notificationsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), notes.get(position).getDescription(), (Toast.LENGTH_LONG)*5 ).show();
            }
        });

        return root;
    }
}