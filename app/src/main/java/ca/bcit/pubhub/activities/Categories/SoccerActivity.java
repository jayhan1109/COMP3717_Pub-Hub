package ca.bcit.pubhub.activities.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ca.bcit.pubhub.R;
//getResources().getStringArray(R.array.soccer_array)
public class SoccerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer);

        ListView soccer_list = findViewById(R.id.soccer_listview);

        soccer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SoccerActivity.this, SoccerListActivity.class);
                intent.putExtra("categories", (int) position);
                startActivity(intent);
            }
        });

    }
}
