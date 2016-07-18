package com.test.questway.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.test.questway.R;
import com.test.questway.adapter.ChatsGridAdapter;
import com.test.questway.adapter.ConversationsRVAdapter;
import com.test.questway.adapter.MessagesRVAdapter;

/**
 * Created by Owner on 7/14/2016.
 */
public class MailFragment extends Fragment {

    Button btConversations;
    Button btChats;

    RecyclerView rvConversations;
    GridView gvChats;

    ConversationsRVAdapter adapterConversations;
    ChatsGridAdapter adapterChats;

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
        View rootView = inflater.inflate(R.layout.fragment_mail, container, false);

        btConversations = (Button) rootView.findViewById(R.id.btConversations);
        btChats = (Button) rootView.findViewById(R.id.btChats);

        rvConversations = (RecyclerView) rootView.findViewById(R.id.rvConversations);
        gvChats = (GridView) rootView.findViewById(R.id.gvChats);

        adapterConversations = new ConversationsRVAdapter(getActivity(), new ConversationsRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openChat();
            }
        });
        rvConversations.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvConversations.setAdapter(adapterConversations);

        adapterChats = new ChatsGridAdapter(getActivity());
        gvChats.setAdapter(adapterChats);
        gvChats.setNumColumns(2);

        gvChats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openChat();
            }
        });

        btChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvConversations.setVisibility(View.GONE);
                gvChats.setVisibility(View.VISIBLE);
            }
        });

        btConversations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvConversations.setVisibility(View.VISIBLE);
                gvChats.setVisibility(View.GONE);
            }
        });

        return rootView;
    }

    private void openChat() {
        ConversationFragment fragment = new ConversationFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.containerMain, fragment, "")
                .commit();
    }
}

