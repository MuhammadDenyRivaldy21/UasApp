package com.qiraht.kuliah.testingapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.qiraht.kuliah.testingapps.model.MatchResult.EventsItem;

import java.util.List;

public class ListResultAdapter extends RecyclerView.Adapter<ListResultAdapter.ListViewHolder> {
   private List<EventsItem> result;

   public ListResultAdapter(List<EventsItem> result) {
       this.result = result;
   }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_row_item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(result.get(position).getStrThumb())
                .apply(new RequestOptions())
                .into(holder.imgResult);

        holder.tvResult.setText(result.get(position).getStrEvent());

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgResult;
        TextView tvResult;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgResult = itemView.findViewById(R.id.img_item_result);
            tvResult = itemView.findViewById(R.id.tv_result_name);
        }
    }
}
