package com.example.Roomly.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Roomly.BillsAdapter;
import com.example.Roomly.ChoresAdapter;
import com.example.Roomly.R;
import com.example.Roomly.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    int i = 0;
    private HomeViewModel homeViewModel;
    private RecyclerView billsRecView, choresRecView;
    private Button choresBtn, billsBtn, deleteBtn, editBtn;
    private FloatingActionButton fab;
    private TextView greetingText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_hi);
        choresBtn  = root.findViewById(R.id.choresBtn);
        billsBtn = root.findViewById(R.id.billsBtn);
        billsRecView = root.findViewById(R.id.billsRecView);
        choresRecView = root.findViewById(R.id.choresRecView);
        fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            if (choresRecView.getVisibility() == View.VISIBLE){
                AddReminderDialog dialog = new AddReminderDialog(false);
                dialog.show(getParentFragmentManager(),"AddReminderDialog");
            } else if (billsRecView.getVisibility() == View.VISIBLE){
                AddReminderDialog dialog = new AddReminderDialog(true);
                dialog.show(getParentFragmentManager(),"AddReminderDialog");
            }else
                Snackbar.make(view, "Choose Bills or Chores to add new reminder", Snackbar.LENGTH_LONG).show();

        });
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        //Generate bill recycler

        BillsAdapter billsAdapter = new BillsAdapter(root.getContext());
        billsAdapter.setBills(Utils.getInstance().getAllBills());

        billsRecView.setLayoutManager(new GridLayoutManager(root.getContext(),3));
        billsRecView.setAdapter((billsAdapter));

        ChoresAdapter choresAdapter = new ChoresAdapter(root.getContext());
        choresAdapter.setChores(Utils.getInstance().getAllChores());

        choresRecView.setLayoutManager(new GridLayoutManager(root.getContext(),3));
        choresRecView.setAdapter((choresAdapter));



        billsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresRecView.setVisibility(View.INVISIBLE);
                billsRecView.setVisibility(View.VISIBLE);
                choresBtn.setEnabled(true);
                billsBtn.setEnabled(false);
            }
        });
        choresBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billsRecView.setVisibility(View.INVISIBLE);
                choresRecView.setVisibility(View.VISIBLE);
                choresBtn.setEnabled(false);
                billsBtn.setEnabled(true);
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        return root;
    }

}