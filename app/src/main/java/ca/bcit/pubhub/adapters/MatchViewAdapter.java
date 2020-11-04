package ca.bcit.pubhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.items.MatchViewItem;

public class MatchViewAdapter extends BaseAdapter {

    private ArrayList<MatchViewItem> matchViewItemList = new ArrayList<MatchViewItem>();

    @Override
    public int getCount() {
        return matchViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return matchViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final Context context = parent.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.match_item_view, parent, false);
        }

        TextView categoryView = (TextView) view.findViewById(R.id.categoryId);
        TextView matchView = (TextView) view.findViewById(R.id.matchId);
        TextView team1View = (TextView) view.findViewById(R.id.team1);
        TextView team2View = (TextView) view.findViewById(R.id.team2);
        TextView dateView = (TextView) view.findViewById(R.id.date);

        MatchViewItem listViewItem = matchViewItemList.get(i);

        categoryView.setText(listViewItem.get_categoryId() + "");
        matchView.setText(listViewItem.get_matchId() + "");
        team1View.setText(listViewItem.get_team1());
        team2View.setText(listViewItem.get_team2());
        dateView.setText(listViewItem.get_date().toString());
        return view;
    }

    public MatchViewItem getMatchViewItem(int index) {
        return matchViewItemList.get(index);
    }

    public void addItem(int c, int m, String t1, String t2, Date d) {
        MatchViewItem item = new MatchViewItem();

        item.set_categoryId(c);
        item.set_matchId(m);
        item.set_team1(t1);
        item.set_team2(t2);
        item.set_date(d);

        matchViewItemList.add(item);
    }
}
