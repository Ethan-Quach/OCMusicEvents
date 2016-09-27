package edu.orangecoastcollege.cs273.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MusicDetailsActivity extends AppCompatActivity {

    private TextView eventTitleTextView;
    private TextView eventDetailsTextView;
    private ImageView eventImageView;

    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");
        String imageFileName = title.replace(" ", "") + ".jpeg";

        AssetManager am = context.getAssets();
        // Try to load the image file
        try
        {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromPath(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e)
        {
            Log.e("OC Music Events", "Cannot load image: " + imageFileName + e);
        }

        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        eventImageView = (ImageView) findViewById(R.id.eventImageView);

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);

    }
}
