package edu.orangecoastcollege.cs273.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set Adapter, which binds eventListView to data in MusicEvent.java
        // Since the data is in an array, we use an ArrayAdapter
        // setListAdapter creates a new Adapter, as specified by param
        // ArrayAdapter<> takes the argument ListView, some layout style (as a layout res), and an array

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        // ListActivity already inflates the layout.
        // Uncommenting setContentView() will actually crash the app.
        // setContentView(R.layout.activity_event_list);


    }


    @Override
    protected void onListItemClick (ListView l, View v, int pos, long id) {
        String title = MusicEvent.titles[pos];
        String detail = MusicEvent.details[pos];
        Intent detailsIntent = new Intent(this, MusicDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Detail", detail);
        startActivity(detailsIntent);
    }
}
