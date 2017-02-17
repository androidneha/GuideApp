package neha.com.allinonefinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Neha on 12/14/2016.
 */

public class MyAdapter extends BaseAdapter {

    private Activity activity;
    GetterSetter f;
    private LayoutInflater inflater;
    private List<GetterSetter> items;

    public MyAdapter(Activity activity, List<GetterSetter> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.listitemss, null);
        final TextView hospital_addresss=(TextView)convertView.findViewById(R.id.hospital_addresss);
        final TextView map=(TextView)convertView.findViewById(R.id.map);
        final TextView hospital_name=(TextView)convertView.findViewById(R.id.hospital_name);
        final ImageView schdep=(ImageView)convertView.findViewById(R.id.img);

        f = items.get(position);

       hospital_addresss.setText(f.vicinity);
        hospital_name.setText(f.name);
        Picasso.with(activity)
                .load(f.icon)
                .config(Bitmap.Config.RGB_565)
                .error(R.mipmap.ic_launcher)
                .fit()
                .centerInside()
                .into(schdep);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUri = "http://maps.google.com/maps?q=loc:" + f.getLat() + "," + f.getLng() + " (" + f.name + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                activity.startActivity(intent);
            }
        });
        return convertView;
    }
}
