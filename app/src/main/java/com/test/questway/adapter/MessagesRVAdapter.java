package com.test.questway.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.questway.R;

import java.util.ArrayList;

/**
 * Created by Owner on 7/15/2016.
 */
public class MessagesRVAdapter extends RecyclerView.Adapter<MessagesRVAdapter.MainViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final OnItemClickListener listener;

    private Activity activity;

    ArrayList<String> messages;

    public MessagesRVAdapter(Activity activity, ArrayList<String> messages, OnItemClickListener listener) {
        this.activity = activity;
        this.listener = listener;
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ItemViewHolder(LayoutInflater.from(activity).inflate(R.layout.messages_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MainViewHolder viewHolder, final int i) {
        ItemViewHolder mholder = (ItemViewHolder) viewHolder;
        mholder.tvMessage.setText(messages.get(i));
        mholder.llListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ItemViewHolder extends MainViewHolder {

        LinearLayout llListItem;

        TextView tvMessage;

        public ItemViewHolder(View v) {
            super(v);
            llListItem = (LinearLayout) v.findViewById(R.id.llListItem);
            tvMessage = (TextView) v.findViewById(R.id.tvMessage);
        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View v) {
            super(v);
        }
    }
}
