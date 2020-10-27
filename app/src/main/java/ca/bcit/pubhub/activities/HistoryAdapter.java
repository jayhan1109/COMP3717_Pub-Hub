package ca.bcit.pubhub.activities;

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
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import ca.bcit.pubhub.R;

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
        long unixTime = (long) history.getMatchTime();
        Date date = new Date(unixTime);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
        String time = simpleDateFormat.format(date);
        holder.TextView_time.setText(time);
        final String matchId = history.getMatchID();
        holder.btn_go_match.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(context, ChatActivity.class);
                i.putExtra("chatId", matchId);
                context.startActivity(i);
            }
        });
//        holder.TextView_time.setText((String)history.getMatchTime());
//        holder.TextView_name.setText(chat.getName());
//        holder.TextView_msg.setText(chat.getMsg());
//        System.out.println(chat.getName() + "    "  + myName);
//        if(chat.getId().equals(this.id)) {
//            holder.TextView_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
//            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
//        } else {
//            holder.TextView_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
//            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
//        }
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