package com.example.app_android3.data;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {

            cards.add(new Card<>(i + 1, false, false, contents.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }


    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            checkMatches(card);
        }
    }

    private void checkMatches(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.isFaceUp()
                    && anotherCard.getId() != card.getId()
                    && anotherCard.equals(card)) {
                card.setMatch(true);
                anotherCard.setMatch(true);
                Log.d("tag", "is Match");
                removeCard();
                return;

            } else if (
                    anotherCard.isFaceUp()&& anotherCard.getId()!=card.getId()
                    &&anotherCard.getContent()!=card.getContent()){
            android.os.Handler handler =new Handler();
            handler.postDelayed(()->{
            card.setFaceUp(false);
            anotherCard.setFaceUp(false);
            },400);
            }
        }
    }


    private void removeCard() {
        List<Card<CardContent>> resultCard = new ArrayList<>(cards);
        for (Card<CardContent> c : cards) {
            if (c.isMatch()) {
                resultCard.remove(c);
            }
        }

    }

    public List<Card<CardContent>> getCard() {
        return cards;
    }
}


