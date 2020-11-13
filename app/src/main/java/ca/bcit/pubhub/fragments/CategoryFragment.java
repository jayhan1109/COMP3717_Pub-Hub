package ca.bcit.pubhub.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


import ca.bcit.pubhub.R;
import ca.bcit.pubhub.activities.Categories.BaseballActivity;
import ca.bcit.pubhub.activities.Categories.BasketballActivity;
import ca.bcit.pubhub.activities.Categories.EsportsActivity;
import ca.bcit.pubhub.activities.Categories.SoccerActivity;
import ca.bcit.pubhub.adapters.CategoryAdapter;


public class CategoryFragment extends Fragment {
    CategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        Button soccer_button = view.findViewById(R.id.soccer_button);
        Button basketball_button = view.findViewById(R.id.basketball_button);
        Button baseball_button = view.findViewById(R.id.baseball_button);
        Button esports_button = view.findViewById(R.id.esports_button);

        soccer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SoccerActivity.class);
                startActivity(intent);
            }
        });
        basketball_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BasketballActivity.class);
                startActivity(intent);
            }
        });
        baseball_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BaseballActivity.class);
                startActivity(intent);
            }
        });
        esports_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EsportsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
