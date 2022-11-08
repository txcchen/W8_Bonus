package com.example.startrek_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Episodes> episodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        episodes = new ArrayList<>();
        episodes = (ArrayList<Episodes>) getEpisodes();

        RecyclerView rvEpisodes = findViewById(R.id.rvEpisodes);
        //episodes = Episodes.createEpisodesList(4);

        EpisodesAdapter adapter = new EpisodesAdapter(episodes);
        rvEpisodes.setAdapter(adapter);
        rvEpisodes.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    private List<Episodes> getEpisodes(){
        List<Episodes> list = new ArrayList<>();
        list.add(new Episodes("Spock's Brain", "Some people in swimsuits steal Spock's brain",
                "www.google.com", 4, R.drawable.spocks_brain));
        list.add(new Episodes("Arena", "Captain Kirk fights a plastic 3d molded lizard",
                "www.google.com", 4, R.drawable.st_arena__kirk_gorn));
        list.add(new Episodes("This Side of Paradise", "A flower explodes in Spock's face and makes him happy",
                "www.google.com", 4, R.drawable.st_this_side_of_paradise__spock_in_love));

        return list;
    }
}