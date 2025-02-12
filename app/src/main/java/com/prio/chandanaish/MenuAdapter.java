package com.prio.chandanaish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private final Context context;
    private List<Map<String, Object>> menuItems;

    public MenuAdapter(Context context, List<Map<String, Object>> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    public void updateMenuItems(List<Map<String, Object>> newMenuItems) {
        this.menuItems = newMenuItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (menuItems == null || menuItems.get(position) == null) return;
        Map<String, Object> item = menuItems.get(position);

        String title = (String) item.get("title");
        String imageUrl = (String) item.get("imageUrl");
        String url = (String) item.get("url");
        boolean isClikableLink = Boolean.TRUE.equals(item.get("isClikableLink"));  // Safe handling
        String id = (String) item.get("id");
        holder.cardText.setText(title);

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get()
                    .load(imageUrl)
                    .fit()
                    .into(holder.cardImage);
        } else {
            holder.cardImage.setImageResource(R.drawable.pppp); // Use default image
        }

        Toast.makeText(context,id+"id check",Toast.LENGTH_LONG).show();

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context,id+"id check",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, isClikableLink ? Web.class : ItemList.class);
            intent.putExtra("id",id);
            intent.putExtra("url", url);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
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
