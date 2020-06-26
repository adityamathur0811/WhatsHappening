package com.aditya.whatshappening.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.whatshappening.RetrofitCode.Article;
import com.aditya.whatshappening.R;
import com.aditya.whatshappening.WebViewCode.Web;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Article> list;
    Activity activity;
    String orientation;

   public MyAdapter(List<Article> list, Activity activity,String orientation) {
        this.activity = activity;
        this.list = list;
        this.orientation=orientation;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if (orientation.equalsIgnoreCase("vertical"))
       {
           View view = activity.getLayoutInflater().inflate(R.layout.cardview, parent, false);
           return new ViewHolder(view);
       }
       else {
           View view = activity.getLayoutInflater().inflate(R.layout.cardview2, parent, false);
           return new ViewHolder(view);
       }

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String author = list.get(position).getAuthor();
        String link = list.get(position).getUrl();
        String image=list.get(position).getUrlToImage();
        String description = list.get(position).getDescription();
        try {
            if (description!=null) {
                holder.textView.setText("" + description);
            } else {
                holder.textView.setText("loading...");
            }

            Log.d("dd", "" + link);
            Glide.with(activity).load(image).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
            //Toast.makeText(activity, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Web.class);
            intent.putExtra("link", link);
            intent.putExtra("author", author);
            activity.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.displayImage);
            textView = itemView.findViewById(R.id.displayText);

        }
    }
}
