package com.test.questway.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.test.questway.adapter.QuestGridAdapter;
import com.test.questway.model.Photo;
import com.test.questway.ProfileActivity;
import com.test.questway.R;

/**
 * Created by Owner on 7/12/2016.
 */
public class FriendFragment extends Fragment {

    ImageView ivPhoto;
    GridView gvQuests;
    QuestGridAdapter adapter;

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater the LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     *                  The fragment should not add the view itself,
     *                  but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     *
     * @return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friend, container, false);

        ivPhoto = (ImageView) rootView.findViewById(R.id.ivPhoto);
        gvQuests = (GridView) rootView.findViewById(R.id.gridQuests);

        ivPhoto.setImageBitmap(Photo.getCircularBitmap(
                BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.photo_me),
                (int) (ProfileActivity.density * 150)));

        adapter = new QuestGridAdapter(getActivity());
        gvQuests.setAdapter(adapter);
        gvQuests.setNumColumns(2);

        return rootView;
    }
}
