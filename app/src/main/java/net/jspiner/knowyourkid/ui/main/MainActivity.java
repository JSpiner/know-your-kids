package net.jspiner.knowyourkid.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarDrawerToggle;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityMainBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;
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

        binding.menuPicture.getRoot().setOnClickListener(__ -> {
            startTimeLineActivity();
        });
    }

    private void startTimeLineActivity(){
        Intent intent = new Intent(getBaseContext(), TimeLineActivity.class);
        startActivity(intent);
    }
}
