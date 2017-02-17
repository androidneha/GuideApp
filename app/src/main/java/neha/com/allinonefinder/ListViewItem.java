package neha.com.allinonefinder;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListViewItem extends AppCompatActivity {

    ListView list;
    RequestQueue requestQueue;
    String lat,lng; Toolbar toolbar;
    ArrayList<String> ratin;
    MyAdapter adapter;
    private ArrayList<GetterSetter> list2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SplashScreen.class));
                finish();
            }
        });
       // Toast.makeText(getApplicationContext(),SplashScreen.option+"",Toast.LENGTH_SHORT).show();
        lat=getIntent().getStringExtra("lat");
        lng=getIntent().getStringExtra("lng");
        list=(ListView)findViewById(R.id.list);
        requestQueue = Volley.newRequestQueue(this);
        if(SplashScreen.option.equals("hospital"))
        {
            getSupportActionBar().setTitle("Hospital List");
            new atm("hospital");
        }
        else if(SplashScreen.option.equals("atm"))
        {
            getSupportActionBar().setTitle("ATM List");
            new atm("atm");
        }
        else if(SplashScreen.option.equals("bank"))
        {
            getSupportActionBar().setTitle("Bank List");
            new atm("bank");
        }
        else if(SplashScreen.option.equals("amusement_park"))
        {
            getSupportActionBar().setTitle("Amusement Park List");
            new atm("amusement_park");
        }
        else if(SplashScreen.option.equals("aquarium"))
        {
            getSupportActionBar().setTitle("Aquarium List");
            new atm("aquarium");
        }
        else if(SplashScreen.option.equals("school"))
        {
            getSupportActionBar().setTitle("School List");
            new atm("school");
        }
        else if(SplashScreen.option.equals("car_dealer"))
        {
            getSupportActionBar().setTitle("Car Dealer List");
            new atm("car_dealer");
        }
        else if(SplashScreen.option.equals("car_repair"))
        {
            getSupportActionBar().setTitle("Car Repair List");
            new atm("car_repair");
        }
        else if(SplashScreen.option.equals("car_wash"))
        {
            getSupportActionBar().setTitle("Car Wash List");
            new atm("car_wash");
        }
        else if(SplashScreen.option.equals("cafe"))
        {
            getSupportActionBar().setTitle("Cafe List");
            new atm("cafe");
        }

        else if(SplashScreen.option.equals("bicycle_store"))
        {
            getSupportActionBar().setTitle("Bicycle Store List");
            new atm("bicycle_store");
        }
        else if(SplashScreen.option.equals("book_store"))
        {
            getSupportActionBar().setTitle("Book Store List");
            new atm("book_store");
        }
        else if(SplashScreen.option.equals("bus_station"))
        {
            getSupportActionBar().setTitle("Bus Station List");
            new atm("bus_station");
        }
        else if(SplashScreen.option.equals("beauty_salon"))
        { getSupportActionBar().setTitle("Beauty Salon List");

            new atm("beauty_salon");
        }
        else if(SplashScreen.option.equals("bar"))
        {
            getSupportActionBar().setTitle("Bar List");
            new atm("bar");
        }
        else if(SplashScreen.option.equals("bakery"))
        {
            getSupportActionBar().setTitle("Bakery List");
            new atm("bakery");
        }
        else if(SplashScreen.option.equals("airport"))
        {
            getSupportActionBar().setTitle("Airport");
            new atm("airport");
        }
        else if(SplashScreen.option.equals("art_gallery"))
        {
            getSupportActionBar().setTitle("Art Gallery");
            new atm("art_gallery");
        }
        else if(SplashScreen.option.equals("car_rental"))
        {
            getSupportActionBar().setTitle("Car Rental");
            new atm("car_rental");
        }
        else if(SplashScreen.option.equals("casino"))
        {
            getSupportActionBar().setTitle("Casino");
            new atm("casino");
        }
        else if(SplashScreen.option.equals("church"))
        {
            getSupportActionBar().setTitle("Church");
            new atm("church");
        }
        else if(SplashScreen.option.equals("city_hall"))
        {
            getSupportActionBar().setTitle("City Hall");
            new atm("city_hall");
        }
        else if(SplashScreen.option.equals("convenience_store"))
        {
            getSupportActionBar().setTitle("Convenience Store");
            new atm("convenience_store");
        }
        else if(SplashScreen.option.equals("clothing_store"))
        {
            getSupportActionBar().setTitle("Clothing Store");
            new atm("clothing_store");
        }
        else if(SplashScreen.option.equals("dentist"))
        {
            getSupportActionBar().setTitle("Dentist");
            new atm("dentist");
        }
        else if(SplashScreen.option.equals("doctor"))
        {
            getSupportActionBar().setTitle("Doctor");
            new atm("doctor");
        }
        else if(SplashScreen.option.equals("electrician"))
        {
            getSupportActionBar().setTitle("Electrician");
            new atm("electrician");
        }
        else if(SplashScreen.option.equals("electronics_store"))
        {
            getSupportActionBar().setTitle("Electronics Store");
            new atm("electronics_store");
        }
        else if(SplashScreen.option.equals("fire_station"))
        {
            getSupportActionBar().setTitle("Fire Station");
            new atm("fire_station");
        }
        else if(SplashScreen.option.equals("furniture_store"))
        {
            getSupportActionBar().setTitle("Furniture Store");
            new atm("furniture_store");
        }
        else if(SplashScreen.option.equals("gas_station"))
        {
            getSupportActionBar().setTitle("Gas Station");
            new atm("gas_station");
        }
        else if(SplashScreen.option.equals("gym"))
        {
            getSupportActionBar().setTitle("Gym");
            new atm("gym");
        }
        else if(SplashScreen.option.equals("hardware_store"))
        {
            getSupportActionBar().setTitle("Hardware Store");
            new atm("hardware_store");
        }
        else if(SplashScreen.option.equals("hindu_temple"))
        {
            getSupportActionBar().setTitle("Hindu Temple");
            new atm("hindu_temple");
        }
        else if(SplashScreen.option.equals("home_goods_store"))
        {
            getSupportActionBar().setTitle("Home Goods Store");
            new atm("home_goods_store");
        }
        else if(SplashScreen.option.equals("jewelry_store"))
        {
            getSupportActionBar().setTitle("Jewelry Store");
            new atm("jewelry_store");
        }
        else if(SplashScreen.option.equals("insurance_agency"))
        {
            getSupportActionBar().setTitle("Insurance Agency");
            new atm("insurance_agency");
        }
        else if(SplashScreen.option.equals("lawyer"))
        {
            getSupportActionBar().setTitle("Lawyer");
            new atm("lawyer");
        }
        else if(SplashScreen.option.equals("laundry"))
        {
            getSupportActionBar().setTitle("Laundry");
            new atm("laundry");
        }
        else if(SplashScreen.option.equals("library"))
        {
            getSupportActionBar().setTitle("Library");
            new atm("library");
        }
        else if(SplashScreen.option.equals("local_government_office"))
        {
            getSupportActionBar().setTitle("Local Government Office");
            new atm("local_government_office");
        }

        else if(SplashScreen.option.equals("movie_rental"))
        {
            getSupportActionBar().setTitle("Movie Rental");
            new atm("movie_rental");
        }
        else if(SplashScreen.option.equals("meal_delivery"))
        {
            getSupportActionBar().setTitle("Meal Delivery");
            new atm("meal_delivery");
        }
        else if(SplashScreen.option.equals("mosque"))
        {
            getSupportActionBar().setTitle("Mosque");
            new atm("mosque");
        }
        else if(SplashScreen.option.equals("movie_theater"))
        {
            getSupportActionBar().setTitle("Movie Theater");
            new atm("movie_theater");
        }
        else if(SplashScreen.option.equals("night_club"))
        {
            getSupportActionBar().setTitle("Night Club");
            new atm("night_club");
        }
        else if(SplashScreen.option.equals("museum"))
        {
            getSupportActionBar().setTitle("Museum");
            new atm("museum");
        }
        else if(SplashScreen.option.equals("park"))
        {
            getSupportActionBar().setTitle("Park");
            new atm("park");
        }
        else if(SplashScreen.option.equals("painter"))
        {
            getSupportActionBar().setTitle("Painter");
            new atm("painter");
        }

        else if(SplashScreen.option.equals("parking"))
        {
            getSupportActionBar().setTitle("Parking");
            new atm("parking");
        }
        else if(SplashScreen.option.equals("pet_store"))
        {
            getSupportActionBar().setTitle("Pet Store");
            new atm("pet_store");
        }
        else if(SplashScreen.option.equals("pharmacy"))
        {
            getSupportActionBar().setTitle("Pharmacy");
            new atm("pharmacy");
        }

        else if(SplashScreen.option.equals("physiotherapist"))
        {
            getSupportActionBar().setTitle("Physiotherapist");
            new atm("physiotherapist");
        }
        else if(SplashScreen.option.equals("plumber"))
        {
            getSupportActionBar().setTitle("Plumber");
            new atm("plumber");
        }
        else if(SplashScreen.option.equals("police"))
        {
            getSupportActionBar().setTitle("Police");
            new atm("police");
        }
        else if(SplashScreen.option.equals("post_office"))
        {
            getSupportActionBar().setTitle("Post Office");
            new atm("post_office");
        }
        else if(SplashScreen.option.equals("real_estate_agency"))
        {
            getSupportActionBar().setTitle("Real Estate Agency");
            new atm("real_estate_agency");
        }
        else if(SplashScreen.option.equals("restaurant"))
        {
            getSupportActionBar().setTitle("Restaurant");
            new atm("restaurant");
        }
        else if(SplashScreen.option.equals("roofing_contractor"))
        {
            getSupportActionBar().setTitle("Roofing Contractor");
            new atm("roofing_contractor");
        }
        else if(SplashScreen.option.equals("shoe_store"))
        {
            getSupportActionBar().setTitle("Shoe Store");
            new atm("shoe_store");
        }
        else if(SplashScreen.option.equals("shopping_mall"))
        {
            getSupportActionBar().setTitle("Shopping Mall");
            new atm("shopping_mall");
        }
        else if(SplashScreen.option.equals("spa"))
        {
            getSupportActionBar().setTitle("Spa");
            new atm("spa");
        }
        else if(SplashScreen.option.equals("stadium"))
        {
            getSupportActionBar().setTitle("Stadium");
            new atm("stadium");
        }
        else if(SplashScreen.option.equals("storage"))
        {
            getSupportActionBar().setTitle("Storage");
            new atm("storage");
        }
        else if(SplashScreen.option.equals("store"))
        {
            getSupportActionBar().setTitle("Store");
            new atm("store");
        }
        else if(SplashScreen.option.equals("subway_station"))
        {
            getSupportActionBar().setTitle("Subway Station");
            new atm("subway_station");
        }
        else if(SplashScreen.option.equals("taxi_stand"))
        {
            getSupportActionBar().setTitle("Taxi Stand");
            new atm("taxi_stand");
        }else if(SplashScreen.option.equals("train_station"))
        {
            getSupportActionBar().setTitle("Train Station");
            new atm("train_station");
        }
        else if(SplashScreen.option.equals("transit_station"))
        {
            getSupportActionBar().setTitle("Transit Station");
            new atm("transit_station");
        }
        else if(SplashScreen.option.equals("travel_agency"))
        {
            getSupportActionBar().setTitle("Travel Agency");
            new atm("travel_agency");
        }
        else if(SplashScreen.option.equals("university"))
        {
            getSupportActionBar().setTitle("University");
            new atm("university");
        }
        else if(SplashScreen.option.equals("veterinary_care"))
        {
            getSupportActionBar().setTitle("Veterinary Care");
            new atm("veterinary_care");
        }
        else if(SplashScreen.option.equals("zoo"))
        {
            getSupportActionBar().setTitle("Zoo");
            new atm("zoo");
        }
        adapter = new MyAdapter(this, list2);
        list.setAdapter(adapter);
    }
    class atm
    {
        //String url= "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=28.604101,77.097616&radius=5000&types=hospital&key=AIzaSyBfewRP4b8F6Tonp5vnYxQ8xPOnYI5fEnE&callback=initialize";
        //  String url= "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lng+"&radius=5000&types=atm&key=AIzaSyBfewRP4b8F6Tonp5vnYxQ8xPOnYI5fEnE&callback=initialize";
        atm(final String s)
        {
            String url= "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lng+"&radius=5000&types="+s+"&key=AIzaSyBfewRP4b8F6Tonp5vnYxQ8xPOnYI5fEnE&callback=initialize";
            final ProgressDialog pdialog;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pdialog = new ProgressDialog(ListViewItem.this, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                pdialog = new ProgressDialog(ListViewItem.this);
            }
            pdialog.setTitle("Finding "+s+" Near By You");
            pdialog.setMessage("Loading ....");
            pdialog.setCancelable(false);
            pdialog.show();
            StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Log.e("sdfffffffffff",response.toString());
                            // Log.e("ffffffff",url);
                            try
                            {
                                pdialog.dismiss();
                                JSONObject json = new JSONObject(response);

                                JSONArray results=json.getJSONArray("results");
                                if(results.length()>0)
                                {
                                    for(int i=0;i<results.length();i++)
                                    {
                                        JSONObject a=results.getJSONObject(i);
                                        GetterSetter ls=new GetterSetter();
                                        ls.setIcon(a.getString("icon"));
                                        //ls.setRatingg(BigDecimal.valueOf(a.getDouble("rating")).toPlainString()+"");

                                        // Toast.makeText(getApplicationContext(),BigDecimal.valueOf(a.getDouble("rating")).toPlainString(),Toast.LENGTH_LONG).show();
                                        // ls.setRating(BigDecimal.valueOf(a.getDouble("Amount")).toPlainString());
                                        ls.setGeometry(a.getString("place_id"));
                                        ls.setName(a.getString("name"));
                                        ls.setVicinity(a.getString("vicinity"));

                                        JSONObject j= a.getJSONObject("geometry");
                                        JSONObject jk=j.getJSONObject("location");
                                        //JSONObject jk=new JSONObject(j.toString());
                                        ls.setLat(jk.getString("lat"));
                                        ls.setLng(jk.getString("lng"));
                                        // Log.e("llllllll",jk.getString("lat"));
//                                    ratin.add(BigDecimal.valueOf(a.getDouble("rating")).toPlainString());
                                        list2.add(ls);
                                    }

                                    adapter.notifyDataSetChanged();
                                    //Toast.makeText(getApplicationContext(),list.getCount()+"",Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    final AlertDialog.Builder alertDialog;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        alertDialog = new AlertDialog.Builder(ListViewItem.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                    } else {
                                        alertDialog = new AlertDialog.Builder(ListViewItem.this);
                                    }
                                    alertDialog.setTitle("No "+s+" Found Near By You");
                                    alertDialog.setMessage("Go Back");
                                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivity(new Intent(getApplicationContext(),SplashScreen.class));
                                        }
                                    });
                                    alertDialog.show();
                                }

                            }
                            catch (JSONException e) {
                                pdialog.dismiss();
                                final AlertDialog.Builder alertDialog;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this);
                                }
                                alertDialog.setTitle("Error Occur");
                                alertDialog.setMessage(e.toString());
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(getApplicationContext(),SplashScreen.class));
                                    }
                                });
                                alertDialog.show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            pdialog.dismiss();
                            if (error instanceof TimeoutError) {
                                AlertDialog.Builder alertDialog;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this);
                                }
                                alertDialog.setTitle("Live Status");
                                alertDialog.setMessage("Sorry server response time is out. Please try again later.");
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                alertDialog.show();
                            } else if (error instanceof NetworkError || error instanceof NoConnectionError) {
                                AlertDialog.Builder alertDialog;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this);
                                }
                                alertDialog.setTitle("Live Status");
                                alertDialog.setMessage("Sorry your internet is very slow.");
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                alertDialog.show();
                            } else if (error instanceof ServerError || error instanceof AuthFailureError) {
                                AlertDialog.Builder alertDialog;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(ListViewItem.this);
                                }
                                alertDialog.setTitle("Live Status");
                                alertDialog.setMessage("Sorry server is currently down. Please try again later");
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                alertDialog.show();
                            }
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    //// params.put("driver_email", input_email.getText().toString());
                    // params.put("driver_password", input_password.getText().toString());
                    return params;
                }
            };
            postRequest.setRetryPolicy(new RetryPolicy() {
                @Override
                public int getCurrentTimeout() {
                    return 90000;
                }

                @Override
                public int getCurrentRetryCount() {
                    return 90000;
                }

                @Override
                public void retry(VolleyError error) throws VolleyError {
                }
            });
            requestQueue.add(postRequest);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),SplashScreen.class));
        finish();
    }
}

