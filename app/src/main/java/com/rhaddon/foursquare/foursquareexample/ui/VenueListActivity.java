package com.rhaddon.foursquare.foursquareexample.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.rhaddon.foursquare.foursquareexample.R;
import com.rhaddon.foursquare.foursquareexample.client.ApiConstants;
import com.rhaddon.foursquare.foursquareexample.client.FourSquareApi;
import com.rhaddon.foursquare.foursquareexample.client.FoursquareResponseWrapper;
import com.rhaddon.foursquare.foursquareexample.client.Item;
import com.rhaddon.foursquare.foursquareexample.client.VenueListResponse;
import com.rhaddon.foursquare.foursquareexample.model.Venue;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class VenueListActivity extends Activity implements ListView.OnItemClickListener {
    @InjectView(R.id.master_list)
    ListView venuesListView;

    @InjectView(R.id.master_near)
    EditText nearEditText;

    @InjectView(R.id.master_query)
    EditText queryEditText;

    @InjectView(R.id.master_search_btn)
    Button querySearchBtn;

    private VenuesAdaptor venuesListAdapter;
    private FourSquareApi foursquareApi;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_list);
        ButterKnife.inject(this);
        
        initList();
        initSearchButton();
        initRestAdapter();
    }

    private void initSearchButton() {
        querySearchBtn.setOnClickListener(new View.OnClickListener() {
            @DebugLog
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });
    }

    private void initList() {
        venuesListAdapter = new VenuesAdaptor(this);
        venuesListView.setAdapter(venuesListAdapter);
        venuesListView.setOnItemClickListener(this);
    }

    private void initRestAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.foursquare.com/v2/")
                .build();

        foursquareApi = restAdapter.create(FourSquareApi.class);
    }

    private void fetchData() {
        foursquareApi.getVenuesList(ApiConstants.CLIENT_ID,
                ApiConstants.CLIENT_SECRET,
                ApiConstants.VERSION_DATE,
                getUiNearString(),
                getUiQueryString(),
                makeCallbackHandler());

    }

    private static List<Venue> getVenuesFromItems(List<Item> items) {
        List<Venue> venues = new ArrayList<>();
        for (Item item : items) {
            venues.add(item.getVenue());
        }
        return venues;
    }

    @DebugLog
    private Callback<FoursquareResponseWrapper<VenueListResponse>> makeCallbackHandler() {
        return new Callback<FoursquareResponseWrapper<VenueListResponse>>() {
            @DebugLog
            @Override
            public void success(FoursquareResponseWrapper<VenueListResponse> venueListResponse, Response response) {
                venuesListAdapter.clear();
                List<Venue> venues = getVenuesFromItems(venueListResponse.getResponse().getGroups().get(0).getItems());
                venuesListAdapter.addAll(venues);
            }

            @DebugLog
            @Override
            public void failure(RetrofitError error) {

            }
        };
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Venue venue = venuesListAdapter.getItem(position);
        Intent intent = VenueDetailActivity.makeIntent(this, venue);
        startActivity(intent);
    }

    public String getUiNearString() {
        return nearEditText.getText().toString();
    }

    public String getUiQueryString() {
        return queryEditText.getText().toString();
    }
}
