package net.jspiner.knowyourkid.ui.food;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityFoodBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;

public class FoodActivity extends BaseActivity<ActivityFoodBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        init();
    }

    private void init() {
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setTitle("Food");


    }
}
