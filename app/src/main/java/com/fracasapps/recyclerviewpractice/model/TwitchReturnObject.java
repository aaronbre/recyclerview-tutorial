package com.fracasapps.recyclerviewpractice.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwitchReturnObject {

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("streams")
    @Expose
    private List<Stream> streams = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

}
