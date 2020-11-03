package ca.bcit.pubhub.activities.Categories;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;

import ca.bcit.pubhub.adapters.MatchViewAdapter;
import ca.bcit.pubhub.utils.Match;
import ca.bcit.pubhub.utils.MatchModel;

public class BaseballListActivity extends ListActivity {
    private int categories;
    MatchViewAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = (Integer) getIntent().getExtras().get("categories");

        adapter = new MatchViewAdapter();

        switch (categories) {
            case 0:
                for (MatchModel m : Match.baseball_ml) {
                    adapter.addItem(m.get_category(), m.get_matchId(), m.get_team1(), m.get_team2(), m.get_date());
                }
                break;
        }

        ListView baseball_list = getListView();
        baseball_list.setAdapter(adapter);
    }
}
