package com.aditya.whatshappening.home_tab_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.retrofit_code.MyRetrofit;

public class CountryTopNews extends Fragment implements MyRetrofit {

    RecyclerView recyclerView;
    String link;

    public CountryTopNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_top_news, container, false);
        recyclerView = view.findViewById(R.id.recyclerFromCTopNews);
        link = getArguments().getString("link");
        assert link != null;
        retrofitSetupHorizontal(recyclerView, link, requireActivity());
        return view;
    }
}
