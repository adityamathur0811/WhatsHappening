package com.aditya.whatshappening.NavDrawerFagments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.R;
import com.aditya.whatshappening.RetrofitCode.MyRetrofit;

public class BasketBall extends Fragment implements MyRetrofit {
    RecyclerView recyclerView;
    public BasketBall() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_basket_ball, container, false);
        recyclerView=v.findViewById(R.id.BasketBall);
        String link = "https://newsapi.org/v2/everything?q=basketball&apiKey=69fad831d28b4ea0bd2d960bf3b7ac3a";
        retrofitSetupVertical(recyclerView, link, requireActivity());
        return v;

    }
}
