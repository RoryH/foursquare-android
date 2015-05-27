package com.rhaddon.foursquare.foursquareexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class VenueDetailActivity extends Activity {

    @InjectView(R.id.detail_image)
    ImageView detailImage;
    @InjectView(R.id.detail_venue_title)
    TextView titleLbl;
    @InjectView(R.id.detail_phrases)
    TextView phraseLbl;
    @InjectView(R.id.detail_open_in_browser)
    Button browserBtn;

    private FourSquareService foursquareApi;

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

        foursquareApi = restAdapter.create(FourSquareService.class);
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
        foursquareApi.getVenue(ApiConstants.CLIENT_ID, ApiConstants.CLIENT_SECRET, ApiConstants.VERSION_DATE, "4c2b5abe355cef3bdd3fcd56", makeApiCallbackHandler());
    }

    private Callback<FoursquareResponseWrapper<Venue>> makeApiCallbackHandler() {

        return new Callback<FoursquareResponseWrapper<Venue>>() {
            @DebugLog
            @Override
            public void success(FoursquareResponseWrapper<Venue> venue, Response response) {
                titleLbl.setText(venue.response.venue.name);
                if (null != detailImage) {
                    Picasso.with(VenueDetailActivity.this).load(venue.response.venue.getBestPhoto()).into(detailImage);
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
                  intent.setData(Uri.parse("http://www.gilt.com"));
                  startActivity(intent);
              }
          }
        );
    }
}
