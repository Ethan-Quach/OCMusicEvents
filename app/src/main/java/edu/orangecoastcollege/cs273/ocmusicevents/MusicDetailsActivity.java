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

        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        eventImageView = (ImageView) findViewById(R.id.eventImageView);

        Log.i("OC Music Events", "Before receiving intent");

        Intent detailsIntent = getIntent();

        Log.i("OC Music Events", "After receiving intent, but before assigning String Extras");

        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");

        Log.i("OC Music Events", "After assigning String Extras, but before creating imageFileName");

        String imageFileName = title.replace(" ", "") + ".jpeg";

        Log.i("OC Music Events", "Before creating AssetManager am");

        AssetManager am = context.getAssets();
        // Try to load the image file
        try
        {
            InputStream stream = am.open(imageFileName);
            Log.i("OC Music Events", "Before attempting to create Drawable image");
            Drawable image = Drawable.createFromStream(stream, title);
            Log.i("OC Music Events", "Before attempting to setImageDrawable for eventImageView");
            eventImageView.setImageDrawable(image);
        } catch (IOException e)
        {
            Log.e("OC Music Events", "Cannot load image: " + imageFileName + e);
        }

        Log.i("OC Music Events", "Before setting the text for the TextViews");

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);

    }
}
