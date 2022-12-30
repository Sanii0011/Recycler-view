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

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
      List<TeamModelClass> teamModelClasses;
//    TeamModelClass[] MyTeam;
    Context context;


    public TeamAdapter(List<TeamModelClass> teamModelClasses, Context context) {
        this.teamModelClasses = teamModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view1 = layoutInflater.inflate(R.layout.teams_cards,parent,false);
        ViewHolder viewHolder1=new ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        final TeamModelClass teamModelClass= teamModelClasses.get(position);
        holder.teamImage.setImageResource(teamModelClass.getImage());
        holder.teamText.setText(teamModelClass.getTeamtext());
        holder.linearColor.setBackgroundColor(Color.parseColor(teamModelClass.getColor()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, teamModelClass.getTeamtext(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return teamModelClasses.size();
    }


    public void filter2List(ArrayList<TeamModelClass> filtered2List) {
        teamModelClasses = filtered2List;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView teamImage;
        TextView teamText;
        LinearLayout linearColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            teamImage=itemView.findViewById(R.id.Team_imge);
            teamText=itemView.findViewById(R.id.team_text);
            linearColor=itemView.findViewById(R.id.Linear_colors);
        }
    }
}
