package com.example.startrek_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Episodes> episodes;
    RecyclerView rvEpisodes;
    EpisodesAdapter epAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        episodes = new ArrayList<>();
        episodes = (ArrayList<Episodes>) getEpisodes();

        rvEpisodes = findViewById(R.id.rvEpisodes);
        //episodes = Episodes.createEpisodesList(4);

        epAdapter = new EpisodesAdapter(MainActivity.this, this, episodes);
        rvEpisodes.setAdapter(epAdapter);
        rvEpisodes.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    private List<Episodes> getEpisodes(){
        List<Episodes> list = new ArrayList<>();
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[0],
                getResources().getStringArray(R.array.episode_descriptions)[0],
                getResources().getStringArray(R.array.episode_links)[0],
                3,
                R.drawable.spocks_brain));
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[1],
                getResources().getStringArray(R.array.episode_descriptions)[1],
                getResources().getStringArray(R.array.episode_links)[1],
                3,
                R.drawable.st_arena__kirk_gorn));
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[2],
                getResources().getStringArray(R.array.episode_descriptions)[2],
                getResources().getStringArray(R.array.episode_links)[2],
                3,
                R.drawable.st_this_side_of_paradise__spock_in_love));
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[3],
                getResources().getStringArray(R.array.episode_descriptions)[3],
                getResources().getStringArray(R.array.episode_links)[3],
                3,
                R.drawable.st_mirror_mirror__evil_spock_and_good_kirk));
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[4],
                getResources().getStringArray(R.array.episode_descriptions)[4],
                getResources().getStringArray(R.array.episode_links)[4],
                3,
                R.drawable.st_platos_stepchildren__kirk_spock));
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[5],
                getResources().getStringArray(R.array.episode_descriptions)[5],
                getResources().getStringArray(R.array.episode_links)[5],
                3,
                R.drawable.st_the_naked_time__sulu_sword));
        list.add(new Episodes(getResources().getStringArray(R.array.episodes)[6],
                getResources().getStringArray(R.array.episode_descriptions)[6],
                getResources().getStringArray(R.array.episode_links)[6],
                3,
                R.drawable.st_the_trouble_with_tribbles__kirk_tribbles));

        return list;
    }
}