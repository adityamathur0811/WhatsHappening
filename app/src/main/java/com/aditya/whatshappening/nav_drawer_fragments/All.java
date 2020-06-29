package com.aditya.whatshappening.nav_drawer_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.retrofit_code.MyRetrofit;

public class All extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;
    public All() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_all, container, false);
        recyclerView=v.findViewById(R.id.all);
        String link = "https://newsapi.org/v2/everything?q=sports&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
        retrofitSetupVertical(recyclerView, link, requireActivity());
        return v;
    }
}
