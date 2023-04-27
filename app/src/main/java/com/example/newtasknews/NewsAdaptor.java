package com.example.newtasknews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.NewsViewHolder> {
    Context newsContext;
    ArrayList<NewsModel> news;
    View view;
    Boolean viewHorizontal;
    public NewsAdaptor(Context newsContext, ArrayList<NewsModel> news,Boolean viewHorizontal) {
        this.newsContext = newsContext;
        this.news = news;
        this.viewHorizontal = viewHorizontal;
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewHorizontal) {
            view = LayoutInflater.from(newsContext).inflate(R.layout.news_recycler,parent,false);
        } else {
            view = LayoutInflater.from(newsContext).inflate(R.layout.vertical_recycler,parent,false);
        }
        return new NewsViewHolder(view,news);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.newsTitle.setText(news.get(position).getTitle());
        holder.Desc.setText(news.get(position).getTitle());
        holder.newsImage.setImageResource(news.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView newsTitle,Desc;
        ImageView newsImage;
        CardView newsCard;
        ArrayList<NewsModel> news;
        ImageView backBTN;
        public NewsViewHolder(@NonNull View itemView,ArrayList<NewsModel> news) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsImage = itemView.findViewById(R.id.newsImage);
            Desc      = itemView.findViewById(R.id.newsDesc);
            newsCard  = itemView.findViewById(R.id.newsCard);
            itemView.setOnClickListener(this);
            this.news = news;
            backBTN = view.findViewById(R.id.backButton);
        }
        @Override
        public void onClick(View view) {
            int pos = getLayoutPosition();
            singleNewsFragment SNF = new singleNewsFragment(news.get(pos).getTitle(),news.get(pos).getDesc(),news.get(pos).getImage());
            FragmentTransaction transaction = ((AppCompatActivity)itemView.getContext()).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.singleNewsLayout,SNF);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
