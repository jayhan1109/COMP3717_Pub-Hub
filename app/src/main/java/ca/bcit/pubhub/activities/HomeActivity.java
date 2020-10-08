package ca.bcit.pubhub.activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.fragments.CategoryFragment;
import ca.bcit.pubhub.fragments.HistoryFragment;
import ca.bcit.pubhub.fragments.HomeFragment;

public class HomeActivity extends FragmentActivity {

    TabLayout tabs;

    CategoryFragment categoryFr;
    HistoryFragment historyFr;
    HomeFragment homeFr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        checkCurrentUser();

        categoryFr = new CategoryFragment();
        historyFr = new HistoryFragment();
        homeFr = new HomeFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, homeFr).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Home"));
        tabs.addTab(tabs.newTab().setText("Category"));
        tabs.addTab(tabs.newTab().setText("History"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if (position == 0)
                    selected = homeFr;
                else if (position == 1)
                    selected = categoryFr;
                else if (position == 2)
                    selected = historyFr;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    public void checkCurrentUser() {
        // [START check_current_user]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            // No user is signed in
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void logoutClick() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        checkCurrentUser();
                    }
                });
    }

}




