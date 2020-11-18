package ca.bcit.pubhub.activities.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.adapters.CategoryAdapter;
import ca.bcit.pubhub.items.CategoryViewItem;

public class SoccerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer);

        ArrayList<CategoryViewItem>  category_view_item_list = new ArrayList<CategoryViewItem>();
        category_view_item_list.add(new CategoryViewItem("EPL"));
        category_view_item_list.add(new CategoryViewItem("La Liga"));
        category_view_item_list.add(new CategoryViewItem("Bundesliga"));


        ListView soccer_listview = findViewById(R.id.soccer_listview);

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), R.layout.category_item_view, category_view_item_list);
        soccer_listview.setAdapter(adapter);

        soccer_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SoccerActivity.this, SoccerListActivity.class);
                intent.putExtra("categories", (int) position);
                startActivity(intent);
            }
        });

    }
}
