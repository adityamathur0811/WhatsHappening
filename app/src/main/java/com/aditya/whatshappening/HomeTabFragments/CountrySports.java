package com.aditya.whatshappening.HomeTabFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.RetrofitCode.MyRetrofit;

public class CountrySports extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;
    String link = "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";


    public CountrySports() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_sports, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromCSports);
        retrofitSetupHorizontal(recyclerView, link, requireActivity());

        return view;
    }
}
