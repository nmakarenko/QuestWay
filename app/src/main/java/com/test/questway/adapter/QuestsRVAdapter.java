package com.test.questway.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.test.questway.R;

/**
 * Created by Owner on 7/14/2016.
 */
public class QuestsRVAdapter extends RecyclerView.Adapter<QuestsRVAdapter.MainViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final OnItemClickListener listener;

    private Activity activity;

    public QuestsRVAdapter(Activity activity, OnItemClickListener listener) {
        this.activity = activity;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ItemViewHolder(LayoutInflater.from(activity).inflate(R.layout.quests_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MainViewHolder viewHolder, final int i) {

        ItemViewHolder mholder = (ItemViewHolder) viewHolder;

        mholder.llListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ItemViewHolder extends MainViewHolder {

        LinearLayout llListItem;

        public ItemViewHolder(View v) {
            super(v);
            llListItem = (LinearLayout) v.findViewById(R.id.llListItem);
        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View v) {
            super(v);
        }
    }
}
