package com.example.dohoa.xmlparser.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.dohoa.xmlparser.R;
import com.example.dohoa.xmlparser.databinding.ItemNewsBinding;
import com.example.dohoa.xmlparser.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> listNews;
    private LayoutInflater inflater;

    public NewsAdapter(Context context, ArrayList<News> listNews) {
        this.listNews = listNews;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(listNews.get(position));
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding binding;

        public ViewHolder(ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(News news) {
            binding.tvTitle.setText(news.getTitle());
            binding.tvDesc.setText(news.getDescription());
            binding.tvPubDate.setText(news.getPubDate());
        }
    }
}
