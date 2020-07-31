package com.aditya.whatshappening.front_screen_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aditya.whatshappening.home_tab_fragments.CountryTopNews;
import com.aditya.whatshappening.R;

public class Conatinerfragment extends Fragment  {
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    Fragment fragment;

    public Conatinerfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_conatinerfragment, container, false);

        setFragment("https://newsapi.org/v2/top-headlines?country=in&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.ctopnews);
        setFragment("https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.cbusiness);
        setFragment("https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.centartainment);
        setFragment("https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.ctech);
        setFragment("https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.csports);
        setFragment("https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.cscience);
        setFragment("https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a",R.id.cHealth);
        return v;
    }
    public void setFragment(String link, int id) {
        fragment=new CountryTopNews();
        Bundle b=new Bundle();
        b.putString("link",link);
        fragment.setArguments(b);
        fragmentManager=getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
