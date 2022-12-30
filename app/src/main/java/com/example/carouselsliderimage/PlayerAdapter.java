package com.example.carouselsliderimage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    List<PlayerModelClass> playerModelClasses;
//    PlayerModelClass[] MyPlayer;
    Context context;


    public PlayerAdapter(List<PlayerModelClass> playerModelClasses, Context context) {
        this.playerModelClasses = playerModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view2 = layoutInflater.inflate(R.layout.player_cards,parent,false);
        ViewHolder viewHolder2=new ViewHolder(view2);
        return viewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {
        final PlayerModelClass playerModelClass= playerModelClasses.get(position);
        holder.playerImage.setImageResource(playerModelClass.getImage());
        holder.playerText.setText(playerModelClass.getText());
        holder.playerColor.setBackgroundColor(Color.parseColor(playerModelClass.getColor()));
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(context, playerModelClass.getText(), Toast.LENGTH_SHORT).show();
    }
});

    }

    @Override
    public int getItemCount() {
        return playerModelClasses.size();
    }




    public void filter3List(ArrayList<PlayerModelClass> filtered3List) {
        playerModelClasses=filtered3List;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView playerImage;
        TextView playerText;
        LinearLayout playerColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            playerImage=itemView.findViewById(R.id.player_imge);
            playerText=itemView.findViewById(R.id.player_text);
            playerColor=itemView.findViewById(R.id.player_colors);
        }
    }
}
