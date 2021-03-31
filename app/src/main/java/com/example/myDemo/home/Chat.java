package com.example.myDemo.home;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myDemo.R;
import com.example.myDemo.adapter.MessageAdapter;
import com.example.myDemo.dulieu.Message;
import com.example.myDemo.mvvm.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    ImageView imgBack;
    RecyclerView rcvMessage;
    MessageAdapter messageAdapter;
    List<Message> mListMessage;
    EditText edtmessage;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat);

        Init();
        BackHome();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMessage.setLayoutManager(linearLayoutManager);
        mListMessage = new ArrayList<>();
        messageAdapter = new MessageAdapter();

        messageAdapter.setData(mListMessage);
        rcvMessage.setAdapter(messageAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        edtmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkKeyBoard();
            }
        });
    }

    private void sendMessage() {
        String strMessage = edtmessage.getText().toString().trim();
        if (TextUtils.isEmpty(strMessage)){
            return;
        }
        mListMessage.add(new Message(strMessage));
        messageAdapter.notifyDataSetChanged();
        rcvMessage.scrollToPosition(mListMessage.size() - 1);

        edtmessage.setText("");
    }

    public void Init(){
        imgBack = findViewById(R.id.img_backchat);
        edtmessage = findViewById(R.id.edt_Message);
        btnSend = findViewById(R.id.btn_send);
        rcvMessage = findViewById(R.id.rcv_message);



    }
    public void BackHome(){
        imgBack.setOnClickListener(v -> {
            Intent intent = new Intent(Chat.this, HomeActivity.class);
            startActivity(intent);
        });
    }
    private void checkKeyBoard(){
        final View activityRootView = findViewById(R.id.activityRoot);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                activityRootView.getWindowVisibleDisplayFrame(r);

                int heightDiff = activityRootView.getRootView().getHeight() - r.height();
                if (heightDiff > 0.25*activityRootView.getRootView().getHeight()){
                    if (mListMessage.size() > 0){
                        rcvMessage.scrollToPosition(mListMessage.size() - 1);
                        activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            }
        });
    }
}