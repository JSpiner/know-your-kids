package net.jspiner.knowyourkid.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.jspiner.knowyourkid.databinding.CardLoginBackgroundBinding;
import net.jspiner.knowyourkid.databinding.CardMainListBinding;

public class MainViewHolder extends RecyclerView.ViewHolder {

    protected CardMainListBinding binding;

    public MainViewHolder(View itemView) {
        super(itemView);
    }


    public MainViewHolder(CardMainListBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void setData(){

    }

}
