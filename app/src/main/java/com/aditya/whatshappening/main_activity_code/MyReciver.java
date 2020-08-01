package com.aditya.whatshappening.main_activity_code;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

 class MyRecivere extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null) {
            Toast.makeText(context, "PLEASE ENABLE INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
}
    }



}
