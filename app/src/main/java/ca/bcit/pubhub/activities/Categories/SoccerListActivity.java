package ca.bcit.pubhub.activities.Categories;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import ca.bcit.pubhub.activities.ChatActivity;
import ca.bcit.pubhub.activities.History;
import ca.bcit.pubhub.adapters.MatchViewAdapter;
import ca.bcit.pubhub.items.MatchViewItem;
import ca.bcit.pubhub.utils.Match;
import ca.bcit.pubhub.utils.MatchModel;

public class SoccerListActivity extends ListActivity {
    private int categories;
    MatchViewAdapter adapter;
    DatabaseReference myRef;
    String userId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = (Integer) getIntent().getExtras().get("categories");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userId = user.getUid();
        myRef = database.getReference("history/"+ userId);

        adapter = new MatchViewAdapter();

        switch (categories) {
            case 0:
                for (MatchModel m : Match.soccer_epl) {
                    adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
                }
                break;
            case 1:
                for (MatchModel m : Match.soccer_laliga) {
                    adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
                }
                break;
            case 2:
                for (MatchModel m : Match.soccer_bundesliga) {
                    adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
                }
                break;
        }

        ListView soccerlist = getListView();
        soccerlist.setAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println(userId);
        Intent intent = new Intent(this, ChatActivity.class);
        final MatchViewItem item = adapter.getMatchViewItem(position);
        final int matchId = item.get_matchId();
        History history = new History();
        history.setMatchID(item.get_matchId());
        history.setHistoryTime(ServerValue.TIMESTAMP);
        history.setMatchTime(item.get_date().toString());
        history.setMatchName(item.get_team1() + " vs " + item.get_team2());
        System.out.println(item.get_team1() + item.get_team2());
        intent.putExtra("chatId", Integer.toString(matchId));

        intent.putExtra("team1_id", item.get_team1());
        intent.putExtra("team2_id", item.get_team2());


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

