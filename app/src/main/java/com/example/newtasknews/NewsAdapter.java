
package com.example.newtasknews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private static List<News> newsList;
    private OnItemClickListener onItemClickListener;

    public NewsAdapter(Context context, List<News> newsList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.newsList = newsList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_recycler, parent, false);
        return new NewsViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsTitle.setText(news.getTitle());
        holder.newsImage.setImageResource(news.getImage());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView newsImage;
        TextView newsTitle;

        NewsViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsTitle = itemView.findViewById(R.id.newsTitle);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(newsList.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(News news);
    }
}