package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.Categories.BaseballActivity;
import ca.bcit.pubhub.activities.Categories.BasketballActivity;
import ca.bcit.pubhub.activities.Categories.EsportsActivity;
import ca.bcit.pubhub.activities.Categories.SoccerActivity;
import ca.bcit.pubhub.adapters.CategoryAdapter;


public class CategoryFragment extends ListFragment {
    CategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new CategoryAdapter();
        setListAdapter(adapter);

        String[] categoryArr = getResources().getStringArray(R.array.category_type);

        for (
                String s : categoryArr) {
            adapter.addItem(s);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void addItem(String c) {
        adapter.addItem(c);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Intent intent;
        switch (position) {
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
}