package com.aditya.whatshappening.WebViewCode;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aditya.whatshappening.R;

public class Web extends AppCompatActivity  {
    WebView webView;
    Button btn1, btn2;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        btn1 = findViewById(R.id.Button1);
        btn2 = findViewById(R.id.Button2);
        String url = getIntent().getStringExtra("link");
        assert url != null;
        String website = linkMaking(url);


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);//hide status bar
        webView = findViewById(R.id.webView);
        WebSettings webSettings;
        webSettings = webView.getSettings();
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl(website);
        webView.setAnimation(AnimationUtils.loadAnimation(Web.this, R.anim.seven));
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient()
        {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);




            }
        });




        btn1.setOnClickListener(v -> webView.goBack());
        btn2.setOnClickListener(v -> webView.goForward());
    }
    public String linkMaking(String str) {
        String start, ending;
        char check = str.charAt(4);
        if (!('s' == check)) {
            start = "https";
            ending = str.substring(4);
            return start + ending;
        } else {
            return str;
        }

    }


}
