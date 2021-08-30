package com.example.app_android3.ui;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_android3.R;
import com.example.app_android3.data.Card;

@RequiresApi(api = Build.VERSION_CODES.R)

public class EmojiCardAdapter extends RecyclerView.Adapter<EmojiCardAdapter.EmojiCardVH> {

    private  EmojiGame game = new EmojiGame();
    private Listener listener;

 public EmojiCardAdapter(EmojiGame game,Listener listener){
     this.game =game;
     this.listener=listener;
 }



    @Override
    public EmojiCardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new EmojiCardVH(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiCardVH holder, int position) {
        holder.onBind(game.getCards().get(position));


    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }



    class EmojiCardVH extends RecyclerView.ViewHolder {
        private Listener listener;
        private  TextView tvCard;
        private  EmojiGame game;

        public EmojiCardVH(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener =listener;
            tvCard = itemView.findViewById(R.id.itemCard);
        }

        public void onBind(Card<String> card) {
            itemView.setOnClickListener(v -> {
                listener.cardClick(card);
                notifyDataSetChanged();
            });
            if (card.isFaceUp()) {
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            } else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }

        }

    }
    interface Listener {
        void cardClick(Card<String> card);
    }

}






