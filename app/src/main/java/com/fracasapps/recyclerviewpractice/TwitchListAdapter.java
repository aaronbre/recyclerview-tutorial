package com.fracasapps.recyclerviewpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fracasapps.recyclerviewpractice.model.Stream;

import java.util.List;

public class TwitchListAdapter extends RecyclerView.Adapter<TwitchListAdapter.ViewHolder> {
    private List<Stream> streams;

    public TwitchListAdapter(List<Stream> streamList) {
        streams = streamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.list_item_stream, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Stream stream = streams.get(position);
        viewHolder.streamerName.setText(stream.getChannel().getDisplayName());
        viewHolder.gameName.setText(stream.getGame());
        viewHolder.streamStatus.setText(stream.getStreamType());
        viewHolder.currentViewers.setText(stream.getViewers().toString());
    }

    @Override
    public int getItemCount() {
        if(streams == null) return 0;
        return streams.size();
    }

    public void swapLists(List<Stream> newList){
        streams = newList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView streamerName;
        TextView gameName;
        TextView streamStatus;
        TextView currentViewers;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            streamerName = itemView.findViewById(R.id.streamer_name);
            gameName = itemView.findViewById(R.id.stream_game_name);
            streamStatus = itemView.findViewById(R.id.stream_status);
            currentViewers = itemView.findViewById(R.id.stream_viewers);
        }
    }
}