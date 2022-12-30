package com.example.carouselsliderimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    List<IconModelClass> iconModelClasses;
//    IconModelClass[] myIcon;
    Context context;

    public IconAdapter(List<IconModelClass> iconModelClasses, Context context) {
        this.iconModelClasses = iconModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public IconAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.icon_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull IconAdapter.ViewHolder holder, int position) {
 final IconModelClass iconModelClass= iconModelClasses.get(position);
 holder.iconImage.setImageResource(iconModelClass.getIcon());
holder.iconText.setText(iconModelClass.getIcontext());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(context, iconModelClass.getIcontext(), Toast.LENGTH_SHORT).show();
    }
});
    }

    @Override
    public int getItemCount() {
        return iconModelClasses.size();
    }

    public void filterList(ArrayList<IconModelClass> filterdlist) {
        iconModelClasses=filterdlist;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
ImageView iconImage;
TextView iconText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImage);
            iconText=itemView.findViewById(R.id.icon_text);
        }
    }
}
