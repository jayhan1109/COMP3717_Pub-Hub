package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.HistoryActivity;
import ca.bcit.pubhub.activities.HomeActivity;

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        Button history_button = view.findViewById(R.id.btn_history);
        Button logoutBtn = view.findViewById(R.id.logoutBtn);

        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), HistoryActivity.class);
                startActivity(i);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) getActivity()).logoutClick();
            }
        });

        return view;
    }
}
