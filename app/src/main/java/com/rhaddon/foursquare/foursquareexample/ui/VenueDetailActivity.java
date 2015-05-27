package com.rhaddon.foursquare.foursquareexample.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhaddon.foursquare.foursquareexample.client.*;
import com.rhaddon.foursquare.foursquareexample.R;
import com.rhaddon.foursquare.foursquareexample.model.Venue;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class VenueDetailActivity extends Activity {

    private static final String EXTRA_VENUE_NAME = "com.rhaddon.foursquare.venue.name";
    private static final String EXTRA_VENUE_ID = "com.rhaddon.foursquare.venue.id";

    @InjectView(R.id.detail_image)
    ImageView detailImage;
    @InjectView(R.id.detail_venue_title)
    TextView titleLbl;
    @InjectView(R.id.detail_phrases)
    TextView phraseLbl;
    @InjectView(R.id.detail_open_in_browser)
    Button browserBtn;

    private FourSquareApi foursquareApi;
    private Venue _currentVenue;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_detail);
        ButterKnife.inject(this);
        initRestAdaptor();
        initButtons();
        initImage();
    }

    private void initRestAdaptor() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.foursquare.com/v2/")
                .build();

        foursquareApi = restAdapter.create(FourSquareApi.class);
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
        foursquareApi.getVenue(
                ApiConstants.CLIENT_ID,
                ApiConstants.CLIENT_SECRET,
                ApiConstants.VERSION_DATE,
                getVenueId(),
                makeApiCallbackHandler()
        );
    }

    private Callback<FoursquareResponseWrapper<VenueDetailResponse>> makeApiCallbackHandler() {

        return new Callback<FoursquareResponseWrapper<VenueDetailResponse>>() {
            @DebugLog
            @Override
            public void success(FoursquareResponseWrapper<VenueDetailResponse> responseWrapper, Response response) {
                _currentVenue = responseWrapper.getResponse().getVenue();
                titleLbl.setText(_currentVenue.name);

                FoursquarePhoto photo = _currentVenue.bestPhoto;
                if (null != detailImage) {
                    Picasso.with(VenueDetailActivity.this).load(photo.getUrl()).into(detailImage);
                }
            }

            @DebugLog
            @Override
            public void failure(RetrofitError error) {

            }
        };
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

    private void initImage() {

    }

    private void initButtons() {
        browserBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                  intent.setData(Uri.parse(_currentVenue.url));
                  startActivity(intent);
              }
          }
        );
    }

    @DebugLog
    public static Intent makeIntent(Context context, Venue venue) {
        Intent intent = new Intent(context, VenueDetailActivity.class);
        intent.putExtra(EXTRA_VENUE_NAME, venue.name);
        intent.putExtra(EXTRA_VENUE_ID, venue.id);
        return intent;
    }

    private String getVenueId() {
        if (getIntent().hasExtra(EXTRA_VENUE_ID)) {
            return getIntent().getStringExtra(EXTRA_VENUE_ID);
        } else {
            throw new IllegalArgumentException("Venue ID not provided for VenueDetailActivity");
        }
    }
}
