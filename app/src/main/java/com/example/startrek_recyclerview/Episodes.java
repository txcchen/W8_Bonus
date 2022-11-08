package com.example.startrek_recyclerview;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Episodes {
    private String title;
    private String description;
    private String episodeLink;
    private int rating;
    private int image;

    public Episodes(String title, String descript,String link, int rating, int image){
        this.title = title;
        this.description = descript;
        this.episodeLink = link;
        this.rating = rating;
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getEpisodeLink(){
        return episodeLink;
    }

    public int getRating(){
        return rating;
    }

    public int getImage(){
        return image;
    }


}
