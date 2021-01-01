package com.example.instagram_hashtag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram_hashtag.Model.Posts;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostViewholder> {
    List<Posts> postsList;

    public PostsAdapter(List<Posts> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.postsview,parent,false);
        return new PostViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewholder holder, int position) {
        holder.id.setText(postsList.get(position).getPermlink());
        Picasso.get().load(postsList.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
