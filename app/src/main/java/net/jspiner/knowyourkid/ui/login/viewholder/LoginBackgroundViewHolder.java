package net.jspiner.knowyourkid.ui.login.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.CardLoginBackgroundBinding;

public class LoginBackgroundViewHolder extends RecyclerView.ViewHolder {

    private final int[] imgs = {
            R.drawable.kids_1,
            R.drawable.kids_2,
            R.drawable.kids_3,
            R.drawable.kids_4,
            R.drawable.kids_5,
            R.drawable.kids_6,
    };

    protected CardLoginBackgroundBinding binding;

    public LoginBackgroundViewHolder(View itemView) {
        super(itemView);
    }

    public LoginBackgroundViewHolder(CardLoginBackgroundBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void setData(int position) {
        Glide.with(binding.getRoot().getContext())
                .load(imgs[position % 6])
                .centerCrop()
                .into(binding.image);
    }

}
