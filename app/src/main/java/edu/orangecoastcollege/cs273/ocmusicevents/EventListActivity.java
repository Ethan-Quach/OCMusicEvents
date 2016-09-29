package edu.orangecoastcollege.cs273.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class EventListActivity extends ListActivity {

    private ListView eventsListView;
    ArrayList<MusicEvent> allMusicEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Try to load MusicEvents.json using provided JSONLoader class
        try {
            allMusicEvents = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading JSON data." + e);
        }

        eventsListView = getListView();

        // The ArrayAdapter commented out below is not sufficient for the layout for IC08. It is purely for text.
        // The new layout we have incorporates two Strings and an image, so this won't do.
        //setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        setListAdapter(new MusicEventAdapter(this, R.layout.music_event_list_item, allMusicEvents));

        // ListActivity already inflates the layout.
        // Uncommenting setContentView() will actually crash the app.
        // setContentView(R.layout.activity_event_list);
    }


    @Override
    protected void onListItemClick (ListView l, View v, int pos, long id) {
        Intent detailsIntent = new Intent(this, MusicDetailsActivity.class);

        MusicEvent clickedEvent = allMusicEvents.get(pos);

        // I apologize to veteran coders for the following two ugly blocks here.
        // We have not been taught Parcelables yet.

        String title = clickedEvent.getTitle();
        String date = clickedEvent.getDate();
        String day = clickedEvent.getDay();
        String time = clickedEvent.getTime();
        String location = clickedEvent.getLocation();
        String address1 = clickedEvent.getAddress1();
        String address2 = clickedEvent.getAddress2();

        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Date", date);
        detailsIntent.putExtra("Day", day);
        detailsIntent.putExtra("Time", time);
        detailsIntent.putExtra("Location", location);
        detailsIntent.putExtra("Address1", address1);
        detailsIntent.putExtra("Address2", address2);

        startActivity(detailsIntent);
    }
}
