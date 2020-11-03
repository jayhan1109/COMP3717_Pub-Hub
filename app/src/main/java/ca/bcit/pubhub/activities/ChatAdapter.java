package ca.bcit.pubhub.activities;
import ca.bcit.pubhub.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<ChatData> mDataset;
    private String myName;
    private String id;
    private Context context;
    private RecyclerView rv;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_msg;
        public TextView TextView_name;
        public View myRootView;
        public LinearLayout LinearLayout_msg;
        public MyViewHolder(View v) {
            super(v);
            TextView_msg = v.findViewById(R.id.TextView_msg);
            TextView_name = v.findViewById(R.id.TextView_name);
            LinearLayout_msg = v.findViewById(R.id.LinearLayout_msg);
            myRootView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatAdapter(List<ChatData> myDataset, Context context, String myName, String id, RecyclerView rv) {
        mDataset = myDataset;
        this.context = context;
//        Fresco.initialize(context);
        this.myName = myName;
        this.id = id;
        this.rv = rv;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ChatData chat = mDataset.get(position);
        holder.TextView_name.setText(chat.getName());
        holder.TextView_msg.setText(chat.getMsg());
        System.out.println(chat.getName() + "    "  + myName);
        if(chat.getId().equals(this.id)) {
            holder.LinearLayout_msg.setGravity(Gravity.RIGHT);
            holder.TextView_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            holder.TextView_msg.setGravity(Gravity.RIGHT);
            holder.TextView_msg.setBackgroundResource(R.drawable.round_corner2);
            holder.TextView_msg.setTextColor(Color.WHITE);
        } else {
            holder.TextView_name.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            holder.TextView_msg.setGravity(Gravity.LEFT);
            holder.TextView_msg.setBackgroundResource(R.drawable.round_corner);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
            return mDataset == null ? 0 : mDataset.size();
    }

    public ChatData getChat(int index) {
        return mDataset == null? null : mDataset.get(index);
    }

    public void addChat(ChatData chat) {
        mDataset.add(chat);
        rv.scrollToPosition(mDataset.size() -1);
        notifyItemInserted(mDataset.size() -1);
    }
}