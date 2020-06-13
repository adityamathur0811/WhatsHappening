
package com.aditya.whatshappening;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;



public class Search extends Fragment implements MyRetrofit {
    String mikey = "&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
    String startingLInk = "https://newsapi.org/v2/everything?q=";
    RecyclerView recyclerView;
    TextView textView;

    public Search() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.fragment_search, container, false);
        textView = layout.findViewById(R.id.output);
        recyclerView = layout.findViewById(R.id.recyclerFromSearch);
        assert getArguments() != null;
        final String searchedWord = getArguments().getString("Search");
        String finalLink = startingLInk + searchedWord + mikey;
        textView.setText(" "+searchedWord);
        retrofitSetupVertical(recyclerView, finalLink, requireActivity());

        return layout;
    }

}
