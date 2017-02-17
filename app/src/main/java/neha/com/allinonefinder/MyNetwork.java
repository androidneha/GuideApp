package neha.com.allinonefinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;


public class MyNetwork
{
    public static boolean isAvailable(Activity activity)
    {
            ConnectivityManager cm=(ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=cm.getActiveNetworkInfo();
            if(networkInfo!=null && networkInfo.isConnected())
            {
                return true;
            }
            return false;
    }
    public static boolean isGpS(Activity activity)
    {
        final LocationManager manager = (LocationManager)activity.getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            return false;
        }
        return true;
    }
    public static void showDialog2(final Activity activity)
    {

        new MaterialStyledDialog(activity).setHeaderColor(R.color.colorPrimaryDark)
                .setTitle("Your GPS seems to be disabled, do you want to enable it?")
                .setDescription("Go to Settings ")
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher)
                .setPositive("OK", new MaterialDialog.SingleButtonCallback()
                {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which)
                    {
                        activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
                    }
                }).setNegative("Cancel", new MaterialDialog.SingleButtonCallback()
        {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which)
            {
                new MaterialStyledDialog(activity).setHeaderColor(R.color.colorPrimaryDark)
                        .setTitle("Sorry We cant Process Further!!!")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositive("OK", new MaterialDialog.SingleButtonCallback()
                        {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which)
                            {
                                activity.finish();
                            }
                        }).show();
            }
        }).show();
    }
    public static void showDialog(final Activity activity)
    {
        new MaterialStyledDialog(activity)
                .setHeaderColor(R.color.colorPrimaryDark)
                .setTitle("Oops!!! No Internet Connection Found!")
                .setDescription("Go to Settings ")
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher)
                .setPositive("OK", new MaterialDialog.SingleButtonCallback()
                {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which)
                    {
                        activity.startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                    }
                }).setNegative("Cancel", new MaterialDialog.SingleButtonCallback()
        {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which)
            {
                new MaterialStyledDialog(activity).setHeaderColor(R.color.colorPrimaryDark)
                        .setTitle("Sorry We cant Process Further!!!")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositive("OK", new MaterialDialog.SingleButtonCallback()
                        {
                            @Override
                            public void onClick(MaterialDialog dialog, DialogAction which)
                            {
                                activity.finish();
                            }
                        }).show();
            }
        }).show();
    }
}
