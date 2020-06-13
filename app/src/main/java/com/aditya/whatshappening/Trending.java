package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class Trending extends Fragment implements MyRetrofit {

    RecyclerView recyclerView;

    public Trending() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trending, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromTrending);
        String link = "https://newsapi.org/v2/everything?q=trending&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
        retrofitSetupVertical(recyclerView, link, requireActivity());

        return view;
    }

}
