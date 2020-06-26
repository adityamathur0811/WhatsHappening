
package com.aditya.whatshappening.HomeTabFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.RetrofitCode.MyRetrofit;

public class CountryEntartainment extends Fragment implements MyRetrofit {

    RecyclerView recyclerView;
    String link = "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";

    public CountryEntartainment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_country_entartainment, container, false);
        recyclerView = layout.findViewById(R.id.recyclerFromCEntertainment);
        retrofitSetupHorizontal(recyclerView, link, requireActivity());
        return layout;
    }

}
