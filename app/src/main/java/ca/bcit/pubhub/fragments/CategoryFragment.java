package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.Categories.BaseballActivity;
import ca.bcit.pubhub.activities.Categories.BasketballActivity;
import ca.bcit.pubhub.activities.Categories.EsportsActivity;
import ca.bcit.pubhub.activities.Categories.SoccerActivity;
import ca.bcit.pubhub.adapters.CategoryAdapter;
import ca.bcit.pubhub.items.CategoryViewItem;

public class CategoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ListView category_listview = view.findViewById(R.id.category_listview);

        ArrayList<CategoryViewItem> category_view_item_list = new ArrayList<CategoryViewItem>();
        category_view_item_list.add(new CategoryViewItem("Soccer"));
        category_view_item_list.add(new CategoryViewItem("Basketball"));
        category_view_item_list.add(new CategoryViewItem("Baseball"));
        category_view_item_list.add(new CategoryViewItem("E-Sports"));

        CategoryAdapter adapter = new CategoryAdapter(view.getContext().getApplicationContext(), R.layout.category_item_view, category_view_item_list);
        category_listview.setAdapter(adapter);

        category_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position) {
                    case 0:
                        intent = new Intent(getActivity(), SoccerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), BasketballActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), BaseballActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), EsportsActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        return view;
    }
}
