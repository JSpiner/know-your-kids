package net.jspiner.knowyourkid.ui.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.ui.login.viewholder.LoginBackgroundViewHolder;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.card_main_list,
                        null,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
