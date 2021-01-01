package com.example.instagram_hashtag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.instagram_hashtag.Model.Posts;
import com.facebook.AccessToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    String url="https://graph.facebook.com/v9.0/17842159696070100/top_media?user_id=17841401380563890&fields=id,permalink,media_url,media_type&access_token=";
    private RequestQueue requestQueue;
    private ArrayList<Posts> postsList;
    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        requestQueue= Volley.newRequestQueue(this);
        String v=AccessToken.getCurrentAccessToken().getToken();
        url=url+v;
        Toast.makeText(this, ""+v, Toast.LENGTH_SHORT).show();
        fetch();
    }
    private void fetch() {
        postsList=new ArrayList<>();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("data");
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject data=jsonArray.getJSONObject(i);
                                postsList.add(new Posts(data.getString("permalink"),data.getString("media_url"),data.getString("id"),"vipin"));
                            }

                            postsAdapter=new PostsAdapter(postsList);
                            recyclerView.setAdapter(postsAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("vipin",e.toString());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("vipin",error.toString());
            }
        });
    requestQueue.add(jsonObjectRequest);
    }
}