package com.example.myDemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myDemo.R;
import com.example.myDemo.dulieu.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
    private List<Message> mListMessage;

    public void setData(List<Message> list){
        this.mListMessage = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mListMessage.get(position);
        if (message == null){
            return;
        }
        holder.tvmessage.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        if (mListMessage != null){
            return mListMessage.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        private TextView tvmessage;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvmessage = itemView.findViewById(R.id.tv_message);
        }
    }
}
