package neha.com.allinonefinder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.seatgeek.placesautocomplete.DetailsCallback;
import com.seatgeek.placesautocomplete.OnPlaceSelectedListener;
import com.seatgeek.placesautocomplete.PlacesAutocompleteTextView;
import com.seatgeek.placesautocomplete.model.Place;
import com.seatgeek.placesautocomplete.model.PlaceDetails;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Address extends AppCompatActivity {
    TextView text; RequestQueue requestQueue; String replaceText;
    PlacesAutocompleteTextView placesAutocomplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        requestQueue = Volley.newRequestQueue(this);
        text=(TextView)findViewById(R.id.text);
       // Toast.makeText(getApplicationContext(),SplashScreen.option+"",Toast.LENGTH_SHORT).show();
        placesAutocomplete=(PlacesAutocompleteTextView)findViewById(R.id.places_autocomplete);
        placesAutocomplete.setOnPlaceSelectedListener(
                new OnPlaceSelectedListener() {
                    @Override
                    public void onPlaceSelected(final Place place) {
                      //  Toast.makeText(getApplicationContext(),placesAutocomplete.getText().toString()+"",Toast.LENGTH_LONG).show();
                        placesAutocomplete.getDetailsFor(place, new DetailsCallback() {
                            @Override
                            public void onSuccess(final PlaceDetails details) {
                                InputMethodManager inputMethodManager =
                                        (InputMethodManager) getSystemService(
                                                Activity.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(
                                        getCurrentFocus().getWindowToken(), 0);
                                text.setText("Your address is "+placesAutocomplete.getText().toString());
                                Log.e("address",text.getText().toString());
                                replaceText = placesAutocomplete.getText().toString().replaceAll("\\s", "%20");

                            }
                            @Override
                            public void onFailure(final Throwable failure) {
                                Log.d("test", "failure " + failure);
                            }
                        });

                    }
                }
        );
    }

    public void search(View v)
    {
        if(placesAutocomplete.getText().toString().length()==0)
        {
            placesAutocomplete.setError("Please enter address");
        }
        else
        {
            new LatLng();

        }

    }
    //http://maps.googleapis.com/maps/api/geocode/json?address=sagarpur&sensor=false

    class LatLng
    {

        String url= "http://maps.googleapis.com/maps/api/geocode/json?address="+replaceText+"&sensor=false";
        LatLng()
        {
            final ProgressDialog pdialog;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pdialog = new ProgressDialog(Address.this, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                pdialog = new ProgressDialog(Address.this);
            }
            pdialog.setTitle("Finding Address Near By You");
            pdialog.setMessage("Loading ....");
            pdialog.setCancelable(false);
            pdialog.show();
            StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("sdfffffffffff",response.toString());
                            try
                            {
                                pdialog.dismiss();
                                JSONObject json = new JSONObject(response);
                                JSONArray results=json.getJSONArray("results");

                                JSONObject a=results.getJSONObject(0);
                                if(a.toString().length()>0)
                                {
                                    JSONObject ab=a.getJSONObject("geometry");
                                    JSONObject ac=ab.getJSONObject("location");
                                    //JSONObject northeast=ac.getJSONObject("northeast");
                                    Double lat=ac.getDouble("lat");
                                    Double lng=ac.getDouble("lng");
                                    Log.e("sdaff",lat+"/"+lng);
                                    Intent it=new Intent(getApplicationContext(),ListViewItem.class);
                                    it.putExtra("lat",lat+"");
                                    it.putExtra("lng",lng+"");
                                    startActivity(it);
                                    finish();
                                }
                                else
                                {
                                    final AlertDialog.Builder alertDialog;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        alertDialog = new AlertDialog.Builder(Address.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                    } else {
                                        alertDialog = new AlertDialog.Builder(Address.this);
                                    }
                                    alertDialog.setTitle("Wrong Address Detected.");
                                    alertDialog.setMessage("Sorry We have facing some problem");
                                    alertDialog.setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivity(new Intent(getApplicationContext(),Address.class));
                                        }
                                    });
                                    alertDialog.show();
                                }



                            }
                            catch (JSONException e) {
                                pdialog.dismiss();
                                final AlertDialog.Builder alertDialog;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    alertDialog = new AlertDialog.Builder(Address.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(Address.this);
                                }
                                alertDialog.setTitle("Fetching Address");
                                alertDialog.setMessage(e.toString());
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(getApplicationContext(),Address.class));
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
                                    alertDialog = new AlertDialog.Builder(Address.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(Address.this);
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
                                    alertDialog = new AlertDialog.Builder(Address.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(Address.this);
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
                                    alertDialog = new AlertDialog.Builder(Address.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                                } else {
                                    alertDialog = new AlertDialog.Builder(Address.this);
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