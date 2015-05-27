package com.rhaddon.foursquare.foursquareexample.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.rhaddon.foursquare.foursquareexample.R;

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

        venuesListsView.setAdapter(venuesListAdaptor);
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
