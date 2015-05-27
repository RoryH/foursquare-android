package com.rhaddon.foursquare.foursquareexample.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rhaddon.foursquare.foursquareexample.R;
import com.rhaddon.foursquare.foursquareexample.model.Venue;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class VenuesAdaptor extends BaseArrayListAdapter<Venue, VenuesAdaptor.ViewHolder> {
    public VenuesAdaptor(Context context) {
        super(context, R.layout.row_venue, new ArrayList<Venue>());
    }

    @Override
    protected ViewHolder getViewHolder(View v, int position, Context c) {
        return new ViewHolder(v);
    }

    @Override
    protected void bindView(View v, int position, Context context) {
        Venue venue = getItem(position);
        ViewHolder vh = (ViewHolder) v.getTag();
        vh.nameLbl.setText(venue.name);
    }

    public static class ViewHolder {
        @InjectView(R.id.row_venue_name)
        TextView nameLbl;

        public ViewHolder(View v) {
            ButterKnife.inject(this, v);
        }
    }
}
