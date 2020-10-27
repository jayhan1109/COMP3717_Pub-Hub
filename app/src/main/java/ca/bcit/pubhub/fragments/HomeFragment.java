package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.sql.Timestamp;
import java.util.Date;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.ChatActivity;
import ca.bcit.pubhub.activities.History;
import ca.bcit.pubhub.activities.HistoryActivity;
import ca.bcit.pubhub.activities.HomeActivity;

public class HomeFragment extends Fragment {
    DatabaseReference myRef;
    String userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button logoutBtn = view.findViewById(R.id.logoutBtn);
        Button btn_move_chat = view.findViewById(R.id.btn_move_chat);
        Button btn_move_chat2 = view.findViewById(R.id.btn_move_chat2);
        Button btn_history = view.findViewById(R.id.btn_history);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("history/"+ userId);

        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), HistoryActivity.class);
                startActivity(i);
            }
        });

        // TODO: Send matchId with Intent
        btn_move_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), ChatActivity.class);
                i.putExtra("chatId", "helloWorld");

                History history = new History();
                final String matchId = "helloWorld";
                history.setMatchID(matchId);
                history.setMatchName("Tes vs Tes");
                history.setMatchTime(ServerValue.TIMESTAMP);
                history.setHistoryTime(ServerValue.TIMESTAMP);
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            History h = snapshot.getValue(History.class);
                            if(h.getMatchID().equals(matchId)){
//                                String key = snapshot.getKey();
                                DatabaseReference newRef = snapshot.getRef();
                                newRef.removeValue();
                                return;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

                myRef.push().setValue(history);
                startActivity(i);
            }
        });

        btn_move_chat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(), ChatActivity.class);
                i.putExtra("chatId", "test");

                History history = new History();
                final String matchId = "test";
                history.setMatchID(matchId);
                history.setMatchName("GenG vs DWG");
                history.setMatchTime(ServerValue.TIMESTAMP);
                history.setHistoryTime(ServerValue.TIMESTAMP);
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            History h = snapshot.getValue(History.class);
                            if(h.getMatchID().equals(matchId)){
//                                String key = snapshot.getKey();
                                DatabaseReference newRef = snapshot.getRef();
                                newRef.removeValue();
                                return;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

                myRef.push().setValue(history);
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