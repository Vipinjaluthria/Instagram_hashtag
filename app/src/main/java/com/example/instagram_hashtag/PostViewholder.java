package com.example.instagram_hashtag;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewholder extends RecyclerView.ViewHolder {
    TextView id;
    ImageView imageView;

    public PostViewholder(@NonNull View itemView) {
        super(itemView);
        id=itemView.findViewById(R.id.text_view);
        imageView=itemView.findViewById(R.id.image_view);
    }
}
