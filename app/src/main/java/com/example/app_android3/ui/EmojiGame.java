package com.example.app_android3.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.app_android3.data.Card;
import com.example.app_android3.data.Game;

import java.util.List;

import static java.util.List.of;

public class EmojiGame {

    private final Game <String> game;

@RequiresApi(api=Build.VERSION_CODES.R)

    public EmojiGame(){
        List<String>content = List.of("\uD83D\uDE08", "\uD83D\uDE00", "\uD83D\uDC7D",

                "\uD83D\uDE3E");

        game =new Game<>(content);
    }

    public void choose(Card<String>card){
        game.choose(card);

    }
    public List<Card<String>> getCards(){

    return game.getCard();
    }
}
