package com.prio.chandanaish;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewBaseAdapter extends BaseAdapter {
    private final ArrayList<HashMap<String, String>> dataList;
    private final Context context;
    private final LayoutInflater inflater;

    public ListViewBaseAdapter(Context context, ArrayList<HashMap<String, String>> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        String type = dataList.get(position).get("type");

        if (convertView == null) {
            switch (type) {
                case "sectionCardOne":
                    convertView = inflater.inflate(R.layout.demo_list_view_call, parent, false);
                    holder = new ViewHolder(convertView, type);
                    break;
                case "sectionCardTwo":
                    convertView = inflater.inflate(R.layout.doctordemolist, parent, false);
                    holder = new ViewHolder(convertView, type);
                    break;
                case "sectionCardThree":
                    convertView = inflater.inflate(R.layout.demoimage, parent, false);
                    holder = new ViewHolder(convertView, type);
                    break;
                case "touristSpot":
                    convertView = inflater.inflate(R.layout.tourist_spot, parent, false);
                    holder = new ViewHolder(convertView, type);
                    break;
                default:
                    convertView = inflater.inflate(R.layout.demo_list_view_call, parent, false);
                    holder = new ViewHolder(convertView, type);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data based on type
        HashMap<String, String> itemData = dataList.get(position);
        bindViewHolder(holder, itemData, type);

        return convertView;
    }
    private void bindViewHolder(ViewHolder holder, HashMap<String, String> itemData, String type) {
        switch (type) {
            case "sectionCardOne":
                setTextIfNotNull(holder.title, itemData.get("title"));
                setTextIfNotNull(holder.shortDescription, itemData.get("shortDescription"));
                setTextIfNotNull(holder.description, itemData.get("description"));
                break;
            case "sectionCardTwo":
                setTextIfNotNull(holder.title, itemData.get("title"));
                setTextIfNotNull(holder.shortDescription, itemData.get("shortDescription"));
                setTextIfNotNull(holder.description, itemData.get("description"));
                handlePhoneNumber(holder, itemData);
                break;
            case "sectionCardThree":
            case "touristSpot":
                if (holder.imageView != null) {
                    String imageUrl = itemData.get("imageUrl");
                    Picasso.get().load(imageUrl).fit().into(holder.imageView);
                }
                break;
        }
    }
    private void handlePhoneNumber(ViewHolder holder, HashMap<String, String> itemData) {
        String phoneNumber = itemData.get("phoneNumber");
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            holder.call.setText(phoneNumber);
            holder.callSection.setVisibility(View.VISIBLE);
            holder.call.setOnClickListener(v -> {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                context.startActivity(dialIntent);
            });
        } else {
            holder.callSection.setVisibility(View.GONE);
        }
    }
    private static class ViewHolder {
        TextView title, shortDescription, description, call;
        ImageView imageView;
        LinearLayout callSection;

        ViewHolder(View view, String type) {
            if (type.equals("sectionCardOne") || type.equals("sectionCardTwo")) {
                title = view.findViewById(R.id.textView);
                shortDescription = view.findViewById(R.id.textView1);
                description = view.findViewById(R.id.textView2);
                call = view.findViewById(R.id.textView3);
                callSection = view.findViewById(R.id.callSection);
            } else if (type.equals("sectionCardThree") || type.equals("touristSpot")) {
                imageView = view.findViewById(R.id.demoimageimageview);
            }
        }
    }

//    private void bindSectionCardOne(View view, HashMap<String, String> itemData) {
//
//        TextView title = view.findViewById(R.id.textView);
//        TextView shortDescription = view.findViewById(R.id.textView1);
//        TextView description = view.findViewById(R.id.textView2);
//TextView phoneNumber = view.findViewById(R.id.textView3);
//LinearLayout callSection=view.findViewById(R.id.callSection);
//String titleData = itemData.get("title");
//String shortDescriptionData = itemData.get("shortDescription");
//String descriptionData = itemData.get("description");
//String phoneNumberData = itemData.get("phoneNumber");
//
//
//if(titleData!=null) {
//    title.setText(titleData);
//    title.setVisibility(View.VISIBLE);
//}
//if(shortDescriptionData!=null) {
//    shortDescription.setText(shortDescriptionData);
//    shortDescription.setVisibility(View.VISIBLE);
//}
//if(descriptionData!=null) {
//    description.setText(descriptionData);
//    description.setVisibility(View.VISIBLE);
//}
//        if(phoneNumberData!=null) {
//            phoneNumber.setText(phoneNumberData);
//            callSection.setVisibility(View.VISIBLE);
////    phoneNumber.setVisibility(View.VISIBLE);
//
//        }
//}
//
//
////        holder.callSection.setVisibility(View.GONE);
////        holder.demolistwithcall.setVisibility(View.GONE);
////
////        setTextIfNotNull(holder.title, itemData.get("title"));
////        setTextIfNotNull(holder.shortDescription, itemData.get("shortDescription"));
////        setTextIfNotNull(holder.description, itemData.get("description"));
//    }

    private void bindSectionCardTwo(ViewHolder holder, HashMap<String, String> itemData) {
        holder.callSection.setVisibility(View.VISIBLE);

        setTextIfNotNull(holder.title, itemData.get("title"));
        setTextIfNotNull(holder.shortDescription, itemData.get("shortDescription"));

//        Toast.makeText(context, "itemData debug toast"+itemData.get("shortDescription"), Toast.LENGTH_SHORT).show();
        setTextIfNotNull(holder.description, itemData.get("description"));

        String phoneNumber = itemData.get("phoneNumber");
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            holder.call.setText(phoneNumber);
            holder.call.setVisibility(View.VISIBLE);
//            holder.de.setOnClickListener(v -> {
//                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
//                dialIntent.setData(Uri.parse("tel:" + phoneNumber));
//                context.startActivity(dialIntent);
//            });
        } else {
            holder.call.setVisibility(View.GONE);
        }
    }

    private void bindSectionCardThree(View view, HashMap<String, String> itemData) {
        ImageView imageView = view.findViewById(R.id.demoimageimageview);
        LinearLayout layout = view.findViewById(R.id.demoimage);

        String imageUrl = itemData.get("imageUrl");
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get()
                    .load(imageUrl)
                    .fit()
                    .into(imageView);
        }

        String urlLink = itemData.get("url");
        layout.setOnClickListener(v -> {
            Intent intent = new Intent(context, Web.class);
            intent.putExtra("url", urlLink);
            context.startActivity(intent);
        });
    }

    private void setTextIfNotNull(TextView textView, String text) {
        if (text != null) {
            Toast.makeText(context, "text "+text, Toast.LENGTH_SHORT).show();
            textView.setText(text);
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

//    private static class ViewHolder {
//        TextView title, shortDescription, description, call;
//        LinearLayout callSection, demolistwithcall;
//
//        ViewHolder(View view) {
//            title = view.findViewById(R.id.textView);
//            shortDescription = view.findViewById(R.id.textView1);
//            description = view.findViewById(R.id.textView2);
//            call = view.findViewById(R.id.textView3);
//            callSection = view.findViewById(R.id.callSection);
//            demolistwithcall = view.findViewById(R.id.demolistwithcall);
//        }
//    }
}