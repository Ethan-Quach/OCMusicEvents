package edu.orangecoastcollege.cs273.ocmusicevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicDetailsActivity extends AppCompatActivity {

    private TextView eventTitleTextView;
    private TextView eventDetailsTextView;
    private ImageView eventImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");


        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        eventImageView = (ImageView) findViewById(R.id.eventImageView);

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);

    }
}
