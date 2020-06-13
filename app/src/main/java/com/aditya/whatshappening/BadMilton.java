package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


public class BadMilton extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;

    public BadMilton() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_bad_minton, container, false);
        recyclerView=v.findViewById(R.id.Badminton);
        String link = "https://newsapi.org/v2/everything?q=badminton&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
        retrofitSetupVertical(recyclerView, link, requireActivity());
        return v;
    }
}
