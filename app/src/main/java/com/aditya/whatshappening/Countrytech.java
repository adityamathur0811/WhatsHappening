package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class Countrytech extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;
    String link="https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";


    public Countrytech() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countrytech, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recyclerFromCTech);
        retrofitSetupHorizontal(recyclerView, link, requireActivity());

        return view;

    }
}
