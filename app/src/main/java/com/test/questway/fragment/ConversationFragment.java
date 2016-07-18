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
import android.widget.EditText;
import android.widget.GridView;

import com.test.questway.R;
import com.test.questway.adapter.ChatsGridAdapter;
import com.test.questway.adapter.MessagesRVAdapter;

import java.util.ArrayList;

/**
 * Created by Owner on 7/15/2016.
 */
public class ConversationFragment extends Fragment {

    EditText etMsg;
    Button btSend;
    RecyclerView rvMessages;

    MessagesRVAdapter adapterMessages;

    ArrayList<String> messages;

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

        messages = new ArrayList<>();
        View rootView = inflater.inflate(R.layout.fragment_conversation, container, false);
        rvMessages = (RecyclerView) rootView.findViewById(R.id.rvMessages);
        etMsg = (EditText) rootView.findViewById(R.id.etMsg);
        btSend = (Button) rootView.findViewById(R.id.btSend);

        adapterMessages = new MessagesRVAdapter(getActivity(), messages, new MessagesRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMessages.setLayoutManager(layoutManager);
        rvMessages.setAdapter(adapterMessages);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMsg.getText().toString();
                if (!message.equals("")) {
                    etMsg.setText("");
                    messages.add(message);
                    adapterMessages.notifyItemInserted(messages.size() - 1);
                    adapterMessages.notifyItemRangeChanged(messages.size() - 1, messages.size());
                    layoutManager.scrollToPositionWithOffset(messages.size() - 1, 0);
                }
            }
        });

        return rootView;
    }
}

