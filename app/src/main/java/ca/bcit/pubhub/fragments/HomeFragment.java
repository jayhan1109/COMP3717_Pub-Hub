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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("history/"+ userId);


        return view;
    }
}