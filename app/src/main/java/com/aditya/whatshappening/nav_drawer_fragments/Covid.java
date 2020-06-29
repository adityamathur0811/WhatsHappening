package com.aditya.whatshappening.nav_drawer_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.retrofit_code.MyRetrofit;

public class Covid extends Fragment implements MyRetrofit {
    private static final String link = "https://newsapi.org/v2/everything?q=covid&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
    RecyclerView recyclerView;

    public Covid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_covid, container, false);
        recyclerView = layout.findViewById(R.id.recyclerFromCovid);
        retrofitSetupVertical(recyclerView, link, requireActivity());
        return layout;
    }


}




