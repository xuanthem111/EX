package com.example.myDemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myDemo.R;
import com.example.myDemo.thongtin.Achieve;

import java.util.List;

public class AchieveAdapter extends RecyclerView.Adapter<AchieveAdapter.AchieveViewHolder> {
    List<Achieve> mList;

    public AchieveAdapter(List<Achieve> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AchieveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listdata, parent, false);
        return new AchieveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchieveViewHolder holder, int position) {
        Achieve achieve = mList.get(position);
        if (achieve == null){
            return;
        }
        holder.tvTargetName.setText(achieve.getTargetname());
        holder.tvStartDate.setText(achieve.getStartdate());
        holder.tvEndDate.setText(achieve.getEnddate());
        holder.tvTarget.setText(achieve.getTarget());
        holder.tvUsed.setText(achieve.getUsed());
    }

    @Override
    public int getItemCount() {
        if (mList != null){
            mList.size();
        }
        return 0;
    }

    public class AchieveViewHolder extends RecyclerView.ViewHolder{
        TextView tvTargetName, tvStartDate, tvEndDate, tvTarget, tvUsed;
        public AchieveViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStartDate = itemView.findViewById(R.id.tv_startDate);
            tvTargetName = itemView.findViewById(R.id.tv_targetName);
            tvEndDate = itemView.findViewById(R.id.tv_endDate);
            tvTarget = itemView.findViewById(R.id.tv_target);
            tvUsed = itemView.findViewById(R.id.tv_used);
        }
    }
}
