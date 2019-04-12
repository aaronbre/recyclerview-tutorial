package com.fracasapps.recyclerviewpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.fracasapps.recyclerviewpractice.model.TwitchReturnObject;
import com.fracasapps.recyclerviewpractice.network.TwitchApiUtils;
import com.fracasapps.recyclerviewpractice.network.TwitchService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.fracasapps.recyclerviewpractice.MainActivity.GAME_NAME_EXTRA;

public class ListActivity extends AppCompatActivity {
    //create the service here
    private TwitchService retrofitService = TwitchApiUtils.createService();
    private RecyclerView twitchList;
    private TwitchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String gameName = getIntent().getStringExtra(GAME_NAME_EXTRA);
        if(gameName == null) finish();
        twitchList = findViewById(R.id.twitch_list);
        adapter = new TwitchListAdapter(null);
        twitchList.setAdapter(adapter);

        //to use the service just call one of the interface functions like shown here
        retrofitService.queryStreams(gameName, TwitchApiUtils.CLIENT_ID, "en").enqueue(new Callback<TwitchReturnObject>() {
            @Override
            public void onResponse(Call<TwitchReturnObject> call, Response<TwitchReturnObject> response) {
                adapter.swapLists(response.body().getStreams());
            }

            @Override
            public void onFailure(Call<TwitchReturnObject> call, Throwable t) {
                Log.e("API_FAILURE", "onFailure: ", t);
                Toast.makeText(ListActivity.this, "Error in Api call please Try again", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
