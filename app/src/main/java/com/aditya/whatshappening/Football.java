package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class Football extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;

    public Football() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_football, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromFootBall);
        String link = "https://newsapi.org/v2/everything?q=football&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
        retrofitSetupVertical(recyclerView, link, requireActivity());

        return view;
    }
}
