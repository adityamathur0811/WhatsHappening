package com.aditya.whatshappening;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class MyCity extends Fragment implements MyRetrofit {

    RecyclerView recyclerView;
    String getCity, link;
    TextView textView;

    public MyCity() {


    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_city, container, false);
        textView = v.findViewById(R.id.cityName);
        recyclerView = v.findViewById(R.id.recyclerFromMyCity);
        assert getArguments() != null;
        getCity = (String) getArguments().get("city");

        if (getCity != null) {

            String startLink, endLink;
            startLink = "https://newsapi.org/v2/everything?q=";
            endLink = "&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
            link = startLink + getCity + endLink;
            textView.setText(getCity);
        } else {
            link = "https://newsapi.org/v2/everything?q=New%20Delhi&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
            textView.setText("New Delhi");
            Toast.makeText(getActivity(), "unable to get your current city showing result related to New Delhi", Toast.LENGTH_LONG).show();
        }

        retrofitSetupVertical(recyclerView, link, requireActivity());
        return v;
    }


}
