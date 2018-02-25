package com.example.android.SANNYPUTRAHENDARSYAH_1202154121_MODUL3;

// Method default pada android yang kita gunakan sesuai dengan kebutuhan
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    // Method ketika dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // method untuk mengarahkan ke aktivitas selanjutnya
                Intent i = new Intent(Splash.this, Login.class);
                startActivity(i);

                // menutup atau mengakhiri splash screen
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}