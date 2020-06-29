package com.aditya.whatshappening.front_screen_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aditya.whatshappening.home_tab_fragments.CountryBussiness;
import com.aditya.whatshappening.home_tab_fragments.CountryEntartainment;
import com.aditya.whatshappening.home_tab_fragments.CountryHealth;
import com.aditya.whatshappening.home_tab_fragments.CountryScience;
import com.aditya.whatshappening.home_tab_fragments.CountrySports;
import com.aditya.whatshappening.home_tab_fragments.CountryTopNews;
import com.aditya.whatshappening.home_tab_fragments.Countrytech;
import com.aditya.whatshappening.R;

public class Conatinerfragment extends Fragment  {
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;


    public Conatinerfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_conatinerfragment, container, false);
        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ctopnews, new CountryTopNews());
        fragmentTransaction.replace(R.id.cbusiness, new CountryBussiness());
        fragmentTransaction.replace(R.id.cbusiness, new CountryBussiness());
        fragmentTransaction.replace(R.id.centartainment, new CountryEntartainment());
        fragmentTransaction.replace(R.id.ctech, new Countrytech());
        fragmentTransaction.replace(R.id.csports, new CountrySports());
        fragmentTransaction.replace(R.id.cscience, new CountryScience());
        fragmentTransaction.replace(R.id.cHealth, new CountryHealth());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        return v;
    }
}
