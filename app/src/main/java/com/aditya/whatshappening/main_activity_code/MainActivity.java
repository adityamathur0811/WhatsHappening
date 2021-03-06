package com.aditya.whatshappening.main_activity_code;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.front_screen_fragment.Conatinerfragment;
import com.aditya.whatshappening.front_screen_fragment.MyCity;
import com.aditya.whatshappening.nav_drawer_fragments.frag;
import com.aditya.whatshappening.search_bar_code.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Locale;

import static com.aditya.whatshappening.notification.App.Channel_Td;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    DrawerLayout drawer;
    ImageButton imageButton,imageButton1;
    String search;
    String country;
    String city;
    LocationManager locationManager;
    Bundle bundle1;
    AlertDialog.Builder ad;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        IntentFilter intentFilter=new IntentFilter();
MyRecivere myRecivere=new MyRecivere();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(myRecivere,intentFilter);

        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null)
        {

            WifiManager wifiManager= (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            ad=new AlertDialog.Builder(this);
            ad.setCancelable(false);
            ad.setTitle("hey..");
            ad.setMessage("This Application Need Active Internet Connection");
            ad.setPositiveButton("turn on", (dialog, which) -> {
                Dialog dialog1=new Dialog(MainActivity.this);
                dialog1.setCanceledOnTouchOutside(false);
                dialog1.setContentView(R.layout.network);
                imageButton=dialog1.findViewById(R.id.wifi);
                imageButton1=dialog1.findViewById(R.id.data);
                imageButton.setOnClickListener(v -> {
                    assert wifiManager != null;
                    wifiManager.setWifiEnabled(true);
                    dialog1.dismiss();
                    new Handler().postDelayed(() -> {
                        //define your task
                       recreate();
                        Toast.makeText(MainActivity.this, "getting things ready for you...", Toast.LENGTH_LONG).show();


                    }, 7000);
                });
                imageButton1.setOnClickListener(v -> {
                    Intent intent=new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setAction(Settings.ACTION_DATA_ROAMING_SETTINGS);
                    startActivity(intent);
                    dialog1.dismiss();
                    new Handler().postDelayed(() -> {
                        //define your task
                        recreate();
                        Toast.makeText(MainActivity.this, "getting things ready for you...", Toast.LENGTH_LONG).show();
                    }, 7000);
                });
                dialog1.show();

            });
            ad.setNegativeButton("No", (dialog, which) -> finish());
            ad.show();
        }

        Window w = this.getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.gray));

        setSupportActionBar(toolbar);

        Fragment fragCountry = new Conatinerfragment();
        bundle1 = new Bundle();
        bundle1.putString("countryName", country);
        fragCountry.setArguments(bundle1);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.setFragment, new Conatinerfragment());
        fragmentTransaction.commit();




        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.centartainment);




        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.Trending:
                    setFragment("https://newsapi.org/v2/everything?q=trending&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                    break;
                case R.id.Home:
                    fragment = new Conatinerfragment();
                    setFragment2(fragment);
                    break;
                case R.id.MyCity:
                    fragment = new MyCity();
                    setFragment2(fragment);
                    Bundle b = new Bundle();
                    b.putString("city", city);
                    fragment.setArguments(b);

            }
            return true;
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            return;
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();
                double lon = location.getLongitude();

                Geocoder geocoder = new Geocoder(MainActivity.this);
                try {
                    List<Address> list = geocoder.getFromLocation(lat, lon, 1);
                    country = list.get(0).getCountryName();
                    city = list.get(0).getLocality();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Toast.makeText(MainActivity.this, "status changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderEnabled(String provider) {
                Toast.makeText(MainActivity.this, "GPS Enabled", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onProviderDisabled(String provider) {
                ad= new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("Hey..");
                ad.setMessage("Please Turn on GPS to get Latest News From Your City");
                ad.setCancelable(false);
                ad.setPositiveButton("Okay,Turn On Now", (dialog, which) -> {
                  Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                  startActivity(intent);

                });
                ad.setNegativeButton("No", (dialog, which) -> {
                    Uri sound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Toast.makeText(MainActivity.this, "You Can Change it Later from Notification ", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,1,intent,0);
                    Notification builder=new NotificationCompat.Builder(MainActivity.this,Channel_Td)

                            .setSmallIcon(R.drawable.notification_icon)
                            .setContentTitle("GPS")
                            .setContentText("please enable GPS to get news from your current city")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_EVENT)
                            .setContentIntent(pendingIntent)
                            .setSound(sound)
                            .setAutoCancel(true)
                            .build();
                    NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(MainActivity.this);

                    notificationManagerCompat.notify(1,builder);



                });
                ad.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.seachmenu, menu);
        MenuItem searchBar = menu.findItem(R.id.app_bar_search);
        MenuItem mic = menu.findItem(R.id.mic);
        mic.setOnMenuItemClickListener(item -> {
            Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            i.putExtra(RecognizerIntent.EXTRA_PROMPT,"what you want to search");
            startActivityForResult(i,100);
            return true;
        });
        final SearchView searchView = (SearchView) searchBar.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search = query;
                Bundle bundle = new Bundle();
                if(!query.isEmpty())
                {
                    bundle.putString("Search", search);
                    Search searchObj = new Search();
                    searchObj.setArguments(bundle);
                    setFragment2(searchObj);
                }


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.covid:
                setFragment("https://newsapi.org/v2/everything?q=covid&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.cricket:
                setFragment("https://newsapi.org/v2/everything?q=cricket&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
                break;
            case R.id.Football:
                setFragment("https://newsapi.org/v2/everything?q=football&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
            case R.id.business:
                setFragment("https://newsapi.org/v2/everything?q=business&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
            case R.id.TechNews:
                setFragment("https://newsapi.org/v2/everything?q=tech&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
                break;
            case R.id.financeMenu:
                setFragment("https://newsapi.org/v2/everything?q=finance&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.fashion:
                setFragment("https://newsapi.org/v2/everything?q=fashhion&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
                break;
            case R.id.mobile:
                setFragment("https://newsapi.org/v2/everything?q=moblie&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
                break;
            case R.id.gadget:
                setFragment("https://newsapi.org/v2/everything?q=gadget&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.factMenu:
                setFragment("https://newsapi.org/v2/everything?q=factcheck&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.sharemarketMenu:
                setFragment("https://newsapi.org/v2/everything?q=sharemarket&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.economyMenu:
                setFragment("https://newsapi.org/v2/everything?q=economy&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();
                break;
            case R.id.allMenu:
                setFragment("https://newsapi.org/v2/everything?q=sports&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.golfMenu:
                setFragment("https://newsapi.org/v2/everything?q=golf&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.basketballmenu:
                setFragment("https://newsapi.org/v2/everything?q=basketball&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.tenisMenu:
                setFragment("https://newsapi.org/v2/everything?q=tennis&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();


                break;
            case R.id.badmintonMenu:

                setFragment("https://newsapi.org/v2/everything?q=badminton&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;
            case R.id.entartainmentMenu:
                setFragment("https://newsapi.org/v2/everything?q=entertainment&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();


                break;
            case R.id.health:
                setFragment("https://newsapi.org/v2/everything?q=health&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a");
                drawer.closeDrawers();

                break;


        }


        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            assert data != null;
            List<String> list = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            assert list != null;
            String value = list.get(0);
            if (!value.isEmpty())
            {
                search = value;
                Bundle bundle=new Bundle();
                bundle.putString("Search", search);

                Search searchObj = new Search();
                searchObj.setArguments(bundle);
                setFragment2(searchObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public void setFragment(String link) {
        fragment=new frag();
        Bundle b=new Bundle();
        b.putString("link",link);
        fragment.setArguments(b);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.setFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void setFragment2(Fragment fragment) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.setFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            ad= new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("Hello");
            ad.setMessage("Do You Want To Exit");
            ad.setPositiveButton("yes", (dialog, which) -> finish());
            ad.setNegativeButton("No", (dialog, which) -> {


            });
            ad.show();
        }

    }
}
