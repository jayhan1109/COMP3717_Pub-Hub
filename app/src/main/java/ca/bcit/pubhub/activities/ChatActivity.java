package ca.bcit.pubhub.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.adapters.ChatAdapter;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private String name;
    private String id;
    ImageView send_img;
    EditText EditText_chat;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TextView vs_id = findViewById(R.id.vs_id);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        name = user.getEmail();
        int iend = name.indexOf("@");
        name = name.substring(0, iend);
        id = user.getUid();


        send_img = findViewById(R.id.send_img);
        EditText_chat = findViewById(R.id.EditText_chat);
        Bundle extra = getIntent().getExtras();
        String chatId = extra.getString("chatId");

        String team1_name = extra.getString("team1_id");
        String team2_name = extra.getString("team2_id");

        if(team1_name == null || team2_name == null) {
            vs_id.setText(extra.getString("history_name"));
        } else {
            TextView team1_id = findViewById(R.id.team1_id);
            team1_id.setText(team1_name);
            TextView team2_id = findViewById(R.id.team2_id);
            team2_id.setText(team2_name);
        }

        send_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = EditText_chat.getText().toString();
                if(msg != null) {
                    ChatData chat = new ChatData();
                    chat.setName(name);
                    chat.setMsg(msg);
                    chat.setId(id);
                    myRef.push().setValue(chat);
                    EditText_chat.setText("");
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<ChatData> chatList = new ArrayList<>();
        mAdapter = new ChatAdapter(chatList, ChatActivity.this, name, id, recyclerView);
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message/" + chatId);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ChatData chat = snapshot.getValue(ChatData.class);
                ((ChatAdapter)mAdapter).addChat(chat);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}