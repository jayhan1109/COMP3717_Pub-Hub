package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

import ca.bcit.pubhub.activities.ChatActivity;
import ca.bcit.pubhub.activities.History;
import ca.bcit.pubhub.adapters.MatchViewAdapter;
import ca.bcit.pubhub.items.MatchViewItem;
import ca.bcit.pubhub.utils.Match;
import ca.bcit.pubhub.utils.MatchModel;

public class MatchListFragment extends ListFragment {
    MatchViewAdapter adapter;
    DatabaseReference myRef;
    String userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new MatchViewAdapter();
        setListAdapter(adapter);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid();
        myRef = database.getReference("history/"+ userId);


        for (MatchModel m : Match.soccer_epl) {
            adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
        }
        for (MatchModel m : Match.soccer_laliga) {
            adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
        }
        for (MatchModel m : Match.soccer_bundesliga) {
            adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
        }
        for (MatchModel m : Match.basketball_nba) {
            adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
        }
        for (MatchModel m : Match.baseball_mlb) {
            adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
        }
        for (MatchModel m : Match.esports_lol) {
            adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void addItem(int c, int m, String t1, String t2, Date d) {
        adapter.addItem(c, m, t1, t2, d);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        final MatchViewItem item = adapter.getMatchViewItem(position);
        final int matchId = item.get_matchId();
        History history = new History();
        history.setMatchID(item.get_matchId());
        history.setHistoryTime(ServerValue.TIMESTAMP);
        history.setMatchTime(item.get_date().toString());
        history.setMatchName(item.get_team1() + " vs " + item.get_team2());
        System.out.println(item.get_team1() + item.get_team2());
        intent.putExtra("chatId", Integer.toString(matchId));
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    History h = snapshot.getValue(History.class);
                    if(h.getMatchID() == matchId){
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
        startActivity(intent);
    }
}
