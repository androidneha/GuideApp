package neha.com.allinonefinder;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

public class FirstScreen extends AppCompatActivity {
    int onResumeMethodStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            ActionBar actionBar = getActionBar();

        }
        //sharedPreferences = getSharedPreferences("LutooTruxUser", Context.MODE_PRIVATE);
       // editor = sharedPreferences.edit();
        initialize();
    }
    protected void onResume() {
        super.onResume();
        onResumeMethodStatus++;
        if (onResumeMethodStatus != 1) {
            initialize();
        }
    }

    public void initialize() {
        if (MyNetwork.isAvailable(FirstScreen.this)) {
            if (MyNetwork.isGpS(FirstScreen.this)) {
                Handler handler = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), SplashScreen.class));
                        finish();
                    }
                };

                handler.postDelayed(r, 3000);
            } else {
                MyNetwork.showDialog2(FirstScreen.this);
            }
        } else {
            MyNetwork.showDialog(FirstScreen.this);
        }


    }
}
