package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class CountryTopNews extends Fragment implements MyRetrofit {
    String url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
    RecyclerView recyclerView;


    public CountryTopNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_top_news, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromCTopNews);
        retrofitSetupHorizontal(recyclerView, url, requireActivity());
        return view;
    }
}
