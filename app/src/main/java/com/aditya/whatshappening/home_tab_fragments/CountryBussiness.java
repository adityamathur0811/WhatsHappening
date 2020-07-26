package com.aditya.whatshappening.home_tab_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.adapter.CenterZoomLayoutManager;
import com.aditya.whatshappening.retrofit_code.MyRetrofit;

public class CountryBussiness extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;
    final String link = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";

    public CountryBussiness() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country_bussiness, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromCBusiness);
        retrofitSetupHorizontal(recyclerView, link, requireActivity());
        return view;
    }
}
