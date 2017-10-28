package net.jspiner.knowyourkid.ui.timeline;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.ui.timeline.TimeLineHolder;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineHolder> {

    @Override
    public TimeLineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeLineHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.card_timeline,
                        null,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(TimeLineHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
