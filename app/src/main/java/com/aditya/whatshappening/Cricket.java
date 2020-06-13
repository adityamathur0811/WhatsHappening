package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class Cricket extends Fragment implements MyRetrofit {
    private final String link = "https://newsapi.org/v2/everything?q=cricket&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
    RecyclerView recyclerView;

    public Cricket() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cricket, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromCricket);
        retrofitSetupVertical(recyclerView, link, requireActivity());
        return view;
    }
}
