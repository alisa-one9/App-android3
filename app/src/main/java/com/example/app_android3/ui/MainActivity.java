package com.example.app_android3.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.app_android3.R;
import com.example.app_android3.data.Card;



public class MainActivity extends AppCompatActivity implements EmojiCardAdapter.Listener{

    private RecyclerView recyclerView;
    private EmojiCardAdapter adapter;
    private EmojiGame game;
    private TextView textEnd;



    @RequiresApi(api = Build.VERSION_CODES.R)

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
textEnd =findViewById(R.id.textOver);
        recyclerView =findViewById(R.id.cardList);
         game =new EmojiGame();
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getApplicationContext(),
                3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new EmojiCardAdapter(game,this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();
        if(game.getCards().isEmpty()){
            textEnd.setVisibility(View.VISIBLE);
            textEnd.setText("The game is over");
        }
    }
}