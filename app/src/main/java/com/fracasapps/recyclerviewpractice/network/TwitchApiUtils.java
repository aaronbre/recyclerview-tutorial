package com.fracasapps.recyclerviewpractice.network;

/**
 * Define any constants for your app here api keys, endpoints base url etc
 */
public class TwitchApiUtils {
    public static final String CLIENT_ID = "pedthff27r9lnfyihg2ppu48btkbnw";
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    static final String STREAMS_PATH = "streams";
    static final String FEATURED_STREAMS_PATH = "featured";
    static final String TOP_GAMES_PATH = "games/top";
    static final String CLIENT_ID_PARAM = "client_id";
    static final String GAME_QUERY_PARAM = "game";
    static final String LIMIT_PARAM = "limit";
    static final String LANGUAGE_PARAM = "language";

    static final String CHANNELS_PATH = "channels";

    //this will be used to provide the service, the service will be created by retrofit
    //using the interface you provide
    public static TwitchService createService(){
        return RetrofitClient.getClient(BASE_URL).create(TwitchService.class);
    }
}
