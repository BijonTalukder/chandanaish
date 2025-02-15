package com.prio.chandanaish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private List<Map<String, Object>> menuItems;
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_MENU_ITEM = 0;

    public MenuAdapter(Context context, List<Map<String, Object>> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    public void updateMenuItems(List<Map<String, Object>> newMenuItems) {
        this.menuItems = newMenuItems;
        notifyItemRangeChanged(0, newMenuItems.size());
    }

    @Override
    public int getItemViewType(int position) {
        Object type = menuItems.get(position).get("type");
        return "banner".equals(type) ? TYPE_BANNER : TYPE_MENU_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_BANNER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner, parent, false);
            return new BannerViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
            return new MenuViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Map<String, Object> item = menuItems.get(position);
        if (item == null) return;

        if (getItemViewType(position) == TYPE_BANNER) {
            BannerViewHolder bannerHolder = (BannerViewHolder) holder;
            List<String> imageUrls = (List<String>) item.get("imageUrls");
            List<SlideModel> slideModels = new ArrayList<>();

            if (imageUrls != null && !imageUrls.isEmpty()) {
                for (String imageUrl : imageUrls) {
                    slideModels.add(new SlideModel(imageUrl, ScaleTypes.FIT));
                }
            } else {
                slideModels.add(new SlideModel("https://example.com/default_banner.jpg", ScaleTypes.FIT));
            }
            bannerHolder.imageSlider.setImageList(slideModels);
        } else {
            MenuViewHolder menuHolder = (MenuViewHolder) holder;
            String title = (String) item.get("title");
            String imageUrl = (String) item.get("imageUrl");
            String url = (String) item.get("url");
            boolean isClickableLink = Boolean.TRUE.equals(item.get("isClickableLink"));
            String id = (String) item.get("id");

            menuHolder.cardText.setText(title != null ? title : "Untitled");
            if (imageUrl != null && !imageUrl.isEmpty()) {
                Picasso.get().load(imageUrl).fit().into(menuHolder.cardImage);
            } else {
                menuHolder.cardImage.setImageResource(R.drawable.pppp); // Default placeholder image
            }

            menuHolder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, isClickableLink ? Web.class : ItemList.class);
                intent.putExtra("id", id);
                intent.putExtra("url", url);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    // ViewHolder for banner type
    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageSlider imageSlider;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSlider = itemView.findViewById(R.id.image_slider);
        }
    }

    // ViewHolder for menu item type
    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView cardText;
        ImageView cardImage;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            cardText = itemView.findViewById(R.id.cardText);
            cardImage = itemView.findViewById(R.id.cardImage);
        }
    }
}
