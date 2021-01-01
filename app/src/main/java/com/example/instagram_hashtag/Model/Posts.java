package com.example.instagram_hashtag.Model;

public class Posts {
    String permlink;
    String image;
    String id;
    String caption;

    public Posts(String permlink, String image, String id, String caption) {
        this.permlink = permlink;
        this.image = image;
        this.id = id;
        this.caption = caption;
    }

    public String getPermlink() {
        return permlink;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }
}
