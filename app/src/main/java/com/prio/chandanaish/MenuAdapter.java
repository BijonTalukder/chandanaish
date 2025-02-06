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
// Data List



    public MenuAdapter(Context context, List<Map<String, Object>> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }
    public void updateMenuItems(List<Map<String, Object>> newMenuItems) {
        this.menuItems = newMenuItems;
        notifyDataSetChanged();
//        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Map<String, Object> item = menuItems.get(position);

        String title = (String) item.get("title");
        String imageUrl = (String) item.get("imageUrl");
        Toast.makeText(context, "from menu adapter: " + title, Toast.LENGTH_LONG).show();
        holder.cardText.setText(title);

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get()
                    .load(imageUrl)
                    .fit()
                    .into(holder.cardImage);
        } else {
//            holder.cardImage.setImageResource(R.drawable.default_image); // Use your local image here
        };
//        holder.cardImage.setVisibility(View.GONE); // Hide ImageView
//        holder.lottieAnimationView.setVisibility(View.VISIBLE); // Show Lottie
//        holder.lottieAnimationView.setAnimation(R.raw.loading_animation); // Replace with your Lottie JSON file
//        holder.lottieAnimationView.playAnimation();

        String id = (String) item.get("id");

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemList.class);
            intent.putExtra("item", id);
            context.startActivity(intent);
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
//            cardImage = itemView.findViewById(R.id.cardImage);
        }
    }

}
