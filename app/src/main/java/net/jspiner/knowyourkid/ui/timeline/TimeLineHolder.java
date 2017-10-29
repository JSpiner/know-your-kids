package net.jspiner.knowyourkid.ui.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.CardLoginBackgroundBinding;
import net.jspiner.knowyourkid.databinding.CardMainListBinding;
import net.jspiner.knowyourkid.databinding.CardTimelineBinding;

public class TimeLineHolder extends RecyclerView.ViewHolder {

    private CardTimelineBinding binding;
    private final int[] imgs = {
            R.drawable.kid_1,
            R.drawable.kid_2,
            R.drawable.kid_3,
            R.drawable.kid_4,
            R.drawable.kid_5,
            R.drawable.kid_6,
            R.drawable.kid_7,
            R.drawable.kid_8,
    };

    public TimeLineHolder(View itemView) {
        super(itemView);
    }

    public TimeLineHolder(CardTimelineBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void setData(int position) {
        Glide.with(binding.getRoot().getContext())
                .load(imgs[position % 8])
                .centerCrop()
                .into(binding.image);
    }

}
