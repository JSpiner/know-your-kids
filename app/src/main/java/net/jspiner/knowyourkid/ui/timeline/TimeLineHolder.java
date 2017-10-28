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
            R.drawable.kids_1,
            R.drawable.kids_2,
            R.drawable.kids_3,
            R.drawable.kids_4,
            R.drawable.kids_5,
            R.drawable.kids_6,
    };

    public TimeLineHolder(View itemView) {
        super(itemView);
    }

    public TimeLineHolder(CardTimelineBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void setData(int position) {
        if (position == 0) {
            Glide.with(binding.getRoot().getContext())
                    .load(R.drawable.korea_1)
                    .centerCrop()
                    .into(binding.image);
        } else {
            Glide.with(binding.getRoot().getContext())
                    .load(imgs[position % 6])
                    .centerCrop()
                    .into(binding.image);
        }
    }

}
