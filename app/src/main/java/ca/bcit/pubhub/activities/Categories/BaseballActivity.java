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

public class BaseballActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);
        
        ArrayList<CategoryViewItem> category_view_item_list = new ArrayList<CategoryViewItem>();
        category_view_item_list.add(new CategoryViewItem("MLB"));
        category_view_item_list.add(new CategoryViewItem("KBO"));
        category_view_item_list.add(new CategoryViewItem("NPB"));

        ListView baseball_listview = findViewById(R.id.baseball_listview);

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), R.layout.category_item_view, category_view_item_list);
        baseball_listview.setAdapter(adapter);

        baseball_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BaseballActivity.this, BaseballListActivity.class);
                intent.putExtra("categories", (int) position);
                startActivity(intent);
            }
        });
    }
}
