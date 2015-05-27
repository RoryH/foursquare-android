package com.rhaddon.foursquare.foursquareexample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.rhaddon.foursquare.foursquareexample.R;
import com.rhaddon.foursquare.foursquareexample.model.Venue;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hugo.weaving.DebugLog;


public class VenueListActivity extends Activity {
    @InjectView(R.id.master_list)
    ListView venuesListsView;

    private VenuesAdaptor venuesListAdaptor;


    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_list);
        ButterKnife.inject(this);

        venuesListAdaptor = new VenuesAdaptor(this);
        venuesListsView.setAdapter(venuesListAdaptor);
        venuesListAdaptor.addAll(makeFakeVenues());
    }

    private List<Venue> makeFakeVenues() {
        List<Venue> venues = new ArrayList<>();

        venues.add(new Venue("The Bridge"));
        venues.add(new Venue("Slatterys"));
        venues.add(new Venue("Juniors"));
        venues.add(new Venue("Gilt's office"));
        venues.add(new Venue("Ravis"));
        venues.add(new Venue("Centra"));
        venues.add(new Venue("MAIA"));
        venues.add(new Venue("Embassy Grill"));
        return venues;
    }

    @DebugLog
    @Override
    protected void onStart() {
        super.onStart();
    }

    @DebugLog
    @Override
    protected void onResume() {
        super.onResume();
    }

    @DebugLog
    @Override
    protected void onPause() {
        super.onPause();
    }

    @DebugLog
    @Override
    protected void onStop() {
        super.onStop();
    }

    @DebugLog
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
