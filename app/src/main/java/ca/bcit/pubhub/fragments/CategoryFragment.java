package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.Categories.BaseballActivity;
import ca.bcit.pubhub.activities.Categories.BasketballActivity;
import ca.bcit.pubhub.activities.Categories.EsportsActivity;
import ca.bcit.pubhub.activities.Categories.SoccerActivity;

public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ListView category_listview = view.findViewById(R.id.category_listview);

        category_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
        });
        return view;
    }
}