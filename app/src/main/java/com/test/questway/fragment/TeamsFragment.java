package com.test.questway.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.questway.R;
import com.test.questway.adapter.TeamsRVAdapter;

/**
 * Created by Owner on 7/12/2016.
 */
public class TeamsFragment extends Fragment {

    RecyclerView rvTeams;
    TeamsRVAdapter adapter;

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
        View rootView = inflater.inflate(R.layout.fragment_teams, container, false);

        rvTeams = (RecyclerView) rootView.findViewById(R.id.rvTeams);
        adapter = new TeamsRVAdapter(getActivity(), new TeamsRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                TeamFragment fragment = new TeamFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.containerMain, fragment, "")
                        .commit();
            }
        });

        rvTeams.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTeams.setAdapter(adapter);

        return rootView;
    }
}
