package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FactCheck extends Fragment implements MyRetrofit{
    RecyclerView recyclerView;

    public FactCheck() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fact_check, container, false);
        recyclerView=v.findViewById(R.id.fact);
        String link = "https://newsapi.org/v2/everything?q=fact%20check&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
        retrofitSetupVertical(recyclerView, link,requireActivity());
        return v;
    }
}
