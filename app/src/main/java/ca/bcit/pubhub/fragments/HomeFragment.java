package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.ChatActivity;
import ca.bcit.pubhub.activities.HomeActivity;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button logoutBtn = view.findViewById(R.id.logoutBtn);
        Button btn_move_chat = view.findViewById(R.id.btn_move_chat);
        Button btn_move_chat2 = view.findViewById(R.id.btn_move_chat2);

        // TODO: Send matchId with Intent
        btn_move_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), ChatActivity.class);
                i.putExtra("chatId", "helloWorld");
                startActivity(i);
            }
        });

        btn_move_chat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), ChatActivity.class);
                i.putExtra("chatId", "test");
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