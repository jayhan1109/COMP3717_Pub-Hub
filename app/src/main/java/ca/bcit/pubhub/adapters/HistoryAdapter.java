package ca.bcit.pubhub.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.ChatActivity;
import ca.bcit.pubhub.activities.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    public Context context;
    private List<History> mDataset;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_match_name;
        public TextView TextView_time;
        public View myRootView;
        public Button btn_go_match;
        public MyViewHolder(View v) {
            super(v);
            TextView_match_name = v.findViewById(R.id.TextView_match_name);
            TextView_time = v.findViewById(R.id.TextView_match_time);
            btn_go_match = v.findViewById(R.id.btn_go_match);
            myRootView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HistoryAdapter(List<History> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
//        Fresco.initialize(context);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_history, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final History history = mDataset.get(position);
        holder.TextView_match_name.setText(history.getMatchName());
        holder.TextView_time.setText(history.getMatchTime());
        final int matchId = history.getMatchID();
        holder.btn_go_match.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(context, ChatActivity.class);
                i.putExtra("chatId", Integer.toString(matchId));
                i.putExtra("history_name", history.getMatchName());
                context.startActivity(i);
            }
        });
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
            return mDataset == null ? 0 : mDataset.size();
    }

    public History getHistory(int index) {
        return mDataset == null? null : mDataset.get(index);
    }

    public void addHistory(History history) {
        mDataset.add(history);
        Collections.sort(mDataset);
        notifyItemInserted(mDataset.size() -1);
    }
}