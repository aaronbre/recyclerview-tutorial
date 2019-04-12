package com.fracasapps.recyclerviewpractice.network;

import com.fracasapps.recyclerviewpractice.model.TwitchReturnObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Define your endpoints here
 */
public interface TwitchService {
    //annotate with rest methods and pass in the endpoint ex 'popular-movies'
    //Return type should be a Call object with your object as the Generic
    //Queries are passed in with the @query annotation and passing in the query name
    @GET(TwitchApiUtils.STREAMS_PATH)
    Call<TwitchReturnObject> queryStreams(@Query(TwitchApiUtils.GAME_QUERY_PARAM) String gameName,
                                          @Query(TwitchApiUtils.CLIENT_ID_PARAM) String apiKey,
                                          @Query(TwitchApiUtils.LANGUAGE_PARAM) String language);

    @GET(TwitchApiUtils.CHANNELS_PATH + "/{channel_id}")
    Call<TwitchReturnObject> queryChannel(@Path("channel_id") String channel_id,
                                          @Query(TwitchApiUtils.CLIENT_ID_PARAM) String apiKey);
}
