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

public class VenueDetailActivity extends Activity {

    @InjectView(R.id.detail_image)
    ImageView detailImage;
    @InjectView(R.id.detail_venue_title)
    TextView titleLbl;
    @InjectView(R.id.detail_phrases)
    TextView phraseLbl;
    @InjectView(R.id.detail_open_in_browser)
    Button browserBtn;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_detail);
        ButterKnife.inject(this);
        initButtons();
        initImage();
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

    private void initImage() {
        Picasso.with(this).load("http://cdn7.giltcdn.com/images/share/uploads/0000/0005/0151/501516561/300x280.jpg").into(detailImage);
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
