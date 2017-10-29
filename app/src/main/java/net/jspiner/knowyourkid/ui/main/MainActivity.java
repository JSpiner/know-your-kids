package net.jspiner.knowyourkid.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarDrawerToggle;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityMainBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;
import net.jspiner.knowyourkid.ui.food.FoodActivity;
import net.jspiner.knowyourkid.ui.notice.NoticeActivity;
import net.jspiner.knowyourkid.ui.play.PlayActivity;
import net.jspiner.knowyourkid.ui.timeline.TimeLineAdapter;
import net.jspiner.knowyourkid.ui.timeline.TimeLineActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private TimeLineAdapter adapter;

    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        setSupportActionBar(binding.toolbar);

        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name);
        binding.drawerLayout.addDrawerListener(toggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toggle.syncState();

        binding.notice.getRoot().setOnClickListener(__ -> startNoticeActivity());
        binding.notification.getRoot().setOnClickListener(__ -> startNoticeActivity());
        binding.menuPicture.getRoot().setOnClickListener(__ -> startTimeLineActivity());
        binding.menuFood.getRoot().setOnClickListener(__ -> startFoodActivity());

        binding.menuActive.getRoot().setOnClickListener(__ -> startPlayActivity());
    }

    private void startTimeLineActivity() {
        Intent intent = new Intent(getBaseContext(), TimeLineActivity.class);
        startActivity(intent);
    }

    private void startNoticeActivity() {
        Intent intent = new Intent(getBaseContext(), NoticeActivity.class);
        startActivity(intent);
    }

    private void startFoodActivity() {
        Intent intent = new Intent(getBaseContext(), FoodActivity.class);
        startActivity(intent);
    }

    private void startPlayActivity() {
        Intent intent = new Intent(getBaseContext(), PlayActivity.class);
        startActivity(intent);
    }
}
