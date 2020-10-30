package ca.bcit.pubhub.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Date;

import ca.bcit.pubhub.adapters.MatchViewAdapter;
import ca.bcit.pubhub.items.MatchViewItem;
import ca.bcit.pubhub.utils.Match;
import ca.bcit.pubhub.utils.MatchModel;

public class MatchListFragment extends ListFragment {

    MatchViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new MatchViewAdapter();
        setListAdapter(adapter);

        for (
                MatchModel m : Match.soccer_epl) {
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
        for (MatchModel m : Match.baseball_ml) {
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
}
