package com.aditya.whatshappening.RetrofitCode;

import android.app.Activity;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.adapter.MyAdapter;

import java.util.List;

import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface MyRetrofit  {
    @EverythingIsNonNull
    default void retrofitSetupHorizontal(RecyclerView recyclerView, String str, Activity activity) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        Call<Pojo> pogoCall = RetofitInterface.retrofitInstance().getArticleList(str);
        pogoCall.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                try {
                    assert response.body() != null;
                    List<Article> list = response.body().getArticles();
                    recyclerView.setAdapter(new MyAdapter(list, activity,"horizontal"));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(activity, "Sorry! your hits of the day is over retry tomorrow", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {

            }
        });
    }
    @EverythingIsNonNull
    default void retrofitSetupVertical(RecyclerView recyclerView, String str, Activity activity) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        Call<Pojo> pogoCall = RetofitInterface.retrofitInstance().getArticleList(str);
        pogoCall.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                try {
                    assert response.body() != null;
                    List<Article> list = response.body().getArticles();
                    recyclerView.setAdapter(new MyAdapter(list, activity,"vertical"));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(activity, "Sorry! your hits of the day is over retry tomorrow", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                Toast.makeText(activity, "something wrong happened", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
