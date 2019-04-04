package com.fracasapps.recyclerviewpractice.network;

public class TwitchApiUtils {
    public static final String CLIENT_ID = "pedthff27r9lnfyihg2ppu48btkbnw";
    private static final String BASE_URL = "https://api.twitch.tv/kraken/";
    static final String STREAMS_PATH = "streams";
    static final String CLIENT_ID_PARAM = "client_id";
    static final String QUERY_PARAM = "game";

    public static TwitchService createService(){
        return RetrofitClient.getClient(BASE_URL).create(TwitchService.class);
    }
}
