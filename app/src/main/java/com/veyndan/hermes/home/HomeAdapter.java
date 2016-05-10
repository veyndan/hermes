package com.veyndan.hermes.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veyndan.hermes.Comic;
import com.veyndan.hermes.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VH> {

    private final List<Comic> comics;

    HomeAdapter(List<Comic> comics) {
        this.comics = comics;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Context context = holder.itemView.getContext();
        Comic comic = comics.get(position);

        Glide.with(context).load(comic.getImg()).into(holder.img);
        holder.title.setText(comic.getTitle());
        holder.num.setText(String.valueOf(comic.getNum()));
        holder.alt.setText(comic.getAlt());
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img) ImageView img;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.num) TextView num;
        @BindView(R.id.alt) TextView alt;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
