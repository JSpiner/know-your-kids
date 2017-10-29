package net.jspiner.knowyourkid.ui.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityTimelineBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;

public class TimeLineActivity extends BaseActivity<ActivityTimelineBinding> {

    private TimeLineAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        init();
    }

    private void init(){
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setTitle("TimeLine");

        adapter = new TimeLineAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
}
