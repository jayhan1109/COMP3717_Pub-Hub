package ca.bcit.pubhub.activities.Categories;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.adapters.MatchViewAdapter;
import ca.bcit.pubhub.utils.Match;
import ca.bcit.pubhub.utils.MatchModel;

public class CategoryDetailActivity extends AppCompatActivity {
    private int index, categories;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category_detail);
        index = (Integer) getIntent().getExtras().get("categories");
        categories = (Integer) getIntent().getExtras().get("index");

    }
}
