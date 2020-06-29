package com.aditya.whatshappening.retrofit_code;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RetofitInterface {
    private static final String url = "https://newsapi.org/v2/";

    public static My my = null;


    public static My retrofitInstance() {
        if (my == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            my = retrofit.create(My.class);
        }
        return my;
    }

    public interface My {
        @GET
        Call<Pojo> getArticleList(@Url String id);
    }

}
