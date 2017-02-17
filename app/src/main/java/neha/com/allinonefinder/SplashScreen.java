package neha.com.allinonefinder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class SplashScreen extends AppCompatActivity {
    GridView grid;EditText edt;

    public static  String option="";
    static String[] web = {
            "airport",
            "amusement_park",
            "aquarium",
            "art_gallery",
            "atm",
            "bakery",
            "bank",
            "bar",
            "beauty_salon",
            "bicycle_store",
            "book_store",
            "bus_station",
            "cafe",
            "campground",
            "car_dealer",
            "car_rental",
            "car_repair",
            "car_wash",
            "casino",
            "cemetery",
            "church",
            "city_hall",
            "clothing_store",
            "convenience_store",
            "courthouse",
            "dentist",
            "doctor",
            "electrician",
            "electronics_store",
            "embassy",
            "fire_station",
            "florist",
            "funeral_home",
            "furniture_store",
            "gas_station",
            "gym",
            "hair_care",
            "hardware_store",
            "hindu_temple",
            "home_goods_store",
            "hospital",
            "insurance_agency",
            "jewelry_store",
            "laundry",
            "lawyer",
            "library",
            "liquor_store",
            "local_government_office",
            "meal_delivery",
            "meal_takeaway",
            "mosque",
            "movie_rental",
            "movie_theater",
            "moving_company",
            "museum",
            "night_club",
            "painter",
            "park",
            "parking",
            "pet_store",
            "pharmacy",
            "physiotherapist",
            "plumber",
            "police",
            "post_office",
            "real_estate_agency",
            "restaurant",
            "roofing_contractor",
            "school",
            "shoe_store",
            "shopping_mall",
            "spa",
            "stadium",
            "storage",
            "store",
            "subway_station",
            "taxi_stand",
            "train_station",
            "transit_station",
            "travel_agency",
            "university",
            "veterinary_care",
            "zoo"

    } ;
   int[] imageId = {
           R.color.colorPrimaryDark,
           R.color.colorPrimary,
           R.color.colorAccent,
           R.color.colorAccent1,
           R.color.colorAccent2,
           R.color.colorAccent3,
           R.color.colorAccent4,
           R.color.colorAccent6,
           R.color.colorAccent5,
           R.color.colorAccent7,
           R.color.colorAccent8,
           R.color.colorAccent9,
           R.color.colorAccent10,
           R.color.colorAccent11,
           R.color.colorAccent12,
           R.color.colorAccent13,
           R.color.colorAccent14,
           R.color.colorAccent15,
           R.color.colorAccent16,
           R.color.colorAccent17,
           R.color.colorAccent18,
           R.color.colorAccent19,
           R.color.colorAccent20,
           R.color.colorAccent22,
           R.color.colorAccent21,
           R.color.colorAccent23,
           R.color.colorAccent8,
           R.color.colorAccent9,
           R.color.colorAccent10,
           R.color.colorAccent11,
           R.color.colorAccent12,
           R.color.colorAccent13,
           R.color.colorAccent14,
           R.color.colorAccent15,
           R.color.colorAccent16,
           R.color.colorAccent17,
           R.color.colorAccent18,
           R.color.colorAccent19,
           R.color.colorAccent20,
           R.color.colorAccent22,
           R.color.colorAccent21,
           R.color.colorAccent23,
           R.color.colorAccent24,
           R.color.colorAccent25,
           R.color.colorAccent24,
           R.color.colorAccent25,
           R.color.colorAccent8,
           R.color.colorAccent9,
           R.color.colorAccent10,
           R.color.colorAccent11,
           R.color.colorAccent12,
           R.color.colorAccent13,
           R.color.colorAccent14,
           R.color.colorAccent15,
           R.color.colorAccent16,
           R.color.colorAccent17,
           R.color.colorAccent18,
           R.color.colorAccent19,
           R.color.colorAccent20,
           R.color.colorAccent22,
           R.color.colorAccent21,
           R.color.colorAccent23,
           R.color.colorAccent24,
           R.color.colorAccent25,
           R.color.colorAccent25,
           R.color.colorAccent8,
           R.color.colorAccent9,
           R.color.colorAccent10,
           R.color.colorAccent11,
           R.color.colorAccent12,
           R.color.colorAccent13,
           R.color.colorAccent14,
           R.color.colorAccent15,
           R.color.colorAccent16,
           R.color.colorAccent17,
           R.color.colorAccent18,
           R.color.colorAccent19,
           R.color.colorAccent20,
           R.color.colorAccent22,
           R.color.colorAccent21,
           R.color.colorAccent23,
           R.color.colorAccent24,
           R.color.colorAccent25,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        grid = (GridView) findViewById(R.id.gridlist);
        edt=(EditText)findViewById(R.id.edt);

        String[] stringArray ;
        stringArray = new String[web.length];
        for(int i=0;i<web.length;i++)
        {
            stringArray[i]=web[i].replaceAll("_","  ").toUpperCase();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.listitems, stringArray);

        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               option=web[position];
                Log.e("dffdfdg",web[position]);
                startActivity(new Intent(getApplicationContext(),Address.class));
                finish();

            }
        });
            edt.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
              /*  if (edt.getText().toString().trim().length() > 0) {
                    applySearch(edt.getText().toString().trim());
                } else {
                    adapter1 = new CustomGridViewAdapter(SplashScreen.this, web, imageId);
                    adapter1.notifyDataSetChanged();
                }*/
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {
                // TODO Auto-generated method stub
                applySearch(arg0.toString().trim());
            }
        });

    }
    private void applySearch(String searchStr) {
        ArrayList<String> option2 = new ArrayList<String>();
        ArrayList<Integer> bg1 = new ArrayList<Integer>();
        for (int i = 0; i < web.length; i++) {
            if (web[i].toLowerCase().contains(searchStr.toLowerCase())) {
                option2.add(web[i]);
                bg1.add(imageId[i]);
            }
        }
            final String[] stringArray,stringArray3 ;
            stringArray = new String[option2.size()];
            stringArray3 = new String[option2.size()];
                   for(int i=0;i<option2.size();i++)
                   {
                       stringArray3[i]=option2.get(i);
                       stringArray[i]=option2.get(i).replaceAll("_"," ").toUpperCase();
                   }
        int[] stringArray2;
        stringArray2 = new int[bg1.size()];
        for(int i=0;i<bg1.size();i++)
        {
            stringArray2[i]=bg1.get(i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
               R.layout.listitems, stringArray);

        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                option=stringArray3[position];
                Log.e("dffdfdg",stringArray3[position]);
                startActivity(new Intent(getApplicationContext(),Address.class));
                finish();

            }
        });
    }
}