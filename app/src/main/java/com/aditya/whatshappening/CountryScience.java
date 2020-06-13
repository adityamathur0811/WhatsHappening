
package com.aditya.whatshappening;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class CountryScience extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;
    String link="https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";


    public CountryScience() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_science, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromCScience);
        retrofitSetupHorizontal(recyclerView,link, requireActivity());

        return view;
    }
}
