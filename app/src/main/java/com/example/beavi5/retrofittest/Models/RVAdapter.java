package com.example.beavi5.retrofittest.Models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beavi5.retrofittest.R;
import com.example.beavi5.retrofittest.retrofit.models.Player;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by beavi5 on 21.09.2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlayerHolder> {
Player[] players;

    public RVAdapter(Player[] players) {
        this.players = players;
    }

    @Override
    public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlayerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.player_row, parent,false));
    }

    @Override
    public void onBindViewHolder(PlayerHolder holder, int position) {

        holder.nickNameTV.setText(players[position].getPersonaname());
        holder.accountIdTV.setText(players[position].getAccountId().toString());
        Picasso.with(holder.itemView.getContext()).load(players[position].getAvatarfull()).into(holder.avatarIV);

    }

    @Override
    public int getItemCount() {
        return players.length;
    }

    class PlayerHolder extends RecyclerView.ViewHolder{
        TextView accountIdTV;
        TextView nickNameTV;
        ImageView avatarIV;
        public PlayerHolder(View itemView) {
            super(itemView);
            accountIdTV = itemView.findViewById(R.id.accountIdTV);
            nickNameTV = itemView.findViewById(R.id.nicknameTV);
            avatarIV = itemView.findViewById(R.id.avatarIV);
        }
    }

}
