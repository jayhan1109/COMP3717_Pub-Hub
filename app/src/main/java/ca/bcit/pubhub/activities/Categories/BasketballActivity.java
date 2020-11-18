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

public class BasketballActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basketball);

        ArrayList<CategoryViewItem> category_view_item_list = new ArrayList<CategoryViewItem>();
        category_view_item_list.add(new CategoryViewItem("NBA"));
        category_view_item_list.add(new CategoryViewItem("LNB Pro A"));
        category_view_item_list.add(new CategoryViewItem("Liga ACB"));

        ListView basketball_listview = findViewById(R.id.basketball_listview);

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), R.layout.category_item_view, category_view_item_list);
        basketball_listview.setAdapter(adapter);

        basketball_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BasketballActivity.this, BasketballListActivity.class);
                intent.putExtra("categories", (int) position);
                startActivity(intent);
            }
        });
    }
}
