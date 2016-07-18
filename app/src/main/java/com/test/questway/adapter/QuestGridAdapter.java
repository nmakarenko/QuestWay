package com.test.questway.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.questway.ProfileActivity;
import com.test.questway.R;

/**
 * Created by Owner on 7/12/2016.
 */
public class QuestGridAdapter extends BaseAdapter implements AdapterView.OnItemClickListener,View.OnClickListener {

    public Context context;

    //   public ArrayList<LoadedImage> photos = new ArrayList<>();

    public QuestGridAdapter(Context context) {
        this.context = context;
    }

    //  public void addPhoto(LoadedImage photo) {
//        photos.add(photo);
//    }

    public int getCount() {
        return 4;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_quest_item, null);

        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {

    }
}
