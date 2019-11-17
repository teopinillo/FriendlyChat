package com.teopinillo.friendlychat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private Context context;
    private List<Message> messages;

    MessageAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvMessage.setText(messages.get(position).getText());
        holder.tvSender.setText(messages.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView tvMessage;
         TextView tvSender;
         MyViewHolder(View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            tvSender = itemView.findViewById(R.id.tvAuthor);
        }
    }

}
