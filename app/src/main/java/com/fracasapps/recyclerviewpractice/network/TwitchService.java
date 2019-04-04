package com.fracasapps.recyclerviewpractice.network;

import com.fracasapps.recyclerviewpractice.model.TwitchReturnObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitchService {

    @GET(TwitchApiUtils.STREAMS_PATH)
    Call<TwitchReturnObject> queryStreams(@Query(TwitchApiUtils.QUERY_PARAM) String gameName, @Query(TwitchApiUtils.CLIENT_ID_PARAM) String apiKey);
}
