package com.prio.chandanaish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private final Context context;


    private final List<MenuItemModel> menuItems;  // Data List

    public MenuAdapter(Context context, List<MenuItemModel> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MenuItemModel item = menuItems.get(position);

        holder.cardText.setText(item.getTitle());  // Set text
        holder.cardImage.setImageResource(item.getImageResId()); // Set image

        holder.itemView.setOnClickListener(v -> {
            // Handle click action
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();  // Return actual item count
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cardText;
        ImageView cardImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardText = itemView.findViewById(R.id.cardText);
            cardImage = itemView.findViewById(R.id.cardImage);
        }
    }
}
