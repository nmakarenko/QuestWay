package com.test.questway.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.test.questway.ProfileActivity;
import com.test.questway.R;
import com.test.questway.adapter.QuestGridAdapter;
import com.test.questway.adapter.QuestsRVAdapter;
import com.test.questway.model.Photo;

/**
 * Created by Owner on 7/14/2016.
 */
public class OrganizersFragment extends Fragment {

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
        View rootView = inflater.inflate(R.layout.fragment_organizers, container, false);

        gvQuests = (GridView) rootView.findViewById(R.id.gridQuests);

        adapter = new QuestGridAdapter(getActivity());
        gvQuests.setAdapter(adapter);
        gvQuests.setNumColumns(2);

        return rootView;
    }
}
