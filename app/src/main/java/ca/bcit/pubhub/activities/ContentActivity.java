package ca.bcit.pubhub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ca.bcit.pubhub.R;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }
}