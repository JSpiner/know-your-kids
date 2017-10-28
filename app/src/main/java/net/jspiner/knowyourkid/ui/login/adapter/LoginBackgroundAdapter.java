package net.jspiner.knowyourkid.ui.login.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.ui.login.viewholder.LoginBackgroundViewHolder;

public class LoginBackgroundAdapter extends RecyclerView.Adapter<LoginBackgroundViewHolder> {

    @Override
    public LoginBackgroundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LoginBackgroundViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.card_login_background,
                        null,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(LoginBackgroundViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 3 * 20;
    }
}
