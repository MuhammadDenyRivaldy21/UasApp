package com.qiraht.kuliah.testingapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.qiraht.kuliah.testingapps.model.MatchSchedule.EventsItem;

import java.util.ArrayList;
import java.util.List;

public class ListScheduleAdapter extends RecyclerView.Adapter<ListScheduleAdapter.ListViewHolder> {
    private List<EventsItem> schedule;

    public ListScheduleAdapter(List<EventsItem> schedule) {
        this.schedule = schedule;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schedule_row_item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(schedule.get(position).getStrThumb())
                .apply(new RequestOptions())
                .into(holder.imgSchedule);

        holder.tvSchedule.setText(schedule.get(position).getStrEvent());
    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSchedule;
        TextView tvSchedule;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSchedule = itemView.findViewById(R.id.img_item_schedule);
            tvSchedule = itemView.findViewById(R.id.tv_schedule_name);
        }
    }
}
