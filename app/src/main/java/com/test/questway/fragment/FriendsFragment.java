package com.test.questway.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.questway.adapter.FriendsRVAdapter;
import com.test.questway.R;

/**
 * Created by Owner on 7/11/2016.
 */
public class FriendsFragment extends Fragment {

    RecyclerView rvFriends;
    FriendsRVAdapter adapter;

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
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);

        rvFriends = (RecyclerView) rootView.findViewById(R.id.rvFriends);
        adapter = new FriendsRVAdapter(getActivity(), new FriendsRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FriendFragment fragment = new FriendFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.containerMain, fragment, "")
                        .commit();
            }
        });

        rvFriends.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFriends.setAdapter(adapter);

        return rootView;
    }
}
