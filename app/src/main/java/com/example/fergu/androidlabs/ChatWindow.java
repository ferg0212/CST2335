package com.example.fergu.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static com.example.fergu.androidlabs.R.id.listView;


public class ChatWindow extends Activity {

    protected static final String ACTIVITY_NAME = "ChatWindowActivity";
    EditText text;
    ChatAdapter messageAdapter;
    ArrayList<String> chatMessages = new ArrayList<>();
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        ListView list = (ListView) findViewById(listView);
        Button sendButton = (Button) findViewById(R.id.sendButton);
        text = (EditText)findViewById(R.id.chatText);
        messageAdapter = new ChatAdapter(this);
        list.setAdapter(messageAdapter);
        chatMessages = new ArrayList<>();
        sendButton.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View v){
                chatMessages.add(text.getText().toString());
                messageAdapter.notifyDataSetChanged();

                text.setText("");
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In OnResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In OnDestroy()");

    }

    private class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx){
           super(ctx, 0);
        }
        public int getCount(){
            return chatMessages.size();
        }
        public String getItem(int position){
            return chatMessages.get(position);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result;
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);


            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);


            message = (TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;

        }

    }


}