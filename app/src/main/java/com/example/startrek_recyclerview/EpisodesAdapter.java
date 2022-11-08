package com.example.startrek_recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.ViewHolder> {

    static Context context;
    Activity activity;
    private List<Episodes> myEpisodes;


    public EpisodesAdapter(Activity activity, Context context, List<Episodes> episodes){
        this.context = context;
        this.activity = activity;
        this.myEpisodes = episodes;
    }

    @NonNull
    @Override
    public EpisodesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View episodeView = inflater.inflate(R.layout.item_episode, parent, false);
        ViewHolder viewHolder = new ViewHolder(episodeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //populating the episodeView
        Episodes episode = myEpisodes.get(position);

        //set views
        TextView title = holder.tvTitle;
        title.setText(episode.getTitle());

        TextView description = holder.tvDescription;
        description.setText(episode.getDescription());

        ImageView im = holder.image;
        im.setImageResource(episode.getImage());

        RatingBar rating = holder.rb;
        rating.setRating(episode.getRating());

        String link = episode.getEpisodeLink();
        Log.d("link", link);
        Log.d("title", episode.getTitle());

        holder.currentEpisode = myEpisodes.get(position);

        holder.linearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(link));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            EpisodesAdapter.context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return myEpisodes.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvDescription;
        public ImageView image;
        public RatingBar rb;
        public View view;
        public Episodes currentEpisode;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.epTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.epDescription);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            rb = (RatingBar) itemView.findViewById(R.id.epRating);

            linearLayout = itemView.findViewById(R.id.lvEpisode);

//            view = itemView;
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(webLink));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    EpisodesAdapter.context.startActivity(intent);
//                }
//            });

        }
    }

}
