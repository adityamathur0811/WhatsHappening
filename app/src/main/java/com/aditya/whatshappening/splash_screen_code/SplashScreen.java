package com.aditya.whatshappening.splash_screen_code;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aditya.whatshappening.main_activity_code.MainActivity;
import com.aditya.whatshappening.R;

public class SplashScreen extends AppCompatActivity {
    Animation animation, animation2;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        t1 = findViewById(R.id.first);
        t2 = findViewById(R.id.second);
        animation = AnimationUtils.loadAnimation(this, R.anim.first);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.sixth);
        t1.setAnimation(animation2);
        t2.setAnimation(animation);
        Window w = this.getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.mattyBlack));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            w.setNavigationBarColor(getResources().getColor(R.color.mattyBlack));
        }
        new Handler().postDelayed(() -> {
            //define your task
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }, 4000);
    }
}
